package ru.croc.barkhatnat.homework6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, R> R perform(T input, Predicate<T> predicate,
                                   Function<T, R> trueFunction,
                                   Function<T, R> falseFunction) {
        if (predicate.test(input)) {
            return trueFunction.apply(input);
        } else {
            return falseFunction.apply(input);
        }
    }
}
