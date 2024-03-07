package sds;

import java.util.*;
import java.io.*;

public class Main_5582_공통부분문자열 {
    static int[][] DP;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();
        DP = new int[n+1][m+1];

        int max = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;
                    max = Math.max(max,  DP[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
