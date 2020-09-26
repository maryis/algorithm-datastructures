package  algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StrPermutation {

    static Set<String> solutions;
    static{
        solutions=new HashSet<>();
    }

    public static void main(String[] args) {
        //get str from in
        Scanner s=new Scanner(System.in);
        String input=s.next();
        char[] charArray=input.toCharArray();
        //call fun
//        calPermute(input,"");
//        //print result
//        solutions.stream().forEach(str-> System.out.println(str));

        calPermute1(charArray,0,charArray.length);
        solutions.stream().forEach(str-> System.out.println(str));


    }

    private static void calPermute1(char[] charArray, int start,int end) {
        if(start==end){
            solutions.add(new String(charArray));
            return;
        }

        for(int i=0;i<charArray.length;i++){
            swap(charArray,start,i);
            calPermute1(charArray,start+1,end);
            swap(charArray,start,i);

        }

    }

    private static void swap(char[] arr,int i, int j) {
        char c=arr[i];
        arr[i]=arr[j];
        arr[j]=c;
    }

    private static void calPermute(String input, String ans) {

        //base step
        if(input.length()==0) {
            solutions.add(ans);
            return;
        }

        int len=input.length();
        //recursion
        for(int i=0;i<len;i++){
            char c=input.charAt(i);
            String remain=input.substring(0,i)+input.substring(i+1);
            calPermute(remain,ans+c);
        }

    }

}
