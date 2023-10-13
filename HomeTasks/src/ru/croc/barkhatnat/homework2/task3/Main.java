package ru.croc.barkhatnat.homework2.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String isPrime(long n) {
        long nSqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return "Составное";
            }
        }
        return "Простое";
    }

    public static String isTwin(long n) {
        if (isPrime(n).equals("Простое") && (isPrime(n + 2).equals("Простое") || isPrime(n - 2).equals("Простое"))) {
            return "Близнец";
        }
        return "НЕ блинзец";
    }

    public static void main(String[] args) {
        //console output for some numbers
        Long[] numbersArray = {2L, 10_000_000_000L, 90L, 881L,113L};
        for (long number:numbersArray) {
            if (isPrime(number).equals("Простое")) {
                System.out.println(number + " " + isPrime(number) + " " + isTwin(number));
            } else {
                System.out.println(number + " " + isPrime(number));
            }
        }
    }
}
