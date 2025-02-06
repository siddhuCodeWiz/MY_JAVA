package Lab;
// import java.util.HashMap;
import java.util.*;

class Resistor{
    HashMap<String, Integer> h;
    String b1,b2,b3;
    double val;
    
    Resistor(String b1, String b2, String b3){
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;

        h  = new HashMap<>();
        h.put("black",0);
        h.put("brown",1);
        h.put("red",2);
        h.put("orange",3);
        h.put("yellow",4);
        h.put("green",5);
        h.put("blue",6);
        h.put("voilet",7);
        h.put("grey",8);
        h.put("white",9);


    }

    void calculateValue(){
        int i1 = h.get(b1);
        int i2 = h.get(b2);
        int i3 = h.get(b3);

        System.out.println(i1+i2+" x 10^"+i3+" ohms");
    }
}

public class _2 {
    public static void main(String[] args) {
        Resistor r1 = new Resistor("red", "black", "orange");
        r1.calculateValue();
    }
}
