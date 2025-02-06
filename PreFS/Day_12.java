package PreFS;

/*
You are given a list of Product objects with fields name, category, and price. 
Write a Given a list of Product objects with the following fields:
	- name (String)
	- category (String)
	- price (double)
	- quantityInStock (int)
	
Write a program to filter products where the stock is more than 5 units.
Then group the products by their category, then find the total value of stock 
(price × quantity) for each category and finally find the category with the 
highest total stock value.

Input Format:
-------------
Line-1: AN integer N, number of products.
Next N lines: 3 space separated strings, first is name, 
              second is category and thrid is price and
			  last one is quantity.

Output Format:
--------------
A string, name of the category with highest stock value.


Sample Input:
-------------
5
Laptop Electronics 1000.0 10
Phone Electronics 500.0 5
Shoes Clothing 50.0 20
Jacket Clothing 100.0 10
Blender Home_Appliances 150.0 3

Sample Output:
--------------
Electronics
	
*/


public class Day_12 {
    
}





/*
You are given a list of Student objects, where each Student has the following fields:
	name (String): The name of the student
	subject (String): The subject the student is studying
	grade (double): The student’s grade
	school (String): The school the student belongs to

Tasks to Perform:
	Filter: Select students with a grade greater than 75.
	Map: Add 5 points bonus to their grades.
	GroupBy: Group the students by their school.
	Reduce/Aggregate: Calculate the average grade for each school.
	Aggregator: Identify the student with the highest grade in each school.


Sample Input:
-------------
5					// number of students
Alice Math 80 HPS	// each student infomation.
Bob Science 60 DPS 
Charlie Math 75 HPS
David Science 85 DPS 
Eva Math 95 HPS
	
Sample Output:
--------------
HPS: Eva with grade 100.0
DPS: David with grade 90.0

*/
