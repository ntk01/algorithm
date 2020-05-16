//https://atcoder.jp/contests/arc103/tasks/arc103_a

package AssociativeArray;

import java.io.PrintWriter;
import java.util.*;

public class Alternate {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] even = new int[n/2];
    int[] odd = new int[n/2];

    HashMap<Integer, Integer> mapEven = new HashMap<>();
    HashMap<Integer, Integer> mapOdd = new HashMap<>();

    PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args) {
        new Alternate().run();
    }

    void run() {
        for (int i=0; i<n; i++) {
            if (i%2==0) even[i/2] = sc.nextInt();
            if (i%2!=0) odd[i/2] = sc.nextInt();
        }

        int cnt = 0;
        for (int i=0; i<n/2; i++) {
            if (even[0]==odd[0] && even[0]==even[i] && even[i]==odd[i]) cnt++;
        }

        if (cnt==n/2) {
            out.print(n/2);
            out.flush();
            return;
        }

        for (int i=0; i<n/2; i++) {
            if (!mapEven.containsKey(even[i])) {
                mapEven.put(even[i], 1);
            } else {
                int tmp = mapEven.get(even[i]);
                mapEven.put(even[i], tmp+1);
            }

            if (!mapOdd.containsKey(odd[i])) {
                mapOdd.put(odd[i], 1);
            } else {
                int tmp = mapOdd.get(odd[i]);
                mapOdd.put(odd[i], tmp+1);
            }
        }


        TreeMap<Integer, Integer> newmapEven = sortMapByValue(mapEven);
        TreeMap<Integer, Integer> newmapOdd = sortMapByValue(mapOdd);
        

        Map.Entry<Integer, Integer> entryEven = newmapEven.entrySet().iterator().next();
        Map.Entry<Integer, Integer> entryOdd = newmapOdd.entrySet().iterator().next();

        if (!entryEven.getKey().equals(entryOdd.getKey())) {
            out.print(n-entryEven.getValue()-entryOdd.getValue());
        } else {
            if (n/2-entryEven.getValue() < n/2-entryOdd.getValue()) {
                List<Integer> values = new ArrayList<>(newmapOdd.values());
                int value = values.get(1);
                out.print(n-entryEven.getValue()-value);
            } else if (n/2-entryOdd.getValue() < n/2-entryEven.getValue()){
                List<Integer> values = new ArrayList<>(newmapEven.values());
                int value = values.get(1);
                out.print(n-entryOdd.getValue()-value);
            } else {
                List<Integer> valuesEven = new ArrayList<>(newmapEven.values());
                List<Integer> valuesOdd = new ArrayList<>(newmapOdd.values());
                int value = Math.max(valuesEven.get(1), valuesOdd.get(1));
                out.print(n-entryOdd.getValue()-value);
            }
        }

        out.flush();

    }

    public TreeMap<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> map){
        Comparator<Integer> comparator = new ValueComparator(map);

        TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    class ValueComparator implements Comparator<Integer>{

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        public ValueComparator(HashMap<Integer, Integer> map){
            this.map.putAll(map);
        }

        @Override
        public int compare(Integer s1, Integer s2) {
            if(map.get(s1) >= map.get(s2)){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
