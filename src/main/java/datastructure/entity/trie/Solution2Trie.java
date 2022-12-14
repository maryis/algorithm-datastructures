package datastructure.entity.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution2Trie {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        Trie2 goodWords=new Trie2();
        for(String str : A.split("_"))
            goodWords.insert(str);

        Map<Integer,Integer> result=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<B.size();i++){
            for(String str: B.get(i).split("_"))
                if(goodWords.contains(str))
                    result.compute(i,(k,v) -> v==null? 1:v+1);
        }

        result.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach( entry -> list.add(entry.getKey())
                );

        return list;
    }




}