package DFS;

import java.util.Scanner;

public class DFS {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] edge = new int[n][n];
    static boolean[] visited = new boolean[n];
    static int[] first_v = new int[n];  // 最初に訪れる時刻
    static int[] end_v = new int[n];    // 最後に訪れる時刻
    static int s = 0;

    public static void main(String[] args){

        for (int i=0; i<n; i++){
            int v = sc.nextInt()-1;
            int k = sc.nextInt();
            for (int j=0; j<k; j++){
                int u = sc.nextInt()-1;
                edge[v][u] = 1;
            }
        }
        dfs(0);
        for (int i=0; i<n; i++){
            System.out.println(first_v[i]);
        }
        System.out.println();
        for (int i=0; i<n; i++){
            System.out.println(end_v[i]);
        }
    }

    public static void dfs(int v){   // 再帰によるDFS

        first_v[v] = ++s;
        for (int u=0; u<n; u++){
            if (edge[v][u]==0) continue;
            if (!visited[u]){
                dfs(u);
            }
        }
        visited[v] = true;
        end_v[v] = ++s;
    }
}

