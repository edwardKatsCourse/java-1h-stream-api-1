package com.company.stream.realestate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RealEstateGenerator {

    private static final List<String> CITIES = Arrays.asList(
            "Tel-Aviv",
            "Ramat-Gan",
            "Haifa",
            "Eilat",
            "Jerusalem",
            "Ashdod"
    );

    private static final List<String> STREETS = Arrays.asList(
            "Rotchild",
            "Weizmann",
            "Dov Hoz",
            "Balfur",
            "Herzl"
    );

    private static final Integer HOUSE_NUMBER_START = 1;
    private static final Integer HOUSE_NUMBER_END = 100; //0 .. 99

    private static final Integer PRICE_START = 2_000_000;
    private static final Integer PRICE_END= 5_000_000;



    public static void main(String[] args) {
        Set<RealEstate> realEstates = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            realEstates.add(getRealEstate(realEstates.size() + 1));
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("real-estate.txt"))) {

            for (RealEstate re : realEstates) {
                bw.write(re.toString());
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static RealEstate getRealEstate(Integer id) {
        return new RealEstate(
                id,
                getRandomCity(),
                getRandomStreet(),
                getRandomHouseNumber(),
                getRandomHousePrice()
                );
    }

    private static String getRandomCity() {
        int randomIndex = new Random().nextInt(CITIES.size());
        return CITIES.get(randomIndex);
    }
    private static String getRandomStreet() {
        int randomIndex = new Random().nextInt(STREETS.size());
        return STREETS.get(randomIndex);
    }
    private static Integer getRandomHouseNumber() {
        return new Random().nextInt(HOUSE_NUMBER_END) + HOUSE_NUMBER_START;
    }

    private static Integer getRandomHousePrice() {
        return new Random().nextInt(PRICE_END) + PRICE_START;
    }
}
