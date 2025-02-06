package DAA.Practice;


// Aruna as a type writer, typing a document in her laptop. Suddenly her system got
// hacked and whatever she types as words are displaying in reverse and with simple 
// braces. She types only lowercase letters.

// Inorder to get the actual words, Aruna has to reverse each word starting with the
// word which is in innermost most braces and remove those braces.
// Help Aruna to get actual words.

// Constraints:
// ------------
//   - 0 <= word.length <= 2000
//   - Word only contains lower case English characters and parentheses.
//     It's guaranteed that all braces are balanced.


// Input Format:
// -------------
// Line-1: A string, represents an encoded word.

// Output Format:
// --------------
// Line-1: A string, return the original string.


// Sample Input-1:
// ---------------
// {pqrs}

// Sample Output-1:
// ----------------
// srqp


// Sample Input-2:
// ---------------
// {uoy{are}woh}

// Sample Output-2:
// ----------------
// howareyou

// Explanation
// ------------
// Initially "are" will be revesed as "era".
// Then {uoyerawoh} will be reversed.



import java.util.*;

public class ReverseWord {
    public static String reverse(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder sol = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='{'){
                st.add(s.charAt(i));
            } else if(s.charAt(i)=='}'){
                while (!st.isEmpty() && st.peek()!='{') {
                    sol.append(st.peek());
                    st.pop();
                }
                st.pop();
                if(!st.isEmpty()){
                    for(int k=0; k<sol.length(); k++){
                        st.add(sol.charAt(k));
                    }
                    sol.delete(0, sol.length());
                }
            }else{
                st.add(s.charAt(i));
            }
        }
        return sol.toString();
    }
    public static void main(String[] args) {
        String s = "{hello{are{you}}wee}";
        System.out.println(reverse(s));
    }
}
