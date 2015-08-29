package com.trev.fizzbuzz.inject.spring;

public class FizzBuzzService
{

    private FizzBuzzNumberProvider numberProvider;

    private FizzBuzzTextProvider textProvider;

    private FizzBuzzPrinter printer;

    public void doFizzBuzz()
    {
        numberProvider.getFizzBuzzNumbers().forEach(num ->
        {
            final String msg = textProvider.getFizzBuzzText(num);
            printer.printFizzBuzz(msg);
        });
    }

    public void setNumberProvider(final FizzBuzzNumberProvider numberProvider)
    {
        this.numberProvider = numberProvider;
    }

    public void setTextProvider(final FizzBuzzTextProvider textProvider)
    {
        this.textProvider = textProvider;
    }

    public void setPrinter(final FizzBuzzPrinter printer)
    {
        this.printer = printer;
    }

}
