package com.company;

public class Main {

    public static String changePi(String str) {
        if(str==null|| str.length()==0)
            return "";
        if(str.length()==1)
            return str;
        String fHalf = str.substring(0, 2);
        String sHalf = str.substring(1, str.length());
        if(fHalf.equals("pi")){
            fHalf = "3.14";
            sHalf = str.substring(2, str.length());
        }

        return fHalf+changePi(sHalf);
    }

    public static void main(String[] args) {
        System.out.println(Main.changePi("xpix"));
    }
}
