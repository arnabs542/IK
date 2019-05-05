package google;

/**
 *
 * https://leetcode.com/explore/featured/card/google/63/sorting-and-searching-4/345/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 *
 * I will first give the solution then show you the magic template.
 *
 * The code of solving this problem is below. It might be the shortest among all solutions provided in Discuss.
 *
 * string minWindow(string s, string t) {
 *         vector<int> map(128,0);
 *         for(auto c: t) map[c]++;
 *         int counter=t.size(), begin=0, end=0, d=INT_MAX, head=0;
 *         while(end<s.size()){
 *             if(map[s[end++]]-->0) counter--; //in t
 *             while(counter==0){ //valid
 *                 if(end-begin<d)  d=end-(head=begin);
 *                 if(map[s[begin++]]++==0) counter++;  //make it invalid
 *             }
 *         }
 *         return d==INT_MAX? "":s.substr(head, d);
 *     }
 * Here comes the template.
 *
 * For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.
 *
 * int findSubstring(string s){
 *         vector<int> map(128,0);
 *         int counter; // check whether the substring is valid
 *         int begin=0, end=0; //two pointers, one point to tail and one  head
 *         int d; //the length of substring
 *
 *         for() { /* initialize the hash map here  }
    *
    *while(end<s.size()){
    *
    *if(map[s[end++]]--?){  /* modify counter here * }
    *
    *while(/* counter condition *){
    *
    *                  /* update d here if finding minimum*
    *
    *                 //increase begin to make it invalid/valid again
    *
    *if(map[s[begin++]]++?){ /*modify counter here* }
    *}
    *
    *             /* update d here if finding maximum*
    *}
    *return d;
    *}
    *One thing needs to be mentioned is that when asked to find maximum substring,we should update maximum after the inner while loop to guarantee that the substring is valid.
    * On the other hand,when asked to find minimum substring,we should update minimum inside the inner while loop.
    *
    *The code of solving Longest Substring with At Most Two Distinct Characters is below:
    *
    *int lengthOfLongestSubstringTwoDistinct(string s){
    *vector<int>map(128,0);
    *int counter=0,begin=0,end=0,d=0;
    *while(end<s.size()){
    *if(map[s[end++]]++==0)counter++;
    *while(counter>2)if(map[s[begin++]]--==1)counter--;
    *d=max(d,end-begin);
    *}
    *return d;
    *}
    *The code of solving Longest Substring Without Repeating Characters is below:
    *
    *Update01.04.2016,thanks@weiyi3 for advise.
    *
    *int lengthOfLongestSubstring(string s){
    *vector<int>map(128,0);
    *int counter=0,begin=0,end=0,d=0;
    *while(end<s.size()){
    *if(map[s[end++]]++>0)counter++;
    *while(counter>0)if(map[s[begin++]]-->1)counter--;
    *d=max(d,end-begin); //while valid, update d
    *}
    *return d;
    *}
 */
public class SubstringProblems {

}
