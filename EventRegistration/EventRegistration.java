package EventRegistration;
import java.util.*;

public class EventRegistration {
    private String name;
    private String nameOfEvent;
    private double registrationFee;

    EventRegistration(String name, String nameOfEvent, double registrationFee){
        this.name = name;
        this.nameOfEvent = nameOfEvent;
        this.registrationFee = registrationFee;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String s){
        this.name = s;
    }

    public String getNameOfEvent(){
        return this.nameOfEvent;
    }

    public void setNameNameOfEvent(String s){
        this.nameOfEvent = s;
    }

    public double getRegistrationFee(){
        return this.registrationFee;
    }

    public void setRegistrationFee(double s){
        this.registrationFee = s;
    }

    public void registerEvent(){
        System.out.println("\nShakeALeg  100\nSing&Win  150\nActathon  70\nPlayAway  130");
    }


    public static void main(String[] args){
        TeamEventRegistration t;
        //  = new TeamEventRegistration("aura", "ShakeALeg", 5,1);
        Scanner sc = new Scanner(System.in);
        System.out.println("What type of registration?\n1. Team Registration\n2. Individual Registration\nEnter option: ");
        int op = sc.nextInt();
        sc.nextLine();

        if(op==1){
            System.out.print("Enter name: ");
            String n = sc.nextLine();

            System.out.print("Enter event name: ");
            String e = sc.nextLine();

            System.out.print("Enter number of participants: ");
            int p  =sc.nextInt();
            // sc.nextLine();

            System.out.print("Enter team number: ");
            int tn  =sc.nextInt();
            sc.nextLine();

            System.out.println(e);
            System.out.println(p);

            t = new TeamEventRegistration(n, e, p, tn);
            t.dispaly();
        } else if(op==2){
            
        }
        
    }
}
