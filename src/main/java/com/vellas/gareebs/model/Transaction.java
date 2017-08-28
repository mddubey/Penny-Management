package com.vellas.gareebs.model;

import java.util.Date;

public class Transaction implements Comparable {
    public int amount;
    public Date date = new Date();

    public Transaction(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "" + amount + " " + date;
    }

    void reduce(Transaction e) {
        amount = amount - e.amount;
    }

    public Transaction add(Transaction x) {
        this.amount = x.amount + this.amount;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        Transaction that = (Transaction) o;
        return this.date.compareTo(that.date);
    }
}
