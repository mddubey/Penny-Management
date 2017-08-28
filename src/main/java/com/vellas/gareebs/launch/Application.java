package com.vellas.gareebs.launch;


import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.service.SplitWise;

import java.util.Date;
import java.util.Scanner;

class Application {
    private final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        SplitWise splitWise = new SplitWise(null);

        while (true) {
            System.out.println("Options:\n1.Add Transaction by person\n2.View all people\n\n");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    readExpense(splitWise);
                    break;
                case 2:
                    System.out.println(splitWise);
                    break;
                default:
                    break;
            }
        }
    }

    private static void readExpense(SplitWise splitWise) throws Exception {
        System.out.println("Enter name and models in this format - `Name amount`. e.g. `Jon 200`");
        String input = s.next();
        String[] split = input.split(" ");
        Transaction transaction = new Transaction(Integer.parseInt(split[1]), new Date());
//        Person person = splitWise.findPerson(split[0]);
//        splitWise.addExpense(person, transaction);

    }
}
