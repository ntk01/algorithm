//https://atcoder.jp/contests/abc079/tasks/abc079_d
package Graph.Floyd;

import java.util.*;

public class Wall {

    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int[][] score = new int[10][10];
    public static void main(String[] args) {
        new Wall().run();
    }

    void run() {

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        floyd();

        Map<Integer, Integer> map = new HashMap<>();

        long ans = 0;

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                int tmp = sc.nextInt();
                if (map.containsKey(tmp)) {
                    int val = map.get(tmp);
                    map.put(tmp, val+1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }

        for (Integer k: map.keySet()) {
            if (k==-1) continue;
            int val = map.get(k);
            ans += score[k][1] * val;
        }

        System.out.println(ans);

    }

    void floyd() {
        for (int k=0; k<10; k++) {
            start:
            for (int i=0; i<10; i++) {
                if (score[i][k]==0) continue start;
                end:
                for (int j=0; j<10; j++) {
                    if (score[k][j]==0) continue end;
                    score[i][j] = Math.min(score[i][j], score[i][k] + score[k][j]);
                }
            }
        }
    }

}
