package com.vellas.gareebs.service;


import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.model.TransactionInformation;
import com.vellas.gareebs.model.TransactionType;
import com.vellas.gareebs.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person implements Persona {
    private String name;
    private boolean active = true;
    private ArrayList<Transaction> expenditure = new ArrayList<>();
    private ArrayList<Transaction> advance = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String toString() {
        return name + "\t" + advance;
    }

    @Override
    public void add(Transaction transaction) {
        advance.add(transaction);
    }

    @Override
    public void spend(Transaction e) {
        expenditure.add(e);
    }

    @Override
    public List<Transaction> expenses(int month) {
        return expenditure.stream().filter(e -> Util.getMonth(e.date) == month).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> expenses() {
        return Collections.unmodifiableList(expenditure);
    }

    @Override
    public List<TransactionInformation> statement(int month) {
        // TIDBIT (Not here in this code)Comparator.comparing does magic equal to the following - x.date.compareTo(y.date)
        Stream<TransactionInformation> expenditureInformation = expenditure.stream()
                .filter(x -> Util.getMonth(x.date) == month)
                .map(x -> new TransactionInformation(x, TransactionType.CREDIT));

        Stream<TransactionInformation> advanceInformation = advance.stream()
                .filter(x -> Util.getMonth(x.date) == month)
                .map(x -> new TransactionInformation(x, TransactionType.CREDIT));

        AtomicInteger sum = new AtomicInteger(0);
        List<TransactionInformation> transactions = Stream.concat(expenditureInformation, advanceInformation)
                .sorted()
                .map(x -> {
                    x.balance = sum.addAndGet(x.getAmount());
                    return x;
                })
                .collect(Collectors.toList());
        return Collections.unmodifiableList(transactions);
    }

    public List<TransactionInformation> statement() {
        // TIDBIT (Not here in this code)Comparator.comparing does magic equal to the following - x.date.compareTo(y.date)
        Stream<TransactionInformation> expenditureInformation = expenditure.stream()
                .map(x -> new TransactionInformation(x, TransactionType.CREDIT));

        Stream<TransactionInformation> advanceInformation = advance.stream()
                .map(x -> new TransactionInformation(x, TransactionType.CREDIT));

        AtomicInteger sum = new AtomicInteger(0);
        List<TransactionInformation> transactions = Stream.concat(expenditureInformation, advanceInformation)
                .sorted()
                .map(x -> {
                    x.balance = sum.addAndGet(x.getAmount());
                    return x;
                })
                .collect(Collectors.toList());
        return Collections.unmodifiableList(transactions);
    }

    @Override
    public void settleUp(Transaction t) {

    }

//    Transaction getAdvanceForMonth(int month) {
//        Transaction transactionForMonthOf = new Transaction();
//        for (Transaction e : advance) {
//            int expenseForMonth = Util.getMonth(e.date);
//            if (month == expenseForMonth)
//                transactionForMonthOf.add(e);
//        }
//        return transactionForMonthOf;
//    }


    public boolean is(String s) {
        return s.equals(name);
    }
}
