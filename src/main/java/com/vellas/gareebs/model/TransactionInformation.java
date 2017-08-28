package com.vellas.gareebs.model;

import com.vellas.gareebs.model.Transaction;

public class TransactionInformation implements Comparable{
    private Transaction transaction;
    private TransactionType type;
    public int balance;

    public TransactionInformation(Transaction x, TransactionType credit) {
        transaction = x;
        type = credit;

    }

    public int getAmount() {
        if (type == TransactionType.CREDIT)
            return transaction.amount;
        return -1 * transaction.amount;
    }

    @Override
    public String toString() {
        return "models=" + transaction +
                ", type=" + type +
                ", balance=" + balance + "\n";
    }

    @Override
    public int compareTo(Object o) {
        TransactionInformation that = (TransactionInformation)o;
        return this.transaction.compareTo(that.transaction);
    }
}
