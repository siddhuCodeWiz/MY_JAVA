// Create a Java program that reads a text file, processes its content, and writes the output to a new file. The program should perform the following tasks:

// Read the content of an input file line by line.
// For each line:
// Reverse the words in the line.
// Convert all characters to uppercase.
// Replace all vowels (a, e, i, o, u) with the character '*'.
// Write the processed content to a new output file.
// Display the original and processed contents side by side on the console.

package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class HelperVowelReplacement {
    String s;

    HelperVowelReplacement(String s) {
        this.s = s;
    }

    String encryptData() {
        StringBuilder n = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            Character curr = s.charAt(i);
            if (curr.equals('a') || curr.equals('e') || curr.equals('i') || curr.equals('o') || curr.equals('u')) {
                n.append("*");
            } else if (curr.equals(' ')) {
                n.append(" ");
            } else {
                n.append(Character.toUpperCase(curr));
            }
        }
        return n.toString();
    }
}

public class VowelReplacement {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("Practice//vowel.txt"));
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                HelperVowelReplacement h = new HelperVowelReplacement(s);
                String encryptedLine = h.encryptData();
                sb.append(encryptedLine).append(System.lineSeparator());
            }

            bw = new BufferedWriter(new FileWriter("Practice//vowel_output.txt"));
            bw.append(sb.toString());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Exception closing resources: " + e);
            }
        }
    }
}
