package DAA.Graphs;

/*You are working in a factory, and your task is to schedule the works (jobs) to maximize profit. 
Each job has a unique ID, a deadline (in units of time), and a profit that is earned by completing the job within its deadline. 
There are a limited number of time slots available, and each slot can only hold one job. 

Your task is to Schedule the jobs such that the maximum profit is obtained without missing any job's deadline.

Your goal is to find the maximum profit that can be earned by sequencing the jobs optimally.

Remember, only one task can be executed at a time, and you cannot exceed the available slots.

Input Format:
--------------
Line-1: An integer n representing the number of jobs.
Line-2 to n: Each containing three space-separated integers:
	-Task ID: A unique identifier for each job.
	-Deadline: The latest time (in units) by which the job can be completed.
	-Profit: The profit earned from completing the job.
Line n+1: An integer T representing the number of time slots available (in units of time).

Output Format:
---------------
Line-1: An integer representing the total profit earned by scheduling the jobs.
               
Example 1:
----------
10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
15
output =109

Explanation :
-------------
If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, we can achieve a maximum profit of 109. 
Note that task 2 and task 10 are left out, because they cannot be done in their associated deadlines.

Example 2:
----------
input = 10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
5
output =90 */

import java.util.*;

public class Work_Schedule {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Task> jobs = new ArrayList<>();
        for(int i=0; i<n; i++){
            jobs.add(new Task(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        int availSlots = sc.nextInt();
        Collections.sort(jobs);

        boolean[] isAvailable = new boolean[availSlots];
        for (int i = 0; i < availSlots; i++) {
            isAvailable[i] = true;
        }

        int totalProfit=0;
        for(int i=0; i<n; i++){
            Task curr = jobs.get(i);
            for (int j = Math.min(availSlots -1, curr.deadline- 1); j>= 0; j--){
                if(isAvailable[j]==true){
                    // System.out.print(curr.Id+" ");
                    isAvailable[j]=false;
                    totalProfit+=curr.profit;
                    break;
                }
            }
        }
        System.out.println(totalProfit);
        sc.close();
    }
}

class Task implements Comparable<Task>{
    int Id;
    int deadline;
    int profit;

    Task(int Id, int deadline, int profit){
        this.Id = Id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Task o) {
        return o.profit-this.profit;
    }
}
