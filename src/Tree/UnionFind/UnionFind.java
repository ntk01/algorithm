package Tree.UnionFind;

class UnionFind {

    int[] parent, rank, size;

    void init(int n) {
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

//    結合して木のサイズを更新
    public void unite1(int x, int y) {
        x = find(x);
        y = find(y);
        if (x==y) return;
        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
        size[x] += size[y];
    }

//    結合して木の深さを更新
    public void unite2(int x, int y) {
        x = find(x);
        y = find(y);
        if (x==y) return;
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x]==rank[y]) rank[x]++;
        }
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public int size(int x) {
        return size[find(x)];
    }


}