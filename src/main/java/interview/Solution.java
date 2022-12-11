package interview;
import org.junit.Assert;
import org.junit.Test;


public class Solution {

    int cnt = 0;
    int n ;

    public static void main(String[] args) {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.numDecodings("12"));
    }

    public int numDecodings(String s) {

        n = s.length();
        bt(s, 0);
        return cnt;
    }

    private void bt (String s, int i) {

        if (i == n) {
            cnt++;
            return;
        }

        if (s.charAt(i) == '0')
            return;

        bt(s, i +1);

        if (i + 1 < n && Integer.parseInt(s.substring(i , i + 2)) < 27)
            bt(s, i + 2);

    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.numDecodings("12"));
    }
}