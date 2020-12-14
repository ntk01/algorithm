//RMQ (Range Minimum Query)
package Tree.SegmentTree;

public class SegTree {

    int n = 1;
    int[] val;

    public SegTree(int n) {
        while (this.n < n) this.n *= 2;
        val = new int[2*this.n-1];
    }

    void init(int n) {
        while (this.n < n) this.n *= 2;
        val = new int[2*this.n-1];
        for (int i=0; i<2*this.n-1; i++) {
            val[i] = Integer.MAX_VALUE;
        }
    }


    void update(int k, int a) {
        k += n - 1;
        val[k] = a;
        while (k > 0) {
            k = (k - 1) / 2;
            val[k] = Math.min(val[2*k+1], val[2*k+2]);
        }
    }

    // [a, b)
    int query(int a, int b) {
        return query(0, n, a, b, 0);
    }

    int query(int l, int r, int a, int b, int k) {
        if (r<=a || b<=l) return Integer.MAX_VALUE;
        if (a<=l && r<=b) return val[k];
        else {
            int vl = query(l, (l+r)/2, a, b, 2*k+1);
            int vr = query((l+r)/2, r, a, b, 2*k+2);
            return Math.min(vl, vr);
        }
    }
}
