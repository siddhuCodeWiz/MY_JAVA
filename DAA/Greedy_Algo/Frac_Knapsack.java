package DAA.Greedy_Algo;
import java.util.*;
public class Frac_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int maxwt = sc.nextInt();
        ArrayList<Item> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            int wt = sc.nextInt();
            al.add(new Item(val,wt));
        }
        // al.add(new Item(8,8));
        // al.add(new Item(28,7));
        // al.add(new Item(10,5));
        // al.add(new Item(2,4));
        int currwt=0;
        Collections.sort(al, new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                return (int)o2.ratio-(int)o1.ratio;
            }
        });

        double maxVal = 0;

        for(int i=0; i<al.size(); i++){
            if(currwt+al.get(i).wt<maxwt){
                currwt+=al.get(i).wt;
                maxVal+=al.get(i).val;
            } else if(currwt<maxwt){
                maxVal+=((double)al.get(i).val/(double)al.get(i).wt)*(maxwt-currwt);
                currwt+=al.get(i).wt;
            }
        }
        System.out.printf("%.2f", maxVal);
    }
}



class Item{
    int val;
    int wt;
    double ratio;
    Item(int val, int wt){
        this.val = val;
        this.wt = wt;
        this.ratio = (double)val/wt;
    }

    @Override
    public String toString() {
        return this.val+" "+this.wt+" "+this.ratio;
    }
}