public class Node implements Comparable<Node> {  // nodeのコストは昇順
    int node;
    int cost;
    public Node(int n, int c){
        this.node = n;
        this.cost = c;
    }

    public int compareTo(Node nd){
        if (this.cost<nd.cost) return -1;
        if (this.cost>nd.cost) return 1;
        return 0;
    }

}