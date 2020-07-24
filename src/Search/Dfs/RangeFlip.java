//https://atcoder.jp/contests/agc043/tasks/agc043_a

package Search.Dfs;

import java.io.PrintWriter;
import java.util.*;

public class RangeFlip {

    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int w = sc.nextInt();

    char[][] arr = new char[h][w];

    int[] dx = {1, 0};
    int[] dy = {0, 1};

    int ans = Integer.MAX_VALUE;

    int[][] visit = new int[h][w];

    public static void main(String[] args) {
        new RangeFlip().run();
    }

    void run() {
        for (int i=0; i<h; i++) {
            arr[i] = sc.next().toCharArray();
        }

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(0, 0, 0);

        PrintWriter out = new PrintWriter(System.out);
        if (arr[0][0]=='#') {
            out.print(ans+1);
        } else {
            out.print(ans);
        }
        out.flush();

    }

    int dfs(int y, int x, int cnt) {
        if (y==h-1 && x==w-1) {
            ans = Math.min(ans, cnt);
        }

        visit[y][x] = cnt;
        char c = arr[y][x];

        if (c=='.') {
            for (int i=0; i<2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (arr[ny][nx] == '.') {
                        if (cnt<visit[ny][nx]) dfs(ny, nx, cnt);
                    } else {
                        if (cnt+1<visit[ny][nx]) dfs(ny, nx, cnt + 1);
                    }
                }
            }
        } else {
            for (int i=0; i<2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];


                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (arr[ny][nx] == '.') {
                        if (cnt<visit[ny][nx]) dfs(ny, nx, cnt);
                    } else {
                        if (cnt<visit[ny][nx]) dfs(ny, nx, cnt);
                    }
                }
            }
        }
        return ans;
    }
}