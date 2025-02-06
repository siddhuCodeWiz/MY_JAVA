package PlayersClub;
import java.util.*;

public class PlayerRating {
    private int playerPosition;
    private String playerName;
    // private float criticOneRating;
    // private float criticTwoRating;
    // private float criticThreeRating;
    private float averageRating;
    private char category;

    PlayerRating(int playerPosition, String playerName){
        this.playerPosition = playerPosition;
        this.playerName = playerName;
    }

    void calculateAverageRating(float criticOneRating, float criticTwoRating){
        this.averageRating = (criticOneRating+criticTwoRating)/2;
        this.calculateCategory();
    }

    void calculateAverageRating(float criticOneRating, float criticTwoRating, float criticThreeRating){
        this.averageRating = (criticOneRating+criticTwoRating+criticThreeRating)/3;
        this.calculateCategory();
    }

    void calculateCategory(){
        if(this.averageRating>8){
            this.category='A';
        } else if(this.averageRating>8 && this.averageRating<=8){
            this.category='B';
        } else if(this.averageRating>0 && this.averageRating<=5){
            this.category='C';
        } else{
            this.category='F';
        }
    }

    void display(){
        System.out.println("\nThe player name is "+this.playerName+"\nThe player position is "+this.playerPosition+"\nThe avarage rating is "+this.averageRating+"\nThe category is "+this.category);
    }


    public static void main(String[] args){

        PlayerRating pr;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player position: ");
        int pp = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter player name: ");
        String n = sc.nextLine();
        pr = new PlayerRating(pp, n);
        System.out.print("Enter number of critics (2 or 3): ");
        int c = sc.nextInt();
        sc.nextLine();
        
        if(c==2){
            System.out.print("Enter critic one rating: ");
            float cone = sc.nextFloat();
            sc.nextLine();

            System.out.print("Enter critic two rating: ");
            float ctwo = sc.nextFloat();
            sc.nextLine();

            pr.calculateAverageRating(cone, ctwo);
        } else if(c==3){
            System.out.print("Enter critic one rating: ");
            float cone = sc.nextFloat();
            sc.nextLine();

            System.out.print("Enter critic two rating: ");
            float ctwo = sc.nextFloat();
            sc.nextLine();

            System.out.print("Enter critic three rating: ");
            float cthree = sc.nextFloat();
            sc.nextLine();

            pr.calculateAverageRating(cone, ctwo, cthree);
        } else{
            
        }

        pr.display();
    }
}
