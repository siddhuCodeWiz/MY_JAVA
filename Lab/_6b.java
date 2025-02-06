package Lab;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class _6b {

    static class Vote {
        String language;
        String ip;
        int timestamp;

        public Vote(String language, String ip, int timestamp) {
            this.language = language;
            this.ip = ip;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Vote> votes = new ArrayList<>();

        try {
            fr = new FileReader("Lab/logfile.txt");
            br = new BufferedReader(fr);
            Integer n = Integer.parseInt(br.readLine());
            for (int i=0; i<n; i++){
                String lang = br.readLine().trim();
                String ip = br.readLine().trim();
                int timestamp = Integer.parseInt(br.readLine().trim());

                votes.add(new Vote(lang, ip, timestamp));

            }

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(votes.get(i).language.equals(votes.get(j).language)){
                        if(votes.get(i).ip.equals(votes.get(j).ip)){
                            if(votes.get(j).timestamp - votes.get(i).timestamp <= 20){
                                votes.remove(j);
                                n=n-1;
                                j--;
                            }
                        }
                    }
                }
            }

            HashMap<String, Integer> count  = new HashMap<>();
            for(Vote v : votes){
                count.put(v.language, count.getOrDefault(v.language, 0) + 1);
            }

            for(Map.Entry<String, Integer> entry : count.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error in reading file: "+e);
        }

    }
}
