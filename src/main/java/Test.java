import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        System.out.println(myPow(2, -2147483648));
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        res.add(Collections.emptyList());

        dfs(nums, 0, 0, new ArrayList<Integer>(), res);
        System.out.println(res.size());
        return res;
    }

    private static void dfs(int[] nums, int i,int s, List<Integer> cur, List<List<Integer>>  res){

        int n = nums.length;
        if(s==n|| i==n){
            return;
        }

        for(int k = s; k<n; k++) {
            cur.add(nums[k]);
            res.add(cur);
            System.out.println(cur);
            dfs(nums, i+1, k+1, cur, res);
            cur.remove(Integer.valueOf(nums[k]));
        }
    }

    public static double myPow(double x, int n) {

        if(n<1)
            return pow(1/x, -1*n);
        return pow(x,n);

    }

    private static double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        double hp = pow(x, n / 2);
        hp *= hp;
        if (n % 2 == 1)
            hp *= x;

        return hp;
    }

//    public static double myPow(double x, int y) {
//        double temp;
//        if( y == 0)
//            return 1;
//        temp = myPow(x, y/2);
//
//        if (y%2 == 0)
//            return temp*temp;
//        else
//        {
//            if(y > 0)
//                return x * temp * temp;
//            else
//                return (temp * temp) / x;
//        }
//    }

    public static String countAndSay(String res, int n) {
        if(n==1)
            return "1";

        return res + say( countAndSay(res, n-1));
    }
    public static String say(String str){
        char cur = str.charAt(0);
        int n = str.length();
        String res = "";

        int i = 0;
        while(i<n) {
            int s = i;
            while(i<n && str.charAt(i)==cur){
                i++;
            }
            res+=(i-s);
            res+=cur;
            if(i<n && str.charAt(i)==cur) i++;
            if(i>n-1)
                break;
            cur = str.charAt(i);
        }
        return res;

    }
}
