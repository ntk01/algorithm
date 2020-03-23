package Math.Combination;

public class Combi {
    static int n = 7;   //　要素数
    static long MOD = (long)1e9+7;
    static long[] facts;

    public Combi(int n, long MOD){
        this.n = n;
        this.MOD = MOD;
        facts = new long[n+1];
        facts[0] = 1;
        for (int i=1; i<n+1; i++){
            facts[i] = facts[i-1]*i%MOD;
        }
    }

    public static void main(String[] args){
        facts = new long[n+1];
        facts[0] = 1;
        for (int i=1; i<n+1; i++){
            facts[i] = facts[i-1]*i%MOD;
        }
        System.out.println(nck(7,2));   // output 21
    }

    public static long modpow(long a, long b){  // 計算量はlog(MOD);
        if (b==0) return 1;
        else if (b==1) return a;
        long x = modpow(a, b/2);
        return b%2==0 ? x*x%MOD : x*(x*a%MOD)%MOD;
    }
    public static long inv(long n){ // 逆元。x^(-1)≡x^(p-2) (MOD p)
        return modpow(n, MOD-2);
    }
    public static long nck(int n, int k){
        return n<k ? 0: facts[n]*(inv(facts[n-k])*inv(facts[k])%MOD)%MOD;
    }
}