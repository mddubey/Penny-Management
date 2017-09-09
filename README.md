# Penny-Management
This is a webapp to keep track expenses .

Assumptions
----

Date Format - '02/07/2015' -> Date/Month/Year
Java Format for this - 'd/M/yyyy'

To convert int to Money

 Requirements:
------
	
* Add service.service ^
* Add ExpenseByPerson ^
* Add AdvanceByPerson ^
* View ExpenseByPerson w/o Month ^
* View Statement ^
* View AmountDueByPeople (for month) 
* View AmountDueByPeople (total)
    
    
Nice To Haves  
----------
Dates in expenditure would be really nice to have.  
Great to see who hasn't paid and send remminders/print values  


Development
-----------

To run: 
```./gradlew build && java -jar build/libs/service.SplitWise.jar 1```

Learning
----

To make gradle work well place all java files in `src/main/java`.
