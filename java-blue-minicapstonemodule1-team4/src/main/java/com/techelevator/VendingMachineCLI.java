package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

    private List<Item> itemsList = new ArrayList<>(); //LOOK HERE!!!
    private Service service = new Service();

    private BigDecimal balance = BigDecimal.valueOf(0.00);

    public static void main(String[] args) throws FileNotFoundException {
        VendingMachineCLI CLI = new VendingMachineCLI();
        CLI.run();
    }

    public void run() throws FileNotFoundException {
        System.out.println("Welcome to the Vending Machine 9000!");

        this.itemsList = service.readContentsOfFile("main.csv"); //When program starts reads file, contents becomes itemsList!!
        //Return of service.readContentsOfFile method is what populates itemsList.
        boolean stay = true;
        Scanner mainMenuScanner = new Scanner(System.in);

        while (stay) {
            System.out.println("*** Main Menu ***");
            System.out.println("(1) Display Vending Machine Item");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            String selection = mainMenuScanner.nextLine();

            if (selection.equals("1")) {
                displayVendingItems();

            } else if (selection.equals("2")) {
                purchase();

            } else if (selection.equals("3")) {
                System.out.println("Come back when you got more money, buddy!");
                System.exit(0);

            } else {
                System.out.println("Input 1, 2, or 3.");

            }
        }

    }

    public void displayVendingItems() throws FileNotFoundException {
        System.out.println("");
        System.out.println("*** VENDING MACHINE ITEMS ***");

        for (Item item : itemsList) {
            System.out.println(item.getSlot() + " " + item.getName() + " $" + item.getPrice() + " Quantity Remaining: " + item.quantity);
        }
    }


    public void purchase() throws FileNotFoundException {

        System.out.println("Current Money Provided: $" + balance);
        System.out.println("(1) Feed money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

        Scanner purchaseScanner = new Scanner(System.in);
        String selection = purchaseScanner.nextLine();


        int itemCount = 0;
        boolean stay = true;
        Order order = new Order();

        while (stay) {

            if (selection.equals("1")) {
                System.out.println("Enter amount to feed (Dollars), or Q to stop feeding.");
                Scanner amountToFeed = new Scanner(System.in);
                String amountFed = amountToFeed.nextLine();

                try {
                    if (amountFed.isBlank() || amountFed.equals("0") || amountFed.equalsIgnoreCase("Q")) {
                        break;
                    }
                    BigDecimal amount = new BigDecimal(amountFed);
                    balance = balance.add(amount);
                    System.out.println("Current money provided: $" + balance.setScale(2, RoundingMode.HALF_UP));
                } catch (Exception e) {
                    System.out.println("Please enter a number.");
                }
            }


            if (selection.equals("2")) {
                displayVendingItems();
                boolean notFound = true;
                while (notFound == true) {
                    System.out.println("Select product (Input Slot)");
                    Scanner selectionScanner = new Scanner(System.in);
                    String slotChoice = selectionScanner.nextLine();
                    for (Item item : itemsList) {

                        if (item.slot.equalsIgnoreCase(slotChoice)) { // If item is found...

                            if (item.quantity > 0) {

                                if (balance.compareTo(item.price) != -1) {

                                    item.quantity--;
                                    balance = balance.subtract((item.price));
                                    System.out.println("Only " + item.quantity + " left!");
                                    System.out.println(item.getSound());

                                } else {
                                    System.out.println("You're 'sout' of money, buddy!");
                                }

                            } else {
                                System.out.println("SOLD OUT, SCHMUCK!");
                            }
                            notFound = false;
                            stay = false;
                            break;

                        }

                        }


                    }
                }


                if (selection.equals("3")) {
                    break;

                }


            }


        }
    }



//private static double feedMoney(double amountToAdd) {

//System.out.println("Enter amount to feed (Dollars): ");
//Scanner amountToAdd = new Scanner(System.in);
//double amountFed = Double.parseDouble(amountToFeed.nextLine());
//double balance = amountToAdd + amountFed;

//return balance;














