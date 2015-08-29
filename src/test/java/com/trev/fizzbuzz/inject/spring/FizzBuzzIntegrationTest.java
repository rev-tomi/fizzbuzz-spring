package com.trev.fizzbuzz.inject.spring;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.stream.IntStream;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:fizzbuzz.spring.xml"})
public class FizzBuzzIntegrationTest extends AbstractTestNGSpringContextTests
{

    @Mock
    private FizzBuzzPrinter printer;

    @Mock
    private FizzBuzzTextProvider textProvider;

    @Mock
    private FizzBuzzNumberProvider numberProvider;

    @Autowired
    @Qualifier("fizzBuzz")
    private FizzBuzzService sut;

    @BeforeMethod
    void setUp()
    {
        initMocks(this);
        sut.setNumberProvider(numberProvider);
        sut.setPrinter(printer);
        sut.setTextProvider(textProvider);
    }

    @Test
    public void testFoo()
    {
        // GIVEN
        when(numberProvider.getFizzBuzzNumbers()).thenReturn(IntStream.of(1, 2, 3).boxed());
        when(textProvider.getFizzBuzzText(eq(1))).thenReturn("TEST-1");
        when(textProvider.getFizzBuzzText(eq(2))).thenReturn("TEST-2");
        when(textProvider.getFizzBuzzText(eq(3))).thenReturn("TEST-3");

        // WHEN
        sut.doFizzBuzz();

        // THEN
        verify(numberProvider).getFizzBuzzNumbers();

        verify(textProvider).getFizzBuzzText(1);
        verify(printer).printFizzBuzz("TEST-1");

        verify(textProvider).getFizzBuzzText(2);
        verify(printer).printFizzBuzz("TEST-2");

        verify(textProvider).getFizzBuzzText(3);
        verify(printer).printFizzBuzz("TEST-3");
    }

}
