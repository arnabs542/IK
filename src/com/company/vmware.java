package com.company;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vmware {
  public static final String SUCCESS = "SUCCESS => RECEIVED: ";
  public static final String FAILURE = "FAILURE => RECEIVED: ";
  public static final String WRONGINPUT = "FAILURE => WRONG INPUT";

  public static String checkValid(String input){
    String[] numbers = input.split(" ");
    int[] numInts = new int[numbers.length];
    int max = 0;
    int recieved = numInts.length;
    for(int i=0; i<numbers.length; i++){
      try{
        numInts[i] = Integer.parseInt(numbers[i]);

      }catch(NumberFormatException numberFormatException){
        return WRONGINPUT;
      }
      if(numInts[i]>max)
        max = numInts[i];
    }

    if(recieved==max)
      return SUCCESS+recieved;
    else
      return FAILURE+", EXPECTED: "+max;

  }

  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> inputs = new ArrayList<>();
    while(in.hasNext()){
      inputs.add(in.nextLine());
    }
    for(int i=1; i<inputs.size();i++){
      System.out.println(checkValid(inputs.get(i)));
    }
  }
}