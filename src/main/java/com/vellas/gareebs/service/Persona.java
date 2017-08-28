package com.vellas.gareebs.service;


import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.model.TransactionInformation;

import java.util.List;

public interface Persona {
    void add(Transaction t);

    void spend(Transaction t);

    List<Transaction> expenses(int month);

    List<Transaction> expenses();

    List<TransactionInformation> statement(int month);

    void settleUp(Transaction t);
}
