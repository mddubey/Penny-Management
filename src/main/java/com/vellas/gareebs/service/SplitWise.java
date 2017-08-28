package com.vellas.gareebs.service;


import com.vellas.gareebs.model.Transaction;
import com.vellas.gareebs.model.TransactionInformation;
import com.vellas.gareebs.service.ExpenseSimplifier;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SplitWise implements ExpenseSimplifier {
    private Transaction advance = new Transaction(0, new Date());
    private PeopleManager peopleManager;

    public SplitWise(PeopleManager peopleManager) {
        this.peopleManager = peopleManager;
    }

    @Override
    public List<Transaction> statement() {
        return null;
    }

    @Override
    public List<Transaction> statement(int month) {
        return null;
    }

    @Override
    public int dues(Person person) {
        // Find total expenditure
        // Divide it by total number of people
        // Find my share and subtract/add it from what I paid
        List<TransactionInformation> statement = person.statement();
        if (statement.size() == 0){
            return -1 * expensePerPerson();
        }
        TransactionInformation total = statement.get(statement.size() - 1);

        return total.balance - expensePerPerson();
    }

    public int expensePerPerson(){

        List<Person> people = peopleManager.getPeople();
        Transaction totalExpenses = people.stream()
                .map(Person::expenses)
                .flatMap(Collection::stream)
                .reduce(new Transaction(), Transaction::add);

        return totalExpenses.amount / people.size();
    }
}
