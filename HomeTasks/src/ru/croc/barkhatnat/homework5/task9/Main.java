package ru.croc.barkhatnat.homework5.task9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BlackListFilterImpl filter = new BlackListFilterImpl();
        List<String> comments = new ArrayList<>();
        comments.add("Плохой комментарий. Просто ужасный.");
        comments.add("Хороший комментарий.");
        comments.add("Это ужасный комментарий. Мне вообще не нравится.");
        comments.add("У тебя ужпсный костюм на Хеллоуин!"); //1 опечатка
        comments.add("У тебя ужастсный костюм на Хеллоуин!"); //больше 1 опечатки
        Set<String> blackList = new HashSet<>();
        blackList.add("плохой");
        blackList.add("ужасный");
        filter.filterComments(comments, blackList);
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
