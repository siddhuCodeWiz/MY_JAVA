package DAA.Backtracking;

/*
 * Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
Line-1: A string EXP, expression.

Output Format:
--------------
Line-1: Print list of words, formed from the expression.

Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
 */

import java.util.*;

public class BraceExpressions {
    HashSet<String> hs = new HashSet<>();

    public static ArrayList<String> helper(String sb){
        if(sb.equals("")){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        String ns = new String();
        int i=0;
        if(sb.charAt(i) =='['){
            while(i<sb.length() && sb.charAt(i)!=']'){
                i++;
            }
            i++;
        } else{
            while(i<sb.length() && sb.charAt(i)!='['){
                i++;
            }
        }
        ns = sb.substring(0, i);
        // System.out.println(ns);

        ArrayList<String> ret = helper(sb.substring(i, sb.length()));
        ArrayList<String> ans = new ArrayList<>();
        for(int j=0; j<ret.size(); j++){
            if(ns.charAt(0)=='['){
                String[] a = ns.substring(1, ns.length()-1).split(",");
                for(int k=0; k<a.length; k++){
                    ans.add(a[k]+""+ret.get(j));
                    // System.out.println(ans);
                }
            } else{
                ans.add(ns+ret.get(j));
                // System.out.println(ans);
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sb = new String(sc.nextLine());
        ArrayList<String> ans = helper(sb);
        Collections.sort(ans);
        System.out.println(ans);
        sc.close();
    }
}
