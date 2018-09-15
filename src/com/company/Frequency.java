package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Frequency {
    static String[] solve(String[] arr) {
        /*
         * Write your code here.
         */
        Map<String, List<String>> map = new HashMap<>();
        for(String str : arr){
            String[] splits = str.split(" ");
            String key = splits[0];
            String value = splits[1];
            List<String> list = null;
            if(map.keySet().contains(key))
                list = map.get(key);
            else
                list = new ArrayList<String>();

            list.add(value);
            map.put(key, list);
        }

        String[] out = new String[map.size()];
        int i=0;
        for(String key : map.keySet()){
            List<String> values = map.get(key);
            values.sort(Comparator.comparing(String::toString));
            String entry = key + ":" + values.size() + "," + values.get(values.size() - 1);
            out[i++] = entry;
        }

        return out;
    }

    private static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(scan.nextLine().trim());

        String[] arr = new String[arrCount];

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            String arrItem = scan.nextLine();
            arr[arrItr] = arrItem;
        }

        String[] res = solve(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bw.write(res[resItr]);

            if (resItr != res.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

