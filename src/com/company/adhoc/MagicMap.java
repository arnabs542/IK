package com.company.adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicMap {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    void add(int x){
        if(map.containsKey(x))
            return;
        list.add(x);
        int position = list.size()-1;
        map.put(x, position);
    }

    void remove(int x){
        if(!map.containsKey(x))
            return;
        int pos = map.get(x);

        //swap()
        list.remove(map.get(x));
        map.remove(x);
    }

    int search(int x){
        return map.get(x);
    }

    int getRandom(){
        int size = list.size();
        return 0;
    }

}
