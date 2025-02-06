package University;

public class Person {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private String nationality;

    Person(String name, int age, String gender, double weight, String nationality){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.nationality = nationality;
    }

    public void canTalk(){
        System.out.println(name+" can talk.");
    }

    public void canWalk(){
        System.out.println(name+" can walk.");
    }

    public void canVote(){
        if(age>18){
            System.out.println(name+" can vote.");
        }
        else{
            System.out.println(name+" cannot vote.");
        }
    }

    //Getter methods
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public double getWeight(){
        return weight;
    }

    public String getNationality(){
        return nationality;
    }

    public static void main(String[] args){
        // Example usage
        Person person1 = new Person("Siddharth", 20, "Male", 76.50, "Indian");
        Person person2 = new Person("Alice", 16, "Female", 55.0, "American");

        person1.canTalk();
        person1.canWalk();
        person1.canVote();

        person2.canTalk();
        person2.canWalk();
        person2.canVote();

    }

}
