package com.company.strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string like "Helloworld", find the shortest substring containing all chars in set {w, l, r}
 */
// Important learnings: Set can be used to keep track of elements already encountered by removing from it within sliding window
    // Initialize the set at every increment of startIndex so that they can be checked again.
    // substring is start inclusive and end exclusive, so add +1 to end if it needs to be included.
public class ShortestSubstring {
    static String getShortestSubstr(String input, Set<Character> set){
        int i=0, j=0;
        Set<Character> temp = new HashSet<>();
        int resultStart = 0;
        int resultEnd = input.length();

        for(int left=0;left<input.length();left++){
            temp.addAll(set);
            for(int right = left; right<input.length();right++){
                boolean allCharsFound = false;
                temp.remove(input.charAt(right));
                if(temp.size()==0){
                    allCharsFound = true;
                }
                if(allCharsFound && right-left < resultEnd-resultStart) {
                    resultStart = left;
                    resultEnd = right;
                    break;
                }
            }
        }

        return input.substring(resultStart, resultEnd+1);
    }

    static String getShortestWithMap(String input, Set<Character> set) {
        Map<Character, Integer> charCounts = new HashMap<>();
        int resultStart = 0;
        int resultEnd = input.length();
        // first pass to collect frequency of all chats
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!set.contains(c)) {
                if (charCounts.size() == 0)
                    resultStart++;
                continue;
            }
            int count = charCounts.getOrDefault(c, 0);
            charCounts.put(c, count+1);
        }

        //second pass to find shortest window which has frequency of all 1's
        int left = resultStart;
        int right = resultEnd;
        if (left < right) {
            int leftCharCount = -1;
            while (leftCharCount != 1) {
                char leftChar = input.charAt(left);
                leftCharCount = charCounts.getOrDefault(leftChar, -1);
                if (leftCharCount == -1)
                    left++;
                else {
                    if(leftCharCount>1) {
                        leftCharCount = leftCharCount-1;
                        charCounts.put(leftChar, leftCharCount);
                    }

                    left++;
                }
            }

            int rightCharCount = -1;
            while (rightCharCount != 1) {
                char rightChar = input.charAt(right-1);
                rightCharCount = charCounts.getOrDefault(rightChar, -1);
                if (rightCharCount == -1)
                    right--;
                else {
                    if(rightCharCount>1) {
                        rightCharCount -= 1;
                        charCounts.put(rightChar, rightCharCount);
                    }

                    right--;
                }
            }

        }

        return input.substring(left, right+1);
    }

    @Test
    public void testShortestSubstring(){
        Set<Character> set = new HashSet<>();
        set.add('w');
        set.add('r');
        set.add('l');
        System.out.println(getShortestSubstr("helloworld",set));
    }

    @Test
    public void testShortestSubstringWithMap(){
        Set<Character> set = new HashSet<>();
        set.add('w');
        set.add('r');
        set.add('l');
        System.out.println(getShortestWithMap("helloworld",set));
    }

}
