//https://atcoder.jp/contests/agc043/tasks/agc043_a

package DP;

import java.io.PrintWriter;
import java.util.*;

public class RangeFlip {

    Scanner sc = new Scanner(System.in);

    PrintWriter out = new PrintWriter(System.out);

    int h = sc.nextInt();
    int w = sc.nextInt();
    char[][] arr = new char[h][w];
    int[][] dp = new int[h][w];

    int[] dx = {0, 1};
    int[] dy = {1, 0};

    public static void main(String[] args) {
        new RangeFlip().run();
    }

    void run() {
        for (int i=0; i<h; i++) {
            arr[i] = sc.next().toCharArray();
        }

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                for (int k=0; k<2; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (0<=ny && ny<h && 0<=nx && nx<w) {
                        if (arr[ny][nx]=='.') {
                            int up = Integer.MAX_VALUE;
                            int left = Integer.MAX_VALUE;
                            if (0<=ny-1) {
                                up = dp[ny-1][nx];
                            }
                            if (0<=nx-1) {
                                left = dp[ny][nx-1];
                            }
                            dp[ny][nx] = Math.min(up, left);
                        } else if (arr[ny][nx]=='#') {
                            int up = Integer.MAX_VALUE;
                            int left = Integer.MAX_VALUE;
                            if (0<=ny-1) {
                                up = dp[ny-1][nx];
                            }
                            if (0<=nx-1) {
                                left = dp[ny][nx-1];
                            }
                            if (0<=ny-1) {
                                if (arr[ny-1][nx]=='.') {
                                    up = dp[ny-1][nx]+1;
                                } else {
                                    up = dp[ny-1][nx];
                                }
                            }
                            if (0<=nx-1) {
                                if (arr[ny][nx-1]=='.') {
                                    left = dp[ny][nx-1]+1;
                                } else {
                                    left = dp[ny][nx-1];
                                }
                            }
                            dp[ny][nx] = Math.min(up, left);
                        }
                    }
                }
            }
        }
//        for (int i=0; i<h; i++) {
//            for (int j=0; j<w-1; j++) {
//                out.print(dp[i][j]);
//            }
//            out.println(dp[i][w-1]);
//        }
        if (arr[0][0]=='#') out.println(dp[h-1][w-1]+1);
        else out.println(dp[h-1][w-1]);
        out.flush();
    }
}

