package ru.croc.barkhatnat.homework5.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterImpl implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> censoredComments = new ArrayList<>();
        for (String comment : comments) {
            censoredComments.add(censorComment(comment, blackList));
        }
        comments.clear();
        comments.addAll(censoredComments);
    }

    private String censorComment(String originalComment, Set<String> blackList) {
        String[] words = originalComment.split("[\\s.,?!]+");
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            for (String badWord : blackList) {
                if (lowerCaseWord.equals(badWord) || isMisprintedOnce(lowerCaseWord, badWord)) {
                    int index = originalComment.indexOf(word);
                    String censoredWord = "*".repeat(word.length());
                    StringBuilder censoredComment = new StringBuilder(originalComment);
                    censoredComment.replace(index, index + censoredWord.length(), censoredWord);
                    originalComment = censoredComment.toString();
                }
            }
        }
        return originalComment;
    }

    private boolean isMisprintedOnce(String word, String targetWord) {
        int misprintCount = 0;
        if (Math.abs(word.length() - targetWord.length()) > 0) {
            return false;
        }
        if (word.equals(targetWord)) {
            return false;
        }
        for (int i = 0; i < targetWord.length(); i++) {
            if (misprintCount > 1) {
                break;
            }
            if (word.charAt(i) != targetWord.charAt(i)) {
                misprintCount++;
            }
        }
        return misprintCount == 1;
    }
}
