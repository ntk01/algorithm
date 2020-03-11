import java.util.*;

public class Dijkstra {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Node>[] adj = new ArrayList[n];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] visit = new boolean[n];
    int[] d = new int[n];

    public static void main(String[] args){
        new Dijkstra().run();
    }

    void run() {
        for (int i=0; i<n; i++) d[i] = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int v = sc.nextInt();
            int k = sc.nextInt();
            for (int j=0; j<k; j++) {
                int u = sc.nextInt();
                int c = sc.nextInt();
                adj[v].add(new Node(u, c));
            }
        }

        dijkstra(d, pq, adj, visit);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(d[i]+" ");
        }

        System.out.print(sb.toString());

    }

    void dijkstra(int[] d, PriorityQueue<Node> pq, List<Node>[] adj, boolean[] visit) {
        d[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node nd = pq.poll();
            int v= nd.node;

            visit[v] = true;

            if (d[v]<nd.cost) continue;

            for (int i=0; i<adj[v].size(); i++) {
                Node node = adj[v].get(i);
                int t = node.node;
                if (visit[t]) continue;
                if (d[t] > d[v]+node.cost) {
                    d[t] = d[v]+node.cost;
                    pq.add(new Node(t, d[t]));
                }

            }
        }
    }

    class Node implements Comparable<Node> {
        int node;
        int cost;
        public Node(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        public int compareTo(Node nd) {
            if (this.cost<nd.cost) return -1;
            if (this.cost>nd.cost) return 1;
            return 0;
        }
    }
}
