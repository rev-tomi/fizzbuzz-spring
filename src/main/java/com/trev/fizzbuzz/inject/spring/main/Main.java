package com.trev.fizzbuzz.inject.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trev.fizzbuzz.inject.spring.FizzBuzzService;

public class Main
{

    public static void main(final String[] args)
    {
        try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("fizzbuzz.spring.xml"))
        {
            final FizzBuzzService fizzBuzzService = context.getBean(FizzBuzzService.class);
            fizzBuzzService.doFizzBuzz();
        }
    }

}
