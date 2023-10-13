package ru.croc.barkhatnat.homework2.task4;

public class Main {
    public static long arithmeticProgressionSum(int start, int step, int count) {
        long sum = start;
        for (int i = 1; i < Math.abs(count); i++) {
            sum += start + (long) (step) * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arithmeticProgressionSum(3, 4, 5));
        System.out.println(arithmeticProgressionSum(-10000, 10000, 10000));
    }
}
