public class Pow {
    long MOD;
    public long power(long x, long n){  // faster than Math.pow　O(logN)
        long sum = 1;
        while (n>0){
            if ((n&1)==1){
                sum *= x;
                sum %= MOD;
            }
            x *= x;
            x %= MOD;
            n>>=1;
        }
        return sum%MOD;
    }
}
