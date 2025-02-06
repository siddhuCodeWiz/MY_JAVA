package Interfaces;

/**
 * Hotspot
 */
public interface Hotspot {
    String password = "kmit";
    int noOfDevices = 10;

    // If we use default method then we can define the meaning of the method
    default void onHotspot(){
        System.out.println("First Hotspot is on");
    };


    void m1();   //Abstract method

    static void staticMethod(){   //Static method also should have a body
        
    }

    private void m2(){   //We can create private methods in interface after JAVA 9

    }

    // Cannot use protected in interface
}
