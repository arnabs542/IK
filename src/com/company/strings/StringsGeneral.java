package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsGeneral {
    static String reverse(String str){
        return str;
    }

    static boolean isPalindrone(String str){
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = charArr.length-1;
        while(start<end){
            if(charArr[start]!=charArr[end])
                return false;
            start++; end--;
        }

        return true;
    }
    static boolean isMatch(String strText, String strPattern) {
        for(int i=0;i<strText.length(); i++){
            boolean found = true;
            boolean matchStar = false;
            for(int j=i; j<strText.length();j++){
                char c = strPattern.charAt(j);
                if(c =='.') continue;
                if(c=='*'){
                    matchStar = true; continue;
                }
                int count = i+j;
                if(matchStar){
                    while(count<strText.length() && c!=strText.charAt(count)){
                        count++;
                    }
                }
                else{
                    found = false;
                    break;
                }
            }
            if(found)
                return found;
        }
        return false;
    }

    static boolean substr2(String word, String prefix){
        for(int i=0;i<word.length()-prefix.length()+1;i++){
            boolean found = true;
            for(int j=0;j<prefix.length();j++){
                if(word.charAt(i+j)!=prefix.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if(found)
                return found;
        }

        return false;
    }

    static boolean isSubstring(String word, String prefix){
        int i=0, j=0;
        int m = word.length();
        int n = prefix.length();
        while(i < m-n+1) {
            boolean found = true;
            j=0;
            while (j < n) {
                if (word.charAt(i) != prefix.charAt(j)) {
                    found = false;
                    break;
                }
                i++;j++;
            }
            if(found)
                return found;

            i++;
        }
        return false;
    }

    @Test
    public void testSubstr2(){
        assertTrue(substr2("Atul", "tu"));
        assertTrue(substr2("Atul", "Atu"));
        assertTrue(substr2("Atul", "tul"));
        assertTrue(substr2("Atul", "Atul"));
        assertFalse(substr2("Atul", "Aul"));
    }

    @Test
    public void testSubstring(){
        assertTrue(isSubstring("Atul", "tu"));
        assertTrue(isSubstring("Atul", "Atu"));
        assertTrue(isSubstring("Atul", "tul"));
        assertTrue(isSubstring("Atul", "Atul"));
        assertFalse(isSubstring("Atul", "Aul"));
    }


}
