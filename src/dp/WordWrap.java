package dp;
/*

Word Wrap



Problem Statement:



Given a sequence of words (strings), and a limit on the number of characters that can be put in one line (line width), put line breaks in the given sequence such that the lines are printed neatly.



The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces.

The extra spaces means spaces put at the end of every line.

Put line breaks such that the following total cost is minimized:



Cost of a line = (Number of extra spaces in the line)^3

Total Cost = Sum of costs for all lines



Each word belong to a single line and no word can be partially in one line and other part in a different line.
Assume that the length of each word is smaller than or equal to the line width.
Extra spaces means spaces put at the end of every line means white spaces between two words need to be ignored.
Two words in a line will have exactly one space in between.
Ignore extra white spaces at the end of last line.
Note that the total cost function is not sum of extra spaces, but sum of cubes of extra spaces.


Input Format



There are two arguments: words and limit, denoting list of words (strings) as mentioned in problem statement and limit on number of characters in a single line.



Output Format



Return the minimum total cost min_cost.



Constraints



1 <= n <= 1000
1 <= limit <= 15000
1 <= length(words[i]) <= limit, for 0 <= i <= (n-1).
words[i] can be composed of [a-z, A-Z], for 0 <= i <= (n-1).


Sample Test Cases



Sample Test Case 1



Sample Input 1



words = [abcdefghijkl, abcdefg, abcdefgh, abcdefghijklmnopqrstuv]

limit = 23



Sample Output 1



result = 1674



Explanation 1



Following arrangement of words in lines will have least cost:

Line1: “abcdefghijkl           ”

Line2: “abcdefg abcdefgh       ”

Line3: “abcdefghijklmnopqrstuv”

Note that we need to ignore the extra white spaces at the end of last line. So, in the last line there will be 0 extra white spaces.

Cost for this configuration:

(23 - 12)^3 + (23 - (7+1+8))^3 + (0)^3 = 1674



Sample Test Case 2



Sample Input 2



words = [omg, very, are, extreme]

limit = 10



Sample Output 2



result = 351



Explanation 2



Following arrangement of words in lines will have least cost:

Line1: “omg very  ”

Line2: “are       ”

Line3: “extreme”

Note that we need to ignore the extra white spaces at the end of last line. So, in the last line there will be 0 extra white spaces.

Cost for this configuration:

(10 - (3+1+4))^3 + (10 - 3)^3 + (0)^3 = 351
 */
public class WordWrap {

  static int minSpaceCost(String[] strArr, int lineWidth) {
    return -1;

  }
}
