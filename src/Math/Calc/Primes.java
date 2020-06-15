package Math.Calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Primes {

    /**
     * 素因数分解
     * @param n
     * @return map key: prime, value: count
     */
    Map<Integer, Integer> primes(int n) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        while (n >= 4 && n % 2 == 0) {
            list.add(2);
            n /= 2;
        }
        int d = 3;
        int q = n / d;
        while (q >= d) {
            if (n % d == 0) {
                list.add(d);
                n = q;
            } else {
                d += 2;
            }
            q = n / d;
        }
        list.add(n);

        for (int t: list) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        return map;
    }

    /**
     * n以下の素因数列挙
     * @param n
     * @return
     */
    List<Integer> eratosthenes(int n) {
        boolean[] flag = new boolean[n+1];
        int sqrt = (int)Math.sqrt(n);

        for (int i=2; i<=sqrt; i++) {
            if (!flag[i]) {
                for (int j=i*2; j<=n; j+=i) {
                    flag[j] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=2; i<=n; i++) {
            if (!flag[i]) list.add(i);
        }
        return list;

    }

    /**
     * n以下の素因数列挙
     * @param n
     * @return
     */
    List<Integer> atkin(int n) {
        boolean[] flag = new boolean[n+1];
        int sqrt = (int)Math.sqrt(n);

        flag[0] = flag[1] = false;
        flag[2] = flag[3] = true;

        for (int i=1; i<=sqrt; i++) {
            for (int j=1; j<=sqrt; j++) {
                int num = (4 * i * i) + (j * j);
                if (num <= n && (num % 12 == 1 || num % 12 == 5)) {
                    flag[num] = !flag[num];
                }
                num = (3 * i * i) + (j * j);
                if (num <= n && (num % 12 == 7)) {
                    flag[num] = !flag[num];
                }
                num = (3 * i * i) - (j * j);
                if (i > j && num <= n && (num % 12 == 11)) {
                    flag[num] = !flag[num];
                }
            }
        }

        for (int i=5; i<=sqrt; i++) {
            if (flag[i]) {
                int x = i * i;
                for (int j=x; j<=n; j+=x) {
                    flag[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            if (flag[i]) list.add(i);
        }
        return list;

    }

}
