package Mine.Basics;
import java.util.Random;

public class MathClass {
     public static void main(String[] args) {
        double a = 3.14;
        double y = -10;

        // System.out.println(Math.max(a, y));
        // System.out.println(Math.min(a, y));
        // System.out.println(Math.abs(y));
        // System.out.println(Math.sqrt(Math.abs(y)));
        // System.out.println(Math.round(a));
        // System.out.println(Math.ceil(a));
        // System.out.println(Math.floor(a));
        // System.out.println(Math.pow(a, 2));

        Random rand = new Random();

        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt(7));
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
     }
}