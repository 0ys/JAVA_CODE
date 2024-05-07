package doit.combination;

import java.util.Scanner;

public class Main_2775_부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] DP = new int[k+1][n+1];
            for(int i = 1; i <= n; i++){
                DP[0][i] = i;
            }

            for(int i = 1; i <= k; i++){
                DP[i][1] = 1;
            }

            for(int i = 1; i <= k; i++){
                for(int j = 2; j <= n; j++){
                    DP[i][j] = DP[i-1][j] + DP[i][j-1];
                }
            }

            System.out.println(DP[k][n]);
        }
    }
}
