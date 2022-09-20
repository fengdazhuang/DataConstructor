package com.fzz.basicalgorithm.greedy;

import java.util.*;

//贪心算法之广播覆盖问题
public class Greedy {
    public static void main(String[] args) {
        Map<String, HashSet<String>> broadcasts=new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        HashSet<String> cities=new HashSet<>();
        for(Map.Entry<String,HashSet<String>> entry: broadcasts.entrySet()){
            HashSet<String> value = entry.getValue();
            for(String s:value){
                cities.add(s);
            }
        }
//        System.out.println(cities.toString());

        List<String> selects=new ArrayList<>();
        HashSet<String> tempSet=new HashSet<>();
        String maxKey=null;
        while(cities.size()>0){
            maxKey=null;
            for(String key:broadcasts.keySet()){
                tempSet.clear();
                HashSet<String> hashSet = broadcasts.get(key);
                tempSet.addAll(hashSet);
                tempSet.retainAll(cities);
                if(tempSet.size()>0&&(maxKey==null||tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey=key;
                }

            }
            if(maxKey!=null){
                selects.add(maxKey);
                cities.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);

    }
}
