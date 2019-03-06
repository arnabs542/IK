package graphs;

/*
String Transformation Using Given Dictionary Of Words

Problem Statement:

You are given a dictionary of words named words, and two strings named start and stop.
How can you convert string start to string stop, by changing only one character at a time and making sure that 1) all the intermediate words are in the given dictionary of words and 2) minimum number of intermediate words are used?
Generally, dictionary does not contain duplicate values, but for the sake of this problem, assume that dictionary might have duplicate values. (Sometimes interviewer tricks the question, to see, how you will handle it.)
Input/Output Format For The Function:
Input Format:
There are three arguments. First is an array of strings words, denoting the dictionary of words, second is a string start and third is a string stop.
Output Format:
Return an array of strings.
If transformation is possible then, in returned array, first string should be start, last string should be stop and in between strings of given dictionary that you used for transformation, in the same order as they are used in your transformation.
Let’s denote the returned string array as ans and its size as m. Then, for all 1 <= i < m, ans[i - 1] and ans[i] should differ at exactly one position.
If transformation is not possible then returned array ans should contain only one string "-1".
If there are multiple valid transformations, you are free to return any one of them.
Input/Output Format For The Custom Input:
Input Format:
The first line of input should contain an integer n, denoting size of input array words. In next n lines, ith line should contain a string words[i], denoting a value at index i of words.
In next line, there should be a string start, denoting the start string. In next line, there should be a string stop, denoting the stop string.
If n = 4, words = ["cat", "hat", "bad", "had"], start = “bat” and stop = “had”, then input should be:
4
cat
hat
bad
had
bat
had
Output Format:
Let’s denote the size of ans array as m, where ans is the output string array returned by solution function.
There will be m lines of output, where ith line contains a string ans[i], denoting a value at index i of ans.
For input n = 4, words = ["cat", "hat", "bad", "had"], start = “bat” and stop = “had”, output will be:
bat
hat
had

Constraints:

All strings in input contains only lower case alphabetical letters.
Length of all strings in input are same.
Strings in words may repeat.
2 <=  total number of characters combined in words array <= 10^5
start and stop strings need not to be present in given dictionary.

Sample Test Case:
Sample Input:
words = ["cat", "hat", "bad", "had"]
start = "bat"
stop = "had"
Sample Output:
["bat", "bad", "had"]
or
["bat", "hat", "had"]
Explanation:
From "bat" change character 't' to 'd', so new string will be "bad".
From "bad" change character 'b' to 'h', so new string will be "had".
or
From "bat" change character 'b' to 'h', so new string will be "hat".
From "hat" change character 't' to 'd', so new string will be "had".
Notes:
Suggested time in interview: 30 minutes.
The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */
public class StringTransformation {

}
