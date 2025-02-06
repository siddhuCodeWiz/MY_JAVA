package Mine.FileOperations;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filewriter {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("Mine/FileOperations/test.txt")){
            writer.write("I am siddharth");
            writer.flush();
        } catch(IOException exception){
            System.out.println(exception.getMessage());
        }


        try(FileReader reader = new FileReader("Mine/FileOperations/test.txt")) {
            int read = 0;
            do {
                read = reader.read();
                System.out.print((char)read);

            } while (read !=-1);
        } catch (IOException e) {
            e.getMessage();
        }

        VarArgs v = new VarArgs();
        System.out.println(v.sumOfnums(1,2,3,4,5));
    }
}


class VarArgs{
    public int sumOfnums(int ...nums){
        int s=0;
        for(int i=0; i<nums.length; i++){
            s+=nums[i];
        }
        return s;
    }
}