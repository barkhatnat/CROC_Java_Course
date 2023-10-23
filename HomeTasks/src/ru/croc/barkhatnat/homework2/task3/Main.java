package ru.croc.barkhatnat.homework2.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isPrime(long n) {
        long nSqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTwin(long n) {
        return  isPrime(n + 2) || isPrime(n - 2);
    }

    public static void main(String[] args) {
        //console output for some numbers
        Long[] numbersArray = {2L, 10_000_000_000L, 90L, 881L, 113L};
        for (long number : numbersArray) {
            if (isPrime(number)) {
                if (isTwin(number)) {
                    System.out.println(number + " is prime, twin");
                } else {
                    System.out.println(number + " is prime, NOT twin");
                }
            } else {
                System.out.println(number + " is NOT prime");
            }
        }
    }
}
