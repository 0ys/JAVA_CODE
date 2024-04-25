package doit.combination;

import java.util.Scanner;

public class Main_11050_이항계수구하기1 {
    static int N, K;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // DP 배열 초기화
        D = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        // 조합 기본 점화식으로 채우기
        for(int i = 2; i <= N; i++){
            for(int j = 1; j < i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }

        System.out.println(D[N][K]);
    }
}
