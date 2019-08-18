import java.util.*;

public class LCS{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        String x[] = new String[q];
        String y[] = new String[q];

        for (int i=0; i<q; i++){
            x[i] = sc.next();
            y[i] = sc.next();
        }

        for (int i=0; i<q; i++){
            int x_len = x[i].length();
            int y_len = y[i].length();

            int xy[][] = new int[x_len+1][y_len+1];

            for (int j=0; j<x_len+1; j++) xy[j][0] = 0;
            for (int k=1; k<y_len+1; k++) xy[0][k] = 0;

            for (int l=1; l<x_len+1; l++){
                for (int m=1; m<y_len+1; m++){
                    if (x[i].charAt(l-1)==y[i].charAt(m-1)){
                        xy[l][m] = xy[l-1][m-1] +1;
                    }else if (xy[l][m-1]<=xy[l-1][m]){
                        xy[l][m] = xy[l-1][m];
                    }else{
                        xy[l][m] = xy[l][m-1];
                    }
                }
            }
            System.out.println(xy[x_len][y_len]);
        }

    }
}