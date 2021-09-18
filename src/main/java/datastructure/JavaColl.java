package datastructure;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaColl {
    public static void main(String[] args) {
// good words, w1,w2,3

List<Integer> l=new ArrayList<>(10);
        Map<Integer,Integer> map=new HashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .forEach(e -> l.add(e.getValue()));


    }
}
