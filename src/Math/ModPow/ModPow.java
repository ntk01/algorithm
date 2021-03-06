package Math.ModPow;

public class ModPow {
    long MOD;
    public long power(long x, long n){  // 繰り返し二乗法によるべき乗計算。O(logN)。
        long sum = 1;
        while (n > 0){
            if ((n & 1) == 1){
                sum *= x;
                sum %= MOD;
            }
            x *= x;
            x %= MOD;
            n >>= 1;
        }
        return sum % MOD;
    }
}
