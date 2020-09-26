package  algorithms;

import java.util.Scanner;

public class fibonacci {

    public static void main(String[] args) {

        System.out.println("Enter n");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] res=new int[n+1];

        System.out.println("recursive result:"+fibo(n));
        System.out.println("DP result:"+fibo(n,res));
    }

    private static int fibo(int n,int[] res) {
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }

    private static int fibo(int n) {

        if (n == 0)
            return 0;


        if (n == 1)
            return 1;

        return fibo(n - 1) + fibo(n - 2);

    }
}
