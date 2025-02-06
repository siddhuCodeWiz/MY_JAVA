package PreFS;

/*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   //number of persons
Alice,23,New York   //name, age, location of a person
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/


public class Day_11 {
    
}






/*
You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000      //name, department,salary
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/







/*
You are tasked with building a Student Score Management System that sorts 
students based on their scores. Each student has multiple test scores: 
a coding test score, MCQ test score, and a total score.

The students should be sorted according to the following rules:
	- Primary Sorting: By total score in descending order.
	- Secondary Sorting: If two students have the same total score, 
	  sort them by coding test score in descending order.
	- Tertiary Sorting: If the coding test scores are also the same, 
	  sort them by MCQ test score in descending order.
	
You must use Java Streams to perform the sorting operation.

Sample Input:
-------------
3               //no of students
Alice,80,70     // name, codingScore, mcqScore
Bob,85,60
Charlie,90,60

Sample Output:
--------------
Charlie: 90, 60, 150
Alice: 80, 70, 150
Bob: 85, 60, 145

*/
