package AdHoc;
/*
Merge Overlapping Intervals





Problem Statement:



Given an array of time intervals(in any order) inputArray, of size n, merge all overlapping intervals into one and return the resulting array outputArray, such that no two intervals in outputArray are overlapping. In other words, result array should contain only mutually exclusive intervals. Hence, in outputArray, no pair of intervals i and j exists, such that

outputArray[i][0] <= outputArray[j][0] <= outputArray[i][1].



(In this problem, you should consider all the intervals as closed intervals. i.e. endpoints of intervals are inclusive.)



Input/Output Format For The Function:



Input Format:



There is only one argument: inputArray, denoting input array of time intervals, where inputArray is 2D array of n*2 size, denoting inputArray[i][0] as start point of ith interval, and inputArray[i][1] as end point of ith interval.



Output Format:



Return an array of time intervals outputArray, denoting the required array of merged time intervals, where outputArray is 2D array of len*2 size, denoting outputArray[i][0] as start point of ith interval, and outputArray[i][1] as end point of ith interval.

(Order of intervals in outputArray doesn't matter.)



Input/Output Format For The Custom Input:



Input Format:



First line should contain a number n, denoting number of intervals in inputArray. Next line should contain 2, unconditionally, as inputArray is 2D array of n*2. In next n lines, ith line should contain two space separated numbers starti and endi, denoting start point and end point of ith interval respectively.



If n = 4, inputArray = [[1, 3], [5, 7], [2, 4], [6, 8]], then input should be:



4

2

1 3

5 7

2 4

6 8



Output Format:



Let say len*2 is the size of resultant 2D array outputArray. Then, there will be len lines, where ith line contains two space separated integers starti and endi, denoting start point and end point of ith interval in outputArray respectively.



For input n = 4, inputArray = [[1, 3], [5, 7], [2, 4], [6, 8]], output will be:



1 4

5 8



Constraints:



1 <= n <= 10^5
-10^9 <= inputArray[i][0] <= inputArray[i][1] <= 10^9,   i=0, 1, ..., (n-1)


Sample Test Cases:



Sample Input 1:



4

2

1 3

5 7

2 4

6 8



Sample Output 1:



1 4

5 8



Explanation 1:



The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1,4}.

Similarly {5,7} and {6,8} should be merged and become {5,8}.



Sample Input 2:



7

2

100 154

13 47

1 5

2 9

7 11

51 51

47 50



Sample Output 2:



1 11

13 50

51 51

100 154



Explanation 2:



The intervals {1,5} and {2,9} overlap with each other, so they should be merged and become {1,9}.

Also, {1,9} and {7,11} overlap with each other, so they should be merged and become {1,11}

Similarly, The intervals {13,47} and {47,50} should be merged and become {13,50}.

Intervals {51,51} and {100,154} are kept as it is as they are not overlapping with any other intervals.



Suggestions:



Suggested time in interview: 20 minutes.

The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TA session. Take your time, but limit yourself to 2 one hour sessions for most problems.


 */
public class MergeOverlappingIntervals {

}
