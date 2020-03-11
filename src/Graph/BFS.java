package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;


public class BFS{
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] d = new int[n];
    static List<Integer>[] list = new ArrayList[n];
    public static void main(String[] args){
        for (int i=0; i<n; i++) list[i] = new ArrayList<>();
        for (int i=0; i<n; i++){
            int t = sc.nextInt()-1;
            int k = sc.nextInt();
            for (int j=0; j<k; j++){
                int u = sc.nextInt()-1;
                list[t].add(u);
            }
        }
        for (int i=0; i<n; i++) d[i] = Integer.MAX_VALUE;
        d[0] = 0;
        bfs(0);

        for (int i=0; i<n; i++){
            System.out.print(i+1+" ");
            System.out.println(d[i]);
        }

    }

    public static void bfs(int s){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int t = ((ArrayDeque<Integer>) queue).peekFirst();
            for (int edge: list[t]){
                d[edge] = Math.min(d[edge], d[t]+1);
                queue.add(edge);
            }
            ((ArrayDeque<Integer>) queue).poll();
        }
    }
}
