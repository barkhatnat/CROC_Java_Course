package ru.croc.barkhatnat.homework6.task12;

import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Function<String, String> up = String::toUpperCase;
        Function<String, String> low = String::toLowerCase;
        Predicate<String> moreUppercase = (str) -> {
            int uppercaseCount = 0, lowercaseCount = 0;
            for (char letter : str.toCharArray()) {
                if (Character.isUpperCase(letter)) {
                    uppercaseCount++;
                } else if (Character.isLowerCase(letter)) {
                    lowercaseCount++;
                }
            }
            return uppercaseCount >= lowercaseCount;
        };
        String result1 = TernaryOperator.perform("Hello", moreUppercase, up, low);
        String result2 = TernaryOperator.perform("HELLo", moreUppercase, up, low);
        System.out.println(result1);
        System.out.println(result2);

        Function<HashSet<Integer>, Integer> sumOfOdd = (list) -> {
            int sum = 0;
            for (Integer number : list) {
                if (number % 2 == 1) {
                    sum += number;
                }
            }
            return sum;
        };
        Function<HashSet<Integer>, Integer> sumOfEven = (list) -> {
            int sum = 0;
            for (Integer number : list) {
                if (number % 2 == 0) {
                    sum += number;
                }
            }
            return sum;
        };
        Predicate<HashSet<Integer>> moreEven = (list) -> {
            int evenCount = 0, oddCount = 0;
            for (Integer number : list) {
                if (number % 2 == 0) {
                    evenCount++;
                } else {
                    evenCount++;
                }
            }
            return evenCount >= oddCount;
        };
        Integer result3 = TernaryOperator.perform(new HashSet<>(List.of(1, 2, 3, 4, 5)), moreEven, sumOfEven, sumOfOdd);
        Integer result4 = TernaryOperator.perform(new HashSet<>(List.of(9, 4, 8, 10, 2)), moreEven, sumOfEven, sumOfOdd);
        System.out.println(result3);
        System.out.println(result4);
    }
}
