import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Run{
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static PriorityQueue<Node> pq = new PriorityQueue<>(); // ノードのコストを昇順としてキューに追加
    static List<Node>[] adj = new ArrayList[n]; // 隣接リスト
    static boolean[] visited = new boolean[n];
    static int[] d = new int[n];    // 0を始点とした時の各ノードへの最短コスト

    public static void main(String[] args){
        for (int i=0; i<n; i++) d[i] = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for (int i=0; i<n; i++){
            int s = sc.nextInt();
            int k = sc.nextInt();
            for (int j=0; j<k; j++){
                int t = sc.nextInt();
                int c = sc.nextInt();
                adj[s].add(new Node(t, c)); // tはノード。cはコスト。
            }
        }
        Dijkstra.dijkstra(d, pq, adj, visited);

        for (int i=0; i<n; i++){
            System.out.println(d[i]);
        }
    }
}