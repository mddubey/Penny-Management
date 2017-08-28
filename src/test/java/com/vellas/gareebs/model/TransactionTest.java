package com.vellas.gareebs.model;

import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.util.Util;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TransactionTest {
    @Test
    public void testCompareTo() throws Exception {
        Transaction transaction1 = new Transaction(1, Util.getDate("12/07/2012"));
        Transaction transaction2 = new Transaction(1, Util.getDate("13/08/2012"));
        Transaction transaction3 = new Transaction(1, Util.getDate("11/06/2012"));

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);
        List<Transaction> sortedTransactions = transactions.stream().sorted().collect(Collectors.toList());//forEach(System.out::println);

        assertEquals(transaction3 ,sortedTransactions.get(0));
        assertEquals(transaction1 ,sortedTransactions.get(1));
        assertEquals(transaction2 ,sortedTransactions.get(2));
        assertEquals(-1, transaction1.compareTo(transaction2));
    }

}
