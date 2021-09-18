package interview;

import java.util.*;

/*
Problem Description

Given a set of reviews provided by the customers for different hotels and a string containing Good Words, you need to sort the reviews in descending order according to their Goodness Value (Higher goodness value first). We define the Goodness Value of a string as the number of Good Words in that string.

NOTE: Sorting should be stable. If review i and review j have the same Goodness Value then their original order would be preserved.

You are expected to use Trie in an Interview for such problems
 */
public class Solution2 {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        Set<String> mapGoods=new HashSet<>();
        Map<Integer,Integer> mapRes=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>(B.size());
        String [] goods=A.split("_");
        for(int i=0;i<goods.length;i++){
            mapGoods.add(goods[i]);
        }
        for(int idx=0;idx<B.size();idx++){
            String comment=B.get(idx);
            mapRes.put(idx,0);
            String []ws=comment.split("_");
            for(int i=0;i<ws.length;i++){
                if(mapGoods.contains(ws[i]))
                    mapRes.computeIfPresent(idx,(k,v) -> v+1);
            }
        }

        mapRes.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach( entry -> res.add(entry.getKey())
                );

        return res;
    }


}