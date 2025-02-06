package Mine.Challenges;

import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
// import java.sql.Array;
import java.util.List;

public class strings {
    public static void main(String[] args) {
        System.out.println(concatenate("Today","is","a","good","day"));

        List<String> ls = Arrays.asList("Cat", "Ant", "Rat");
        System.out.println(sortInDescending(ls));
    }

    public static List<String> sortInDescending(List<String> ls){
        System.out.println(ls);
        Collections.sort(ls);
        // Collections.sort(ls, new Comparator<String>() {
        //     @Override
        //     public int compare
        // });
        return ls;
    }

    public static String concatenate(String... vars){
        StringBuilder sb = new StringBuilder();
        for(String i : vars){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
