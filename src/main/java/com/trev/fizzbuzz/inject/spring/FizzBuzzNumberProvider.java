package com.trev.fizzbuzz.inject.spring;

import java.util.stream.Stream;

public interface FizzBuzzNumberProvider
{

    Stream<Integer> getFizzBuzzNumbers();
}
