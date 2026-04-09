package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> numbersWithoutOddNumbers = new ArrayList<>();

        if (!numbers.isEmpty())
            for (Integer number: numbers) if (number % 2 == 0) numbersWithoutOddNumbers.add(number);

        return numbersWithoutOddNumbers;
    }
}
