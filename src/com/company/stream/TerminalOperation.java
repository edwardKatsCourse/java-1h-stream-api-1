package com.company.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperation {

    public static void main(String[] args) {
        //Terminal Operations - то, на чем все зачанчивается
        //1. iterators
        //2. search
        //3. matching
        //4. aggregation
        //  - reduce:
        // List<String> => String |{"apple", "grape", "cherry"} -> "apple, grape, cherry"
        // List<Integer> {1, 2, 3, 4} -> ((1+2)+3) + 4) = 10
        //  - collect | toList, toSet, toMap, toCollection(TreeSet::new)

        String s1 = "apple";
        String s2 = "grape";
        String s3 = "cherry";
        String s4 = "pineapple";
        String s5 = "pie";
        String s6 = "shelf";


        List<Word> words = Stream.of(s1, s2, s3, s4, s5, s6)
               .filter(word -> word.length() > 3)
                .map(wordToTransform -> new Word(wordToTransform, wordToTransform.length()))
                .sorted(Comparator.comparing(Word::getName))
                .collect(Collectors.toList());
    }
}

class Word {
    private String name;

    public String getName() {
        return name;
    }

    private Integer length;

    public Word(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
