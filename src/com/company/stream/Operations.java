package com.company.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    public static void main(String[] args) {
        //.map(): SOURCE_TYPE => DESTINATION_TYPE -> превратить воду в чай
        //.filter(): BOOLEAN -> чего не должно быть
        //.flatMap(): List<List<String>> => List<String> -> list1, list2, list3
        //.peek(): void
        //.limit -> сколько объектов оставить в Stream


        List<List<String>> superList = new ArrayList<>();

        List<String> aLetters = new ArrayList<>();
        aLetters.add("a");
        aLetters.add("a");
        aLetters.add("a");
        aLetters.add("a");

        List<String> bLetters = new ArrayList<>();
        bLetters.add("b");
        bLetters.add("b");
        bLetters.add("b");
        bLetters.add("b");


        //flatten - уплощать: {{1,2,3}, {4,5,6}} -> {1,2,3,4,5,6}
        Stream.of(aLetters, bLetters)
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet())
        .forEach(x -> System.out.println(x));



    }
}
