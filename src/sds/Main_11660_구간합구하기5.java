package sds;

import java.util.*;
import java.io.*;

public class Main_11660_구간합구하기5 {
    static int N, M;
    static int[][] table, sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N+1][N+1];
        sum = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                //sum[i][j] += sum[i][j-1] + table[i][j];
                // 다른 풀이
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + table[i][j];
            }
        }

//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=N; j++) {
//				System.out.print(sum[i][j]+" ");
//			}
//			System.out.println();
//		}

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

//			int a = 0;
//			for(int j=x1; j<=x2; j++) {
//				a += sum[j][y2]-sum[j][y1-1];
//			}
            // 다른 풀이
            int a = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            bw.write(a+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
