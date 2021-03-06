package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Another way is manochar algorithm with O(n). Difficult for interview settings.
public class LongestPalindrone {

    // O(n^2)
    String getLongestPalindrone(String input){
        int maxStart = 1;
        int maxEnd = 1;
        for(int k=0;k<input.length();k++){
            int left = k, right = k;
            boolean found = true;
            while(left>=0 && right<input.length()){
                if(input.charAt(left)!=input.charAt(right)) {
                    found = false;
                    break;
                }
                if(left!=0 && right!=input.length()-1) {
                    left--;
                    right++;
                }
            }
            if(found && right-left>maxEnd-maxStart){
                maxStart = left;
                maxEnd = right;
            }

            left = k; right = k+1;
            while(left>=0 && right<input.length()){
                if(input.charAt(left)!=input.charAt(right)) {
                    found = false;
                    break;
                }
                left--;
                right++;
            }
            if(found && right-left>maxEnd-maxStart){
                maxStart = left;
                maxEnd = right;
            }

        }

        return input.substring(maxStart, maxEnd+1);
    }


    boolean findPalindroneCentered(String input){
        return findPalindroneCentered(input, input.length()/2);
    }

    int findPalindroneCenteredMax(String input){
        return findPalindroneCenteredMax(input, input.length()/2);
    }

    // Learnings: Center based palindrone. for odd, right=center+1 and left = center-1 in all cases
    boolean findPalindroneCentered(String input, int center){
        int left=center, right = center;
        if(input.length()%2==0) {
            left -= 1;
        }

        while(left>=0 && right<input.length()){
            if(input.charAt(left)!=input.charAt(right))
                return false;

            left--; right++;
        }

        return true;
    }

    int findPalindroneCenteredMax(String input, int center){
        int left=center, right = center;
        if(input.length()%2==0) {
            left -= 1;
        }

        while(left>=0 && right<input.length()){
            if(input.charAt(left)!=input.charAt(right))
                return right-left-1;

            left--; right++;
        }

        return right-left-1;
    }

    @Test
    public void testPalindrone(){
        assertTrue(findPalindroneCentered("n"));
        assertTrue(findPalindroneCentered("nn"));
        assertTrue(findPalindroneCentered("nitin"));
        assertTrue(findPalindroneCentered("maam"));
        assertTrue(findPalindroneCentered("madamimadam"));
        assertTrue(findPalindroneCentered("aaaaa"));
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    public void testMax(String input, int expected){
        assertEquals(expected, findPalindroneCenteredMax(input));
    }

    public static Stream<Arguments> getArgs(){
        return Stream.of(
            Arguments.of("nitin",5),
            Arguments.of("abcnitinabc",5),
            Arguments.of("defeabcddcbaxy",8)
        );
    }

    @Test
    public void testLongestPalindrone() {
        System.out.println(getLongestPalindrone("abcbaccaaaaaa"));
    }
}
