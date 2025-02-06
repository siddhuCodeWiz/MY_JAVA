// package JavaCollections;
// import java.util.ArrayList;
// import java.util.Collections;

// public class ArrayListPractice {

//     public static void printList(ArrayList<String> ar){
//         // for (String s : ar) {
//         //     System.out.print(s);
//         //     System.out.print(' ');
//         // }
//         // System.out.println();

//         for(int i=0; i<ar.size(); i++){
//             System.out.print(ar.get(i));
//             System.out.print(' ');
//         }
//         System.out.println();
//         return;
//     }
//     public static void main(String[] args) {
//         ArrayList<String> cars = new ArrayList<>();
//         cars.add("Benz");
//         cars.add("BMW");
//         cars.add("Ferrari");
//         cars.add("Toyoto");
//         cars.add("Tesla");

//         System.out.print("1. Elements in array list: ");
//         printList(cars);

//         cars.add(0, "Mercedes");
//         System.out.print("2. After adding element at first index: ");
//         printList(cars);

//         try {
//             cars.remove(5);
//             System.out.print("3. After deleting element at 5th index: ");
//             printList(cars);
//         } catch (IndexOutOfBoundsException e) {
//             System.out.println("4. Given index is larger than the given Array List");
//         }
        
//         Collections.sort(cars);
//         System.out.print("5. Array after sorting: ");
//         printList(cars);
        
//         Collections.shuffle(cars);
//         System.out.print("6. Array after shuffling: ");
//         printList(cars);

//         cars.ensureCapacity(10);
        
//         Collections.reverse(cars);
//         System.out.print("7. List after reversing: ");
//         printList(cars);

//         ArrayList<String> cars1 = new ArrayList<>();
//         cars1.add("BMW");
//         cars1.add("Ferari");
//         cars1.add("Tesla");
//         ArrayList<String> cmp = new ArrayList<>();
//         for(String s: cars){
//             cmp.add(cars1.contains(s) ? "True": "False");
//         }
//         System.out.print("8. Comparing both arrays: ");
//         printList(cmp);

//         Collections.swap(cars, 1, 4);
//         System.out.print("9. Array List after swapping: ");
//         printList(cars);

//         cars1.addAll(cars);
//         System.out.print("10. After extending cars: ");
//         printList(cars);

//         cars1.clear();
//         System.out.println("11. After clearing cars1: ");
//         printList(cars1);

//         System.out.println("12. Element at index 3: "+cars.get(3));

//         // 13
//         cars.set(3, "Ninja");
//         printList(cars);

//         // 14
//         System.out.println(cars.contains("Ninja"));

//         // 15
//         cmp.clear();
//         Collections.copy(cars, cmp);
//         printList(cmp);

//         // 16
//         ArrayList<String> a = new ArrayList<>(cars.subList(1, 4));
//         printList(a);

//         // 17
//         ArrayList<String> clone_new = (ArrayList<String>)cars.clone();
//         printList(clone_new);

//         // 18
//         System.out.println(cars.isEmpty());

//         // 19
//         cars.trimToSize();

//         // 20
//         printList(cars);

//         // 21
        
//     }
// }









package JavaCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ArrayListPractice {

    public static void printList(ArrayList<String> ar){
        for(int i=0; i<ar.size(); i++){
            System.out.print(ar.get(i));
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Benz");
        cars.add("BMW");
        cars.add("Ferrari");
        cars.add("Toyoto");
        cars.add("Tesla");

        System.out.print("1. Elements in array list: ");
        printList(cars);

        cars.add(0, "Mercedes");
        System.out.print("2. After adding element at first index: ");
        printList(cars);

        try {
            cars.remove(5);
            System.out.print("3. After deleting element at 5th index: ");
            printList(cars);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("4. Given index is larger than the given Array List");
        }
        
        Collections.sort(cars);
        System.out.print("5. Array after sorting: ");
        printList(cars);
        
        Collections.shuffle(cars);
        System.out.print("6. Array after shuffling: ");
        printList(cars);

        cars.ensureCapacity(10);
        
        Collections.reverse(cars);
        System.out.print("7. List after reversing: ");
        printList(cars);

        ArrayList<String> cars1 = new ArrayList<>();
        cars1.add("BMW");
        cars1.add("Ferrari");
        cars1.add("Tesla");
        ArrayList<String> cmp = new ArrayList<>();
        for(String s: cars){
            cmp.add(cars1.contains(s) ? "True": "False");
        }
        System.out.print("8. Comparing both arrays: ");
        printList(cmp);

        Collections.swap(cars, 1, 4);
        System.out.print("9. Array List after swapping: ");
        printList(cars);

        cars1.addAll(cars);
        System.out.print("10. After extending cars: ");
        printList(cars1);

        cars1.clear();
        System.out.println("11. After clearing cars1: ");
        printList(cars1);

        System.out.println("12. Element at index 3: "+cars.get(3));

        // 13
        cars.set(3, "Ninja");
        System.out.print("13. After setting element at index 3 to 'Ninja': ");
        printList(cars);

        // 14
        System.out.println("14. Checking if 'Ninja' is present: " + cars.contains("Ninja"));

        // 15
        cmp.clear();
        cmp.addAll(cars);  // Collections.copy() requires both lists to be of the same size
        System.out.print("15. After copying cars to cmp: ");
        printList(cmp);

        // 16
        ArrayList<String> a = new ArrayList<>(cars.subList(1, 4));
        System.out.print("16. SubList from index 1 to 3: ");
        printList(a);

        // 17
        ArrayList<String> clone_new = (ArrayList<String>) cars.clone();
        System.out.print("17. Cloned list: ");
        printList(clone_new);

        // 18
        System.out.println("18. Checking if cars list is empty: " + cars.isEmpty());

        // 19
        cars.trimToSize();
        System.out.print("19. After trimming the capacity: ");
        printList(cars);

        // 20
        System.out.print("20. Final state of cars list: ");
        printList(cars);

        // 21
        String maxElement = Collections.max(cars);
        System.out.println("21. Maximum element in the list: " + maxElement);

        // 22
        String minElement = Collections.min(cars);
        System.out.println("22. Minimum element in the list: " + minElement);

        // 23 - ArrayList of user defined objects
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("John", 25));
        users.add(new User("Alice", 30));
        users.add(new User("Bob", 20));
        System.out.println("23. ArrayList of user defined objects:");
        for (User user : users) {
            System.out.println(user);
        }

        // 24 - Searching for elements in an ArrayList
        boolean containsBMW = cars.contains("BMW");
        System.out.println("24. Does the list contain 'BMW'? " + containsBMW);

        // 25 - Number of elements in an ArrayList
        int numberOfElements = cars.size();
        System.out.println("25. Number of elements in cars list: " + numberOfElements);

        // 26 - Decrease the current capacity of an ArrayList to the current size
        cars.trimToSize();
        System.out.println("26. Decreased capacity to the current size.");

        // 27 - Convert an ArrayList to HashSet
        HashSet<String> carsSet = new HashSet<>(cars);
        System.out.println("27. Converted ArrayList to HashSet: " + carsSet);

        // 28 - Number of elements in ArrayList (already covered in 25)
        System.out.println("28. Number of elements in cars list: " + cars.size());

        // 29 - Get SubList from ArrayList (already covered in 16)
        System.out.print("29. SubList from index 1 to 3: ");
        printList(new ArrayList<>(cars.subList(1, 4)));

        // 30 - Remove Duplicates from ArrayList
        ArrayList<String> carsWithDuplicates = new ArrayList<>(cars);
        carsWithDuplicates.add("BMW");
        carsWithDuplicates.add("Tesla");
        HashSet<String> uniqueCars = new HashSet<>(carsWithDuplicates);
        carsWithDuplicates.clear();
        carsWithDuplicates.addAll(uniqueCars);
        System.out.print("30. List after removing duplicates: ");
        printList(carsWithDuplicates);

        // 31 - Convert an ArrayList to Array
        String[] carsArray = cars.toArray(new String[0]);
        System.out.print("31. Converted ArrayList to Array: ");
        for (String car : carsArray) {
            System.out.print(car + " ");
        }
        System.out.println();

        // 32 - Insert an element at a particular position of an ArrayList
        cars.add(2, "Audi");
        System.out.print("32. After inserting 'Audi' at index 2: ");
        printList(cars);

        // 33 - Remove an element from a particular position of an ArrayList
        cars.remove(2);
        System.out.print("33. After removing element at index 2: ");
        printList(cars);

        // 34 - Remove the given element from an ArrayList
        cars.remove("Ninja");
        System.out.print("34. After removing 'Ninja': ");
        printList(cars);

        // 35 - Remove all elements of an ArrayList at a time
        cars.clear();
        System.out.print("35. After clearing all elements: ");
        printList(cars);

        // Re-populate cars list for remaining operations
        cars.add("Benz");
        cars.add("BMW");
        cars.add("Ferrari");
        cars.add("Toyoto");
        cars.add("Tesla");

        // 36 - Insert more than one element at a particular position of an ArrayList
        ArrayList<String> newCars = new ArrayList<>();
        newCars.add("Lexus");
        newCars.add("Honda");
        cars.addAll(2, newCars);
        System.out.print("36. After inserting 'Lexus' and 'Honda' at index 2: ");
        printList(cars);

        // 37 - Retrieve a portion of an ArrayList (already covered in 16 and 29)
        System.out.print("37. SubList from index 2 to 4: ");
        printList(new ArrayList<>(cars.subList(2, 5)));

        // 38 - Replace a particular element in an ArrayList with the given element
        cars.set(2, "Porsche");
        System.out.print("38. After replacing element at index 2 with 'Porsche': ");
        printList(cars);

        // 39 - Get the position of a particular element in an ArrayList
        int indexOfFerrari = cars.indexOf("Ferrari");
        System.out.println("39. Position of 'Ferrari' in the list: " + indexOfFerrari);

        // 40 - Check whether the given element is present in an ArrayList or not (already covered in 14 and 24)
        boolean containsFerrari = cars.contains("Ferrari");
        System.out.println("40. Does the list contain 'Ferrari'? " + containsFerrari);
    }
}

class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + '}';
    }
}
