package com.company;
import java.io.*;
import java.util.*;
public class Brackets {
    /*
     * Complete the function below.
     */
    static int find_max_length_of_matching_parentheses(String brackets) {
        Stack<Character> stack = new Stack<>();
        int oldLongest = 0;
        int longest = 0;
        int i=0;
        while(i<brackets.length()){
            char fchar = brackets.charAt(i);

            if(fchar=='(')
                stack.push(fchar);
            if(fchar==')'){
                if(!stack.isEmpty()) {
                    if(stack.pop()=='(');
                        longest+=2;
                }
            }
            i++;

            if(stack.isEmpty()) {
                if (oldLongest < longest) {
                    oldLongest = longest;
                    longest = 0;
                }
            }

        }

        return oldLongest;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int res;
        String brackets;
        try {
            brackets = in.nextLine();
        } catch (Exception e) {
            brackets = null;
        }

        res = find_max_length_of_matching_parentheses(brackets);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
