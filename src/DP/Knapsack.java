import java.util.*;

public class Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[][] dp = new int[n+1][w+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=w; j++) {
                if (arr[i-1][1]<=j) {
                    if (arr[i-1][0]+dp[i-1][j-arr[i-1][1]]>dp[i-1][j]) {
                        dp[i][j] = arr[i-1][0]+dp[i-1][j-arr[i-1][1]];
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<=n; i++) {
            for (int j=0; j<w; j++) {
                sb.append(dp[i][j]+" ");
            }
            sb.append(dp[i][w]+"\n");
        }

        System.out.print("DP table:\n"+sb.toString());

        System.out.print("ans:\n"+dp[n][w]);

    }
}
