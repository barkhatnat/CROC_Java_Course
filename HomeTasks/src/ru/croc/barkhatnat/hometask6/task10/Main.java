package ru.croc.barkhatnat.hometask6.task10;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        BlackListFilter filter = new BlackListFilterImpl();
        ArrayList<String> commentsStringArray = new ArrayList<>();
        commentsStringArray.add("Good comment");
        commentsStringArray.add("Bad comment");
        Predicate<String> isStringCommentBad = (comment) -> {
            final Set<String> blackList = new HashSet<>(List.of("bad"));
            String lowerCaseComment = comment.toLowerCase();
            return blackList.stream().anyMatch(lowerCaseComment::contains);
        };
        record CommentRecord(String text) {
        }

        HashSet<CommentRecord> commentsCommentSet = new HashSet<>(List.of(new CommentRecord("Very good comment"),
                new CommentRecord("Very bad comment"), new CommentRecord("Awful comment")));
        Predicate<CommentRecord> isCommentCommentBad = (comment) -> {
            Set<String> blackList = new HashSet<>(List.of(new CommentRecord("very bad").text, new CommentRecord("awful").text));
            String lowerCaseComment = comment.text.toLowerCase();
            return blackList.stream().anyMatch(lowerCaseComment::contains);
        };
        Collection<String> filteredStringComments = filter.filterComments(commentsStringArray, isStringCommentBad);
        System.out.println(filteredStringComments);
        Collection<CommentRecord> filteredClassComments = filter.filterComments(commentsCommentSet, isCommentCommentBad);
        System.out.println(filteredClassComments);
    }
}
