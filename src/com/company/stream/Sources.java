package com.company.stream;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sources {
    //Stream API
    // 1. source (any collection or array)

    // 2. pipe (operations)
    // 3. collectors (sink, terminal operations, actions)

    //Stream
    //1. НЕ КОЛЛЕКЦИЯ, но хранит объекты
    //2. Collection immutability
    //3. Можно использовать только один раз
    //4. Удобно использовать для многопоточного программирования

    //ArrayList -> filter -> filter -> map(person -> email) -> terminal operation
    //откуда -> что делать -> куда складывать

    public static void main(String[] args) {
        //Stream
        //1. How to get Stream??
        //- Out of any collection
        new ArrayList<>().stream();
        new HashSet<>().stream();

        // - Out of an Array
        String [] words = {"apple", "double", "boost", "table"};
        Arrays.stream(words);

        String s1 = "s1";
        String s2 = "s2";
        String s3 = "s3";
        String s4 = "s4";

        // - Stream of nothing #1
        Stream.of(s1, s2, s3, s4);

        //Stream of nothing #2
        Stream stream = Stream.builder()
                .add(s1)
                .add(s2)
                .add(s3)
                .add(s4)
                .build();

        //int vs Integer
        int [] digits = {1, 131, -15, 99, 7123};
        //primitive name + Stream = IntStream, LongStream
        IntStream.of(digits);
        IntStream.of(digits).boxed(); //-> IntStream => String<Integer>

        long longValue = 1L;
        LongStream.of(longValue);

        double doubleValue = 1.0;
        DoubleStream.of(doubleValue);

        // - Out of file
//        new BufferedReader().lines().filter().map()  => lines() -> Stream<String>

        // - Out of regex pattern
        Pattern.compile("\\d+").splitAsStream("1234");

//        varargsExample("apple", "mouse", "");

    }

    //... = []
    //... - var agrs
    public static void varargsExample(String ... args) {
//        args.length
    }

}
