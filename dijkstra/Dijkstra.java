import java.util.PriorityQueue;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Scanner;


public class Dijkstra {
//    static Scanner sc = new Scanner(System.in);
//    static int n = sc.nextInt();
//    static PriorityQueue<Node> pq = new PriorityQueue<>(); // ノードのコストを昇順としてキューに追加
//    static List<Node>[] adj = new ArrayList[n]; // 隣接リスト
//    static boolean[] visited = new boolean[n];
//    static int[] d = new int[n];    // 0を始点とした時の各ノードへの最短コスト

    public static void dijkstra(int[] d, PriorityQueue<Node> pq, List<Node>[] adj, boolean[] visited){ // ノード数|V|、エッジ数|E|とした時の計算量はO((|V|+|E|)*log|V|)。
        d[0] = 0;
        pq.add(new Node(0, 0)); // ノード0を始点とし、0->0はコスト0で初期化。

        while (!pq.isEmpty()){
            Node nd = pq.poll();    // ノードのコストが小さいものから確定させていく。
            int v = nd.node;

            visited[v] = true;

            if (d[v] < nd.cost){    // ノードのコスト更新の可能性ないものについては処理を飛ばす。
                continue;
            }

            for (int i=0; i<adj[v].size(); i++){
                Node node = adj[v].get(i);
                int t = node.node;
                if (visited[t]) continue;
                if (d[t] > d[v]+node.cost){
                    d[t] = d[v]+node.cost;
                    pq.add(new Node(t, d[t]));
                }
            }
        }
    }
//    public static class Node implements Comparable<Node> {  // nodeのコストは昇順
//        int node;
//        int cost;
//        public Node(int n, int c){
//            this.node = n;
//            this.cost = c;
//        }
//
//        public int compareTo(Node nd){
//            if (this.cost<nd.cost) return -1;
//            if (this.cost>nd.cost) return 1;
//            return 0;
//        }
//    }
}