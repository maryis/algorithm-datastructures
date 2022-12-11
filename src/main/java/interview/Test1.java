package interview;

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.numDecodings("12"));
    }
    int cnt = 0;
    public int numDecodings(String s) {

        bt(s, 0);
        return cnt;
    }

    private void bt (String s, int i){

        if(i == s.length()){
            cnt++;
            return;
        }

        if (s.charAt(i)=='0')
            return;

        bt(s, i+1);
        if(i+2<s.length() && s.charAt(i+2)-'0'<7) bt(s, i+2);
    }
}
