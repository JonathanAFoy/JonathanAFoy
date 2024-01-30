package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    public List<Item> readContentsOfFile(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Item> contents = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String lineData = scanner.nextLine();
                String[] lineDataArr = lineData.split("\\,");

                if (lineDataArr[3].equals("Drink")) {
                    Item drinkItem = new Drink(lineDataArr[0], lineDataArr[1], new BigDecimal(lineDataArr[2]), lineDataArr[3]) ;
                    contents.add(drinkItem);
                } else if (lineDataArr[3].equals("Gum")) {
                    Item gumItem = new Gum(lineDataArr[0], lineDataArr[1], new BigDecimal(lineDataArr[2]), lineDataArr[3]);
                    contents.add(gumItem);
                } else if (lineDataArr[3].equals("Candy")) {
                    Item candyItem = new Candy(lineDataArr[0], lineDataArr[1], new BigDecimal(lineDataArr[2]), lineDataArr[3]);
                    contents.add(candyItem);
                } else if (lineDataArr[3].equals("Munchy")) {
                    Item munchyItem = new Munchy(lineDataArr[0], lineDataArr[1], new BigDecimal(lineDataArr[2]), lineDataArr[3]);
                    contents.add(munchyItem);
                }
            }
            return contents;
        }

    }

}
