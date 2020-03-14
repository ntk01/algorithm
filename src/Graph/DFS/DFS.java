package Graph;

import java.util.*;

public class DFS {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static List<Integer>[] edge = new ArrayList[n];
    static boolean[] visit = new boolean[n];
    static int[] firstV = new int[n];
    static int[] endV = new int[n];
    static int sec = 0;

    public static void main(String[] args){
        for (int i=0; i<n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++) {
            int v = sc.nextInt()-1;
            int k = sc.nextInt();
            for (int j=0; j<k; j++) {
                int u = sc.nextInt()-1;
                edge[v].add(u);
            }
        }
        dfs(0);
        for (int i=0; i<n; i++) {
            System.out.print(i+1+" ");
            System.out.print(firstV[i]+"sec ");
            System.out.println(endV[i]+"sec ");
        }
    }

    public static void dfs(int v) {
        firstV[v] = ++sec;
        for (int u: edge[v]) {
            if (!visit[u]) {
                dfs(u);
            }
        }
        visit[v] = true;
        endV[v] = ++sec;
    }
}
