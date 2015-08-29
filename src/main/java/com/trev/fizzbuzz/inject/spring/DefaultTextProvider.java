package com.trev.fizzbuzz.inject.spring;

public class DefaultTextProvider implements FizzBuzzTextProvider
{

    @Override
    public String getFizzBuzzText(final Integer num)
    {
        if (isDividable(num, 15))
        {
            return "FizzBuzz";
        }
        if (isDividable(num, 5))
        {
            return "Buzz";
        }
        if (isDividable(num, 3))
        {
            return "Fizz";
        }
        return num.toString();
    }

    private boolean isDividable(final int num, final int div)
    {
        return num % div == 0;
    }
}
