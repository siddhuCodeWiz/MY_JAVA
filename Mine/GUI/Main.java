package Mine.GUI;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        String name =  JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello"+name);

        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age: "));
        JOptionPane.showMessageDialog(null, "You are "+age+" years old");

        int a = Integer.parseInt("123456");
        System.out.println(a);
        String ans = Integer.toString(a);
        System.out.println(ans);

        Integer wrapper = Integer.valueOf(a);

        if(wrapper instanceof Integer){
            System.out.println("It is a string");
        }
        else {
            System.out.println("It is an integer");
        }
    }
}
