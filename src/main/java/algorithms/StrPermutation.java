package  algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//time complexity:
// T(n) = n + t(n-1) = n*2 n!
public class StrPermutation {

    static Set<String> solutions=new HashSet<>();////SSSSEEETTT

    public static void main(String[] args) {

        System.out.println("Enter a string :");
        Scanner s=new Scanner(System.in);
        String input=s.next();
        char[] charArray=input.toCharArray();
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
}
