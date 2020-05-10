package Math.Combination;

public class Comb {
    int n;   //　要素数
    int MOD = (int)1e9+7;
    long[] facts;

    public Comb(int n, int MOD){
        this.n = n;
        this.MOD = MOD;
        facts = new long[n+1];
        facts[0] = 1;
        for (int i=1; i<n+1; i++){
            facts[i] = facts[i-1] * i % MOD;
        }
    }

    // O(log(MOD))
    public long modpow(long a, long b){
        if (b==0) return 1;
        else if (b==1) return a;
        long x = modpow(a, b/2);
        return b%2 == 0 ? x * x % MOD : x * (x*a%MOD) % MOD;
    }

    public long inv(long n){ // 逆元。x^(-1)≡x^(p-2) (MOD p)
        return modpow(n, MOD-2);
    }

    public long nCk1(int n, int k){
        return n < k ? 0: facts[n] * (inv(facts[n-k]) * inv(facts[k]) % MOD) % MOD;
    }

    // O(k)
    public long nCk2(int n, int k) {
        long ret = 1;
        for (int i=0; i<k; i++) {
            ret = ret * (n - i) % MOD * inv(k - i);
            ret %= MOD;
        }
        return ret % MOD;
    }

}