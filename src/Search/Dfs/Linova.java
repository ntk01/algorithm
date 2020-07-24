// https://codeforces.com/contest/1337/problem/C
// postorderで部分木の要素数をカウント

package Search.Dfs;

import java.util.*;

public class Linova{

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] depth = new int[n];
    int[] impact = new int[n];

    boolean[] visit = new boolean[n];
    List<Integer>[] lists = new ArrayList[n];


    public static void main(String[] args) {
        new Linova().run();
    }


    void run() {

        visit[0] = true;

        Arrays.fill(impact, 1);

        for (int i=0; i<n; i++) lists[i] = new ArrayList<>();

        for (int i=0; i<n-1; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            lists[a].add(b);
            lists[b].add(a);
        }

        bfs(0);

        dfs(0);

        long ans = 0;


        for (int i=0; i<n; i++) {
            depth[i] -= impact[i]-1;
        }

        Arrays.sort(depth);

        for (int i=n-1; i>=n-k; i--) {
            ans += depth[i];
        }


        System.out.println(ans);
    }

    void bfs(int u) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(u);

        while (!queue.isEmpty()) {
            int t = ((ArrayDeque<Integer>) queue).peekFirst();
            for (int edge: lists[t]) {
                if (edge!=0 && depth[edge]==0) {
                    depth[edge] = depth[t]+1;
                    queue.add(edge);
                }
            }
            queue.poll();
        }
    }

    void dfs(int v) {
        for (int u: lists[v]) {
            if (!visit[u]) {
                visit[v] = true;
                dfs(u);
                impact[v] += impact[u];
            }
        }
    }
}
