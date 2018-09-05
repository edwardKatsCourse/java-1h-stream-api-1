package com.company.stream.realestate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class RealEstateReader {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("real-estate.txt"))) {

            String streetParameter = null;

            br.lines() //string
                    .map(x -> {
                        String[] values = x.split(";");
                        return new RealEstate(
                                Integer.parseInt(values[0]),
                                values[1],
                                values[2],
                                Integer.parseInt(values[3]),
                                Integer.parseInt(values[4])
                        );
                    }) //String -> RealEstate
                    .sorted(Comparator.comparing(RealEstate::getId)) //sort by id
                    .filter(x -> x.getPrice() <= 4_000_000) //less or equal 3 million
                    .filter(x -> x.getCity().startsWith("Hai"))
                    .filter(x -> {
                        if (streetParameter == null || streetParameter.isEmpty()) {
                            return true;
                        } else {
                            return x
                                    .getStreet()
                                    .toLowerCase() //Bal bal bAL
                                    .startsWith(streetParameter.toLowerCase());
                        }
                    })
                    .sorted(Comparator.comparing(RealEstate::getPrice).reversed())
                    .limit(10)
                    .forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
