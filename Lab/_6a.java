package Lab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class _6a {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Lab/numbers.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            Hashtable<String, String> ht = new Hashtable<>();

            while((line = br.readLine()) != null){
                String[] s = line.split("\\s+");
                for(int i=0; i<2; i++){
                    System.out.println(s[i]);
                    ht.put(s[0], s[1]);
                }
            }

            System.out.print("Enter a name: ");
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            System.out.println("Number is: "+ht.get(n));

            System.out.print("Enter a number: ");
            String num = sc.nextLine();
            String foundName = null;
            for(Map.Entry<String, String> entry : ht.entrySet()){
                if(entry.getValue().equals(num)){
                    foundName = entry.getKey();
                }
            }
            if(foundName!=null){
                System.out.println(foundName);
            }
            else{
                System.out.println("Number not found");
            }
        } catch (Exception e) {
            System.out.println("Error while reading file: "+e);
        }
        


    }
}
