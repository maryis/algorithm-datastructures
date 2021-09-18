package datastructure.math;
/*
least common multiple
=     a x b = LCM(a, b) * GCD (a, b)
==>    LCM(a, b) = (a x b) / GCD(a, b)
 */
public class LCM {

    public static int lcm(int a,int b){
        int gcd=GCD.gcd(a, b);
        return (a*b)/gcd;
    }

    public static void main(String[] args) {
        System.out.println(lcm(12,8));
    }
}
