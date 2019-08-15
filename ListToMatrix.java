import java.util.*;

public class ListToMatrix {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int node[] = new int[n];
        int k[] = new int[n];
        int adja_list[][] = new int[n][n];

        for (int i=0; i<n; i++){
            node[i] = sc.nextInt();
            k[i] = sc.nextInt();
            for (int j=0; j<k[i]; j++) adja_list[i][j] = sc.nextInt();
        }

        int adja_matrix[][] = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<k[i]; j++){
                adja_matrix[i][adja_list[i][j]-1] = 1;
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n-1; j++){
                System.out.print(adja_matrix[i][j]+" ");
            }
            System.out.println(adja_matrix[i][n-1]);
        }
    }
}
