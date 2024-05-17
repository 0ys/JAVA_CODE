package doit.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11049_행렬곱셈순서 {
    static int N;
    static Matrix[] M;
    static class Matrix {
        int x, y;
        Matrix(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = new Matrix[N+1];
        D = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(D[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y, x);
        }

        System.out.println(excute(1, N));
    }

    static int excute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) return D[s][e]; // 메모이제이션
        if(s == e) return 0; // 행렬 1개의 곱셈 연산의 수
        if(s+1 == e) return M[s].y * M[s].x * M[e].x; // 행렬 2개의 곱셈 연산의 수

        // 행렬 3개 이상일 때 곱셈 연산의 수 = 점화식 처리
        for(int i = s; i < e; i++) {
            result = Math.min(result, M[s].y * M[i].x * M[e].x + excute(s, i) + excute(i + 1, e));
        }

        return D[s][e] = result;
    }
}
