package com.company.stream;

import java.util.*;

public class BeforeStreamAPI {

    public static void main(String[] args) {
        //Stream API
        //1. unique
        //2. words length > 6
        //3. words starting with letter m
        //3.1. count letters
        //4. sorted by descending 100 .. 0, ascending 0 .. 100

        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("pineapple");
        words.add("apple");
        words.add("laptop");
        words.add("monitor");
        words.add(null);
        words.add("notepad");

        Set<String> setWords = new HashSet<>(words);
        Set<String> greaterThanSixWords = new TreeSet<>(Comparator.reverseOrder());
        for (String word: setWords) {
            if (word == null) {
                continue;
            }
            if (word.length() > 6) {
                greaterThanSixWords.add(word);
            }
        }

        Set<String> wordsStartingFromM = new TreeSet<>(Comparator.reverseOrder());
        for (String word : greaterThanSixWords) {
            if (word.startsWith("m")) {
                wordsStartingFromM.add(word);
            }
        }

        //3.1.
        Set<Integer> lettersCount = new HashSet<>();
        for (String word : wordsStartingFromM) {
            lettersCount.add(word.length());
        }

        for (Integer count : lettersCount) {
            System.out.println(count);
        }
    }
}
