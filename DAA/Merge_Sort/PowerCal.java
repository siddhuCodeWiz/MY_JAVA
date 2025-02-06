package DAA.Merge_Sort;
// A school kid named John Doe, wants to find the value of N^P
// Pth power of a number N.

// You will be given two integers N and P.
// Your task is to help John Doe to find the value of N^P.

// NOTE:
// ---------
// Value of N and P can be both positive and negative

// Input Format:
// -------------
// Line-1: Two integers N and P, where N is the number and P is the power

// Output Format:
// --------------
// Line-1: Print a float number, N power P


// Sample Input-1:
// ---------------
// 3 2

// Sample Output-1:
// ----------------
// 9.000000


// Sample Input-2:
// ---------------
// 2 -3

// Sample Output-2:
// ----------------
// 0.125000

public class PowerCal {
    public static float calPower(float n, int p){
        if(p==0) return 1;
        if(p<0){
            n = (1/n);
            p = -p;
        };

        float hp = calPower(n, p/2);
        if(p%2==0){
            return hp*hp;
        }
        else{
            return n*hp*hp;
        }
    }
    public static void main(String[] args) {
        // System.out.println(calPower(2, -3));
        System.out.printf("%.6f", calPower(2, -3));
    }
}
