package ru.croc.barkhatnat.homework2.task4;

import java.util.Scanner;

public class Main {
    public static long arithmeticProgressionSum(int start, int step, int count) {
        long sum = start;
        for (int i = 1; i < Math.abs(count); i++) {
            sum += start + (long) (step) * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input 3 numbers (separated by spaces) to define an arithmetic progression: " +
                "the initial element, the difference of the a.p. and the number of terms: ");
        String line = scanner.nextLine();
        String[] values = line.split(" ");
        scanner.close();
        try {
            int start = Integer.parseInt(values[0]);
            int step = Integer.parseInt(values[1]);
            int count = Integer.parseInt(values[2]);
            System.out.printf("Sum of terms of the arithmetic progression: %d \n", arithmeticProgressionSum(start, step, count));
        } catch (Exception e) {
            System.out.println("Bad input. Type 3 numbers on one line, separated by space");
        }
    }
}
