import java.util.Scanner;

public class Prim{

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] edge = new int[n][n];
    static int[] d = new int[n];    // 最小全域木を構成する時の始点からの距離
    static int[] p = new int[n];    // 最小全域木を構成する時の親ノード
    static boolean[] visited = new boolean[n];

    public static void main(String[] args){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int t = sc.nextInt();
                edge[i][j] = t==-1 ? Integer.MAX_VALUE : t;
            }
        }
        prim();
    }

    public static void prim(){
        for (int i=0; i<n; i++){
            d[i] = Integer.MAX_VALUE;
            p[i] = -1;
        }
        d[0] = 0;
        while (true){
            int minV = Integer.MAX_VALUE;
            int u = -1;
            for (int i=0; i<n; i++){
                if (minV>d[i] && !visited[i]){
                    u = i;
                    minV = d[i];
                }
            }
            if (u==-1) break;
            visited[u] = true;
            for (int v=0; v<n; v++){
                if (!visited[v] && edge[u][v]!=Integer.MAX_VALUE){
                    if (d[v]>edge[u][v]){
                        d[v] = edge[u][v];
                        p[v] = u;
                    }
                }
            }
        }
        int sum = 0;
        for (int i=0; i<n; i++){
            if (p[i]!=-1){
                sum += edge[i][p[i]];
            }
        }
        System.out.println(sum);
    }
}