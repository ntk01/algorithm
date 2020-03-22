import java.io.PrintWriter;
import java.util.*;

public class AGC031A {

    Scanner sc = new Scanner(System.in);

    final long MOD = (long)1e9+7;

    int n = sc.nextInt();
    String s = sc.next();
    char[] arr = new char[s.length()];

    Map<Character, Integer> map = new HashMap<>();

    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new AGC031A().run();
    }

    void run() {
        arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i=0; i<n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int tmp = map.get(arr[i]);
                map.put(arr[i], tmp+1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());

//        out.println(list);

        long ans = 1;

        for (int i=0; i<list.size(); i++) {
            ans *= list.get(i)+1;
            ans %= MOD;
        }

        out.print(ans-1);
        out.flush();
    }
}
