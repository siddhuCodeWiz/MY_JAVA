package Interfaces;

/**
 * SecondHotspot
 */
public interface SecondHotspot {
    default void onHotspot(){
        System.out.println("Second Hotspot is on");
    };    
}
