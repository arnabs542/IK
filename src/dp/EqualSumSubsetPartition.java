package dp;

import java.util.ArrayList;
import java.util.List;

/*
Equal Sum Subset Partition



Problem Statement:



Given an array S of N integers. Your task is to partition the given set S into two subsets, say S1 and S2 such that sum of all elements in S1 is equal to sum of all elements in set S2. If it is not possible to partition the array S then return a blank array else return an Boolean array of size N where ith (0<=i<N) element is true if it is part of S1 and false if it is part of S2.



Input/Output Format For The Function:



Input Format:



First and only parameter of the function that is to be implemented is the vector(array) of integers S, that is to be partitioned.



Output Format:



If it is possible to partition the given array S in the above said manner then return a boolean array of size N, where its ith (0<=i<N) element is true if it is the part of S1 else false if it is the part of S2. In case it is not possible to partition the array S, then return an empty array.



Input/Output Format For The Custom Input:



Input Format:



First line of the test file contains one single integer n , denoting number of elements in array S.

Next n lines contains one single integer denoting the ith element in the array S.



If n = 3 and S = [ 1 , 0 , -1 ], then custom input format will be:



3

1

0

-1



Output Format:



If a valid partition exists, then the first line contains an integer S1, denoting the size of first subset and next S1 line contains

ith elements in the set S1 in order they appear in the input array S. Next line contains an integer S2, denoting the size of second subset. Next S2 lines will contain integers denoting the ith element in the set S2 in order they appear in the input array S.

In case a valid partition is not possible the output contains only one line having integer -1.



For the above provided custom input, one possible custom output could be:



2

1

-1

1

0



Constraints:



﻿﻿﻿1 <= N <= 100

-100 <= elements in S <= 100



Sample Test Case:



N = 6

S = [ 10 , -3 , 7 , 2 , 1 , 3 ]



Sample Output:



[ 1 , 1 , 0 , 0 , 0 , 1 ]



Explanation:

For the above sample output. The two subsets are as following:

S1 = [ 10 , -3 , 3 ]

S2 = [ 7 , 2 , 1 ]

Sum of both the subsets S1 and S2 is 10.


 */
public class EqualSumSubsetPartition {
  /*
   * Complete the 'equalSubSetSumPartition' function below.
   *
   * Complete the equalSubSetSumPartition function below.
   *
   * @param S : input array as parameter.
   */

  public static List<Boolean> equalSubSetSumPartition(List<Integer> S) {
    // Write your code here
    return new ArrayList<Boolean>();
  }
}
