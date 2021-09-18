package datastructure.math;

//greatest common divider
//== product of common prime factors
public class GCD {

    public static int gcd(int a,int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a==b)
            return a;

        return a>b ? gcd(b,a-b) : gcd(a, b-a);
    }

    static int gcd1(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd1(12,8));
    }
}
