package FileIO;
// import java.io.*;

// public class Test {
//     public static void main(String[] args) throws FileNotFoundException,IOException {
//         File f = new File("FileIO/sid.txt", "r");
//         f.createNewFile();
//         FileOutputStream fos = new FileOutputStream(f);
//         fos.write("Hello how are you?".getBytes());
//         fos.close();
//         System.out.println("Written Succesfully");
//     }
// }



import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // File f = new File("FileIO/sid.txt");
        // f.getParentFile().mkdirs();
        // f.createNewFile();

        // FileOutputStream fos = new FileOutputStream(f);
        // fos.write("Hello, how are you?".getBytes());
        // fos.close();

        // System.out.println("");


        File f2 = new File("FileIO/voters.txt");
        f2.getParentFile().mkdirs();
        f2.createNewFile();

        FileWriter fw = new FileWriter(f2);
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        sc.nextLine();
        if(age>18){
            String name = sc.nextLine();
            fw.append(name+" "+age+"\n");
            fw.close();
        }
        sc.close();
    }
}
