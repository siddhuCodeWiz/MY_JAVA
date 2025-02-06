package PreFS;

import java.util.Stack;

import DAA.Second;

// 1Q)Check_for_Valid_Comments

// Problem statement

// Imagine you're a lead developer working on a highly sensitive code analysis
// tool
// for a large software development company. One of the core responsibilities of
// this tool is to ensure that code written by the developers is syntactically
// correct before it gets deployed.

// One of the most common errors you need to catch involves mismatched or
// incorrectly nested comments in the code, where developers use /* */, //, or
// block comments using {}. These comments must always be properly closed, and
// block comments cannot overlap in an incorrect order.

// Your task is to write a validation function that checks whether the comments
// in the code are properly opened and closed.

// The rules for valid comments are:

// - A comment started by /* must be closed with */.
// - A block comment opened by { must be closed with }.
// - If a comment or block is opened, it must be properly closed before another
// of the same type is opened (no overlapping).

// Given a string s that represents a piece of code containing only comment
// delimiters /* */, //, and { }, determine if the string has valid comments.
// Print true if all the comments and block statements in the code are valid,
// and false otherwise.

// ## Input Format:

// A string S, containing only the characters representing comments and blocks:
// /*, */, {, }, and any additional surrounding code.

// ## Output Format:

// Boolean value.

// ## Sample Input-1:

// { /* comment */ // Single line comment }

// ## Sample Output-1:

// true

// ## Sample Input-2:

// { /* Start of comment block } */

// ## Sample Output-2:

// false

public class Date_24_09 {
    public static boolean valid(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // Opening of block comment {
            if (s.charAt(i) == '{') {
                st.push("{");
            } 
            // Opening of multi-line comment /*
            else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                st.push("/*");
                i++; // Skip the next character (part of '/*')
            } 
            // Closing of block comment }
            else if (s.charAt(i) == '}') {
                if (st.isEmpty() || !st.peek().equals("{")) {
                    return false; // Mismatched or extra closing brace
                }
                st.pop(); // Closing the block, pop the stack
            } 
            // Closing of multi-line comment */
            else if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                if (st.isEmpty() || !st.peek().equals("/*")) {
                    return false; // Mismatched or extra closing comment
                }
                st.pop(); // Closing the comment, pop the stack
                i++; // Skip the next character (part of '*/')
            }
            // Single-line comment, skip till end of line
            else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                // Skip the rest of the line as it's a single-line comment
                while (i < s.length() && s.charAt(i) != '\n') {
                    i++;
                }
            } 
        }

        // If the stack is empty, all blocks and comments are closed correctly
        return st.isEmpty();
    }



    public static void main(String[] args) {
        System.out.print("2nd Question: ");
        String test1 = "{ /* comment */ // Single line comment }";
        String test2 = "{ /* Start of comment block } */";

        System.out.println(valid(test1)); // Expected output: true
        System.out.println(valid(test2)); // Expected output: false
    }
}
