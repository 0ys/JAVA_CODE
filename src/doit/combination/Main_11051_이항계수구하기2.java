package doit.combination;

import java.util.Scanner;

public class Main_11051_이항계수구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] DP = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            DP[i][0] = 1;
            DP[i][1] = i;
            DP[i][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j]) % 10007;
            }
        }

        System.out.println(DP[n][k]);
    }
}
