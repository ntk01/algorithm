//https://atcoder.jp/contests/abc156/tasks/abc156_d

import java.util.*;

public class Bouquet {

    Scanner sc = new Scanner(System.in);

    int MOD = (int)1e9+7;
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    public static void main(String[] args) {
        new Bouquet().run();
    }

    void run() {
        long sum = modpow(2, n);

        long comA = nck(n, a);
        long comB = nck(n, b);

        long ans = sum-comA-comB-1+MOD*2;

        System.out.println(ans%MOD);

    }

    public long modpow(long a, long b){  // 計算量はlog(MOD);
        if (b==0) return 1;
        else if (b==1) return a;
        long x = modpow(a, b/2);
        return b%2==0 ? x*x%MOD : x*(x*a%MOD)%MOD;
    }
    public long inv(long n){ // 逆元。x^(-1)≡x^(p-2) (MOD p)
        return modpow(n, MOD-2);
    }
    public long nck(int n, int k){
        long res = 1;
        for (int i=0; i<k; i++){  // facts配列だとout of memory
            res = (res*(n-i))%MOD;
            res = (res*inv(i+1))%MOD;
        }
        return res;
    }
}

