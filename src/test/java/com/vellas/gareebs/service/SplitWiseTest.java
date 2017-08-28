package com.vellas.gareebs.service;

import com.vellas.gareebs.model.Coordinator;
import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.service.Person;
import com.vellas.gareebs.service.SplitWise;
import com.vellas.gareebs.util.Util;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class SplitWiseTest {
    private SplitWise splitWise;
    private Person raj = new Person("Raj");

    @Before
    public void setUp() {
//         splitWise = new service.SplitWise();

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
        SplitWise splitWise = new SplitWise(peopleManager);

        assertEquals(-100 ,splitWise.dues(raj));
        assertEquals(-200 ,splitWise.dues(aakash));
        assertEquals(400 ,splitWise.dues(hemant));

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

        int expense = new SplitWise(peopleManager).expensePerPerson();
        assertEquals(200, expense);
    }

    @Test
    public void testAddPerson() {
//        splitWise.addPerson(raj);
//
//        assertEquals(1, splitWise.people.size());
    }

}
