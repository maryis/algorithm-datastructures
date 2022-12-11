package datastructure.entity.trie2;

import datastructure.entity.trie2.Trie;

import java.util.*;

/*
Problem Description

Given a set of reviews provided by the customers for different hotels and a string containing Good Words, you need to sort the reviews

 in descending order according to their Goodness Value (Higher goodness value first). We define the Goodness Value of a string as the number of Good Words in that string.

NOTE: Sorting should be stable. If review i and review j have the same Goodness Value then their original order would be preserved.

You are expected to use Trie in an Interview for such problems
 */
public class Solution2Trie {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        Trie goodWords=new Trie();
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