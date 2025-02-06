package Lab;
import java.util.*;

public class _1c {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Has the player played for India (y/n): ");
        String india = sc.nextLine();
        System.out.println("Has the player played for IPL (y/n): ");
        String ipl = sc.nextLine();

        if(india.equals("y")){
            int tests, odis, mom;
            System.out.print("Enter number of tests played: ");
            tests = sc.nextInt();
            System.out.print("Enter number of ODI's played: ");
            odis = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter man of matches: ");
            mom = sc.nextInt();
            double amt;
            if(tests>10 && odis>100){
                amt=50000;
            }
            else if(tests>10){
                amt=25000;
            }
            else if(odis>15000){
                amt=15000;
            }
            else{
                amt=10000;
            }

            amt = amt+(mom*amt*0.25);
            System.out.print("Amount received by player: "+amt);
        }
        else if(ipl.equals("y")){
            System.out.print("Enter man of matches: ");
            int mom = sc.nextInt();

            double amt=8000;
            amt = amt+(amt*mom*0.25);
            System.out.println("Amount received by player: "+amt);
        }
        else{
            System.out.println("Amount received by player: "+7000);
        }
        sc.close();
    }
}
