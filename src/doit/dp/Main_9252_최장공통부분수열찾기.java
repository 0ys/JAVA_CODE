package doit.dp;

import java.io.*;
import java.util.*;

public class Main_9252_최장공통부분수열찾기 {
    static long[][] DP;
    static ArrayList<Character> Path; // LCS를 저장할 리스트
    static char[] A, B; // 주어진 문자열 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        DP = new long[A.length+1][B.length+1];
        Path = new ArrayList<Character>();
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]) { // 같은 문자일 때 왼쪽 대각선값 +1
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else { // 다르면 왼쪽과 위의 값 중 큰 수
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }

        System.out.println(DP[A.length][B.length]); // LCS 길이
        getText(A.length, B.length);
        for(int i = Path.size()-1; i >= 0; i--) {
            System.out.print(Path.get(i));
        }
    }

    static void getText(int row, int column) {
        if(row == 0 | column == 0) return;
        if(A[row-1] == B[column-1]) {
            Path.add(A[row-1]);
            getText(row-1, column-1);
        } else {
            if(DP[row-1][column] > DP[row][column-1]) {
                getText(row-1, column);
            } else {
                getText(row, column-1);
            }
        }
    }
}
