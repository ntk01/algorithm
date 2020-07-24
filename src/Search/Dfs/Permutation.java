//https://atcoder.jp/contests/abc054/tasks/abc054_c

package Search.Dfs;
import java.util.*;

public class Permutation {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    List<Integer>[] lists = new ArrayList[n];
    int cnt = 0;

    public static void main(String[] args) {
        new Permutation().run();
    }

    void run() {

        for (int i=0; i<n; i++) lists[i] = new ArrayList<>();

        for (int i=0; i<m; i++) {
            int s = sc.nextInt() - 1;
            int t = sc.nextInt() - 1;
            lists[s].add(t);
            lists[t].add(s);
        }

        String str = "0";
        for (int i=1; i<n; i++) str += i;

        permutation(str, "");

        System.out.print(cnt);

    }

    void permutation(String s, String res) {
        if (s.length() <= 1) {
            String tmp = res + s;
            if (tmp.charAt(0) == '0') {
                boolean f = true;
                for (int i=0; i<n-1; i++) {
                    int now = Integer.parseInt(tmp.substring(i, i+1));
                    int next = Integer.parseInt(tmp.substring(i+1, i+2));
                    if (!lists[now].contains(next)) {
                        f = false;
                        break;
                    }
                }
                if (f) cnt++;
            }
        } else {
            for (int i=0; i<s.length(); i++) {
                permutation(s.substring(0, i) + s.substring(i+1), res + s.charAt(i));
            }
        }
    }

}

