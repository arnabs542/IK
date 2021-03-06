package Strings;
/*
Longest Repeated Substring



Problem Statement:



Given a string inputStr of length n, find the longest repeated substring in it.



- Repeated is occurring more than once. It doesn't matter how many times it occurs as far as it occurs more than once.

- If there are multiple such substrings of the same size, then return any one.

- If there are no repeated substrings, then return an empty string.



Input/Output Format For The Function:



Input Format:



There is only one argument inputStr, denoting input string.



Output Format:



Return a string lrs, denoting longest repeated substring.



Input/Output Format For The Custom Input:



Input Format:



There should be only one line, containing inputStr, denoting input string.



If inputStr = “efabcdhefhabcdiefi”, then input should be:



efabcdhefhabcdiefi



Output Format:



There will be only one line, containing a string lrs, denoting longest repeated substring.



For input inputStr = “efabcdhefhabcdiefi”, output will be:



abcd



Constraints:



2 <= n <= 2*10^5
inputStr may contain only lowercase characters a-z.


Sample Test Cases:



Sample Input 1:



aaaa



Sample Output 1:



aaa



Explanation 1:



aaa is the longest substring which is repeated in aaaa, starting at position 0 and starting at position 1.



Sample Input 2:



efabcdhefhabcdiefi



Sample Output 2:



abcd



Explanation 2:



abcd repeats twice and ef repeats thrice. But as problems asks for longest repeated substring, abcd would be correct result.



Sample Input 3:



abcdefghi



Sample Output 3:



“”

(Empty string in output)



Explanation 3:



As there are no repeated substring in abcdefghi, empty string "" would be returned.



NOTE:

This is purely an exercise in building a Suffix Tree.



Suffix trees are difficult. You'd probably wonder if they really ask those in an interview.



They are in-fact, are rarely asked, which is why we don't cover it in the class. But we've seen them at FB and Uber. In all occasions, it's been asked as a follow up question. Once you code up an N^2 algorithm for the problem on hand, there are a few minutes left, in which time, the interviewer would wonder if you know of Suffix trees. It is NEVER asked to implement one in an interview. That's stupid. If at that time, you do know of suffix trees, then you have a chance to convert that interviewer from a 3 (good) to a 4 (advocate). It suggests you have taken a keen interest in your prep work and by extension, in general CS.



Another reason we include it in the course: It's possibly one of the hardest data structures. Once you have a handle on it, a lot of other things will look easy ;-)

Doing difficult problems like these also has a strong ancillary benefit: it helps you indirectly interview your interviewer/company. You want to work for a team that challenges you; not the team that gives you a free pass.

i.e. Don't skimp on it. Take it head on - there are clear benefits.


 */
public class LongestRepeatedSubstring {

}
