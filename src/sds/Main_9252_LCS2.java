package sds;

import java.util.*;
import java.io.*;

public class Main_9252_LCS2 {
    static int[][] DP;
    static int n, m;
    static String a, b;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();

        n = a.length();
        m = b.length();

        DP = new int[n+1][m+1];

        System.out.println(LCS());
        getLCSToString(a, n, m);
        System.out.println(sb.toString());

    }

    static void getLCSToString(String str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while(i>0 && j>0) {
            if(DP[i][j] == DP[i-1][j]) {
                i--;
            }else if(DP[i][j] == DP[i][j-1]) {
                j--;
            }else {
                st.push(str.charAt(i-1));
                i--;
                j--;
            }
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

    static int LCS() {
        int max = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
                }
                max = Math.max(max, DP[i][j]);
            }
        }
        return max;
    }
}
