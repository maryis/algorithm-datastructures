package algorithms;

public class NomOfBST {

    int count = 0;

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numOfTree(1,n));
    }

    private static int numOfTree(int s,int e) {
        if(s>e)
            return 1;
        if (s == e )
            return 1;

        if(s+1==e){
            return 2;
        }

        int cnt=0;
        for (int i = s; i <= e; i++) {

            int lefts = numOfTree(1,i-1);
            int rights = numOfTree(i+1,e);
            cnt+= lefts*rights;
        }
        return cnt;
    }
}
