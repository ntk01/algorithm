package Graph;

import java.util.Scanner;

public class Floyd{
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int[][] edge = new int[n][n];

    public static void main(String[] args){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                edge[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<m; i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            int d = sc.nextInt();
            edge[v][u] = d;
        }
        floyd();

    }

    public static void floyd(){ // 計算量はノード数Vとした時、計算量はO(|V|^3)。
        for (int k=0; k<n; k++){    // ノードiからjへ移動する時の経由地をkとする。
            for (int i=0; i<n; i++){
                if (edge[i][k]==Integer.MAX_VALUE) continue;
                for (int j=0; j<n; j++){
                    if (edge[k][j]==Integer.MAX_VALUE) continue;
                    edge[i][j] = Math.min(edge[i][j], edge[i][k]+edge[k][j]);
                }
            }
        }
        boolean negative = false;
        for (int i=0; i<n; i++) if (edge[i][i]<0) negative = true;  // 負の閉路があれば対自ノードへのコストは負となる。

        if (negative){
            System.out.println("negative cycle");
        }else {
            for (int i=0; i<n; i++){
                for (int j=0; j<n-1; j++){
                    System.out.print(edge[i][j]+" ");
                }
                System.out.println(edge[i][n-1]);
            }
        }
    }
}