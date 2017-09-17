package com.vellas.gareebs.service;

import com.vellas.gareebs.model.Coordinator;
import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.util.Util;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class ExpenseDashboardTest {
    private ExpenseDashboard expenseDashboard;
    private Person raj = new Person("Raj");

    @Before
    public void setUp() {
//         expenseDashboard = new service.ExpenseDashboard();

    }

    @Test
    public void testGetBalance() {

    }


    @Test
    public void testDues() throws ParseException {
        Coordinator peopleManager = new Coordinator();
        Person raj = new Person("Raj");
        Person aakash = new Person("Aakash");
        Person hemant = new Person("Hemant");
        peopleManager.add(raj);
        peopleManager.add(aakash);
        peopleManager.add(hemant);
        raj.add(new Transaction(100, Util.getDate("21/07/2014")));
        hemant.spend(new Transaction(600, Util.getDate("21/07/2014")));
        ExpenseDashboard expenseDashboard = new ExpenseDashboard(peopleManager);

        assertEquals(-100 , expenseDashboard.dues(raj));
        assertEquals(-200 , expenseDashboard.dues(aakash));
        assertEquals(400 , expenseDashboard.dues(hemant));

    }

    @Test
    public void testExpensePerPerson() throws ParseException {
        Coordinator peopleManager = new Coordinator();
        Person raj = new Person("Raj");
        Person aakash = new Person("Aakash");
        Person hemant = new Person("Hemant");
        peopleManager.add(raj);
        peopleManager.add(aakash);
        peopleManager.add(hemant);
        raj.add(new Transaction(100, Util.getDate("21/07/2014")));
        hemant.spend(new Transaction(400, Util.getDate("21/07/2014")));
        hemant.spend(new Transaction(200, Util.getDate("21/07/2014")));

        int expense = new ExpenseDashboard(peopleManager).expensePerPerson();
        assertEquals(200, expense);
    }

    @Test
    public void testAddPerson() {
//        expenseDashboard.addPerson(raj);
//
//        assertEquals(1, expenseDashboard.people.size());
    }

}
