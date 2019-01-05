package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaInput {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> inputs = new ArrayList<>();
    while(in.hasNext()){
      inputs.add(in.nextLine());
    }
  }}
