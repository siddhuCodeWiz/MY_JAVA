package Lab;
import java.util.*;

// implements Comparable<Employee>

class Employee{
    String name;
    int exp;

    Employee(String name, int exp){
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString(){
        return "Name: "+this.name+"\nExperience: "+this.exp+"\n";
    }

    // @Override
    // public int compareTo(Employee e){
    //     return this.exp - e.exp;
    // }
}

class compareByExp implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2){
        return e2.name.compareTo(e1.name);
    }
}

public class _8a {
    public static void main(String[] args) {
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Siddharth", 4));
        emps.add(new Employee("Pranav", 7));
        emps.add(new Employee("Suchith", 10));
        emps.add(new Employee("Sravan", 2));

        // Collections.sort(emps);
        Collections.sort(emps, new compareByExp());

        for(int i=0; i<emps.size(); i++){
            System.out.println(emps.get(i).toString()); 
        }
    }
}
