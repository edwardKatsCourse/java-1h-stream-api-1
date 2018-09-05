package com.company.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AfterStreamAPI {

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


        words.stream()
                .distinct()                             //unique
                .filter(word -> word != null)                 //check not null
                .filter(word -> word.length() > 6)            //continue with words > 6 ONLY
                .filter(/*String */word -> word.startsWith("m"))         //continue with words starting with 'm' ONLY
                .sorted(Comparator.reverseOrder())
                .map(word -> word.length())                         //map String -> Integer
                //Stream<Integer>
                .forEach(x -> System.out.println(x));
    }
}
