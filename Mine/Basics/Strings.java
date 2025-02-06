package Mine.Basics;

public class Strings {
    public static void main(String[] args){
        String a = "   Brooo      ";
        // boolean result = a.equals("bro");
        // boolean result = a.equalsIgnoreCase("bro");
        // int result = a.length();
        // char result = a.charAt(0);
        // int result = a.indexOf('o');
        // boolean result = a.isEmpty();
        // String result = a.toLowerCase();
        // String result = a.toUpperCase();
        // String result = a.trim();
        String result = a.replace('o', 'a');

        System.out.println(result);
    }
}
