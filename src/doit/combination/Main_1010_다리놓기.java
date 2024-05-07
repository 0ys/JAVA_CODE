package doit.combination;

import java.util.Scanner;

public class Main_1010_다리놓기 {
    public static void main(String[] args) {
        int[][] DP = new int[31][31];
        for(int i = 0; i < 31; i++){
            DP[i][0] = 1;
            DP[i][1] = i;
            DP[i][i] = 1;
        }

        for(int i = 1; i < 31; i++){
            for(int j = 2; j < i; j++){
                DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
            }
        }


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(DP[M][N]);
        }
    }
}
