package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_9251_LCS {
    static int N, M;
    static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        N = A.length;
        M = B.length;
        DP = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(A[i-1] == B[j-1]){
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }

        System.out.println(DP[N][M]);

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = N;
        int j = M;
        while(i > 0 && j > 0) {
            if(DP[i][j] == DP[i-1][j]) {
                i--;
            } else if (DP[i][j] == DP[i][j-1]) {
                j--;
            } else {
                stack.push(A[i-1]);
                i--;
                j--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
