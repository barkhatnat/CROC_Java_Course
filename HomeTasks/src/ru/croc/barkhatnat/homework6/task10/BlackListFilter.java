package ru.croc.barkhatnat.homework6.task10;

import java.util.*;
import java.util.function.Predicate;

public interface BlackListFilter{
    default <T> Collection<T> filterComments(Iterable<T> comments, Predicate<T> filtration) {
        if (comments == null) {
            throw new IllegalArgumentException("Comments can't be null");
        }
        Collection<T> filteredComments = new ArrayList<>();
        for (T comment : comments) {
            if (!filtration.test(comment)) {
                filteredComments.add(comment);
            }
        }
        return filteredComments;
    }
}
