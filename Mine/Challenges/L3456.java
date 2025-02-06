package Mine.Challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L3456 {
    public static void mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> h = new HashMap<>();
        HashMap<String, String> h1 = new HashMap<>();
        
        for(int i=0; i<creators.length; i++){
            if(h.containsKey(creators[i])){
                h.put(creators[i], h.get(creators[i])+views[i]);
            }
            else{
                h.put(creators[i], views[i]);
            }

            h1.putIfAbsent(creators[i], ids[i]);
        }

        int max=-1;
        for(Integer value : h.values()){
            if(max<value){
                max=value;
            }
        }

        List<List<String>> sol = new ArrayList<>();
        List<String> cres;

        for(Map.Entry<String, Integer> entry : h.entrySet()){
            cres = new ArrayList<>();
            if(entry.getValue() == max){
                cres.add(entry.getKey());
                cres.add(h1.get(entry.getKey()));
                sol.add(cres);
            }
            
        }
    }

    public static void main(String[] args) {
        String[] creators={"alice","bob","alice","chris"};
        String[] ids={"one","two","three","four"};
        int[] views={5,10,5,4};
        mostPopularCreator(creators, ids, views);
    }
}
