package sds;

import java.util.*;
import java.io.*;

public class Main_1932_정수삼각형 {
    static int N;
    static int[][] triangle;
    static int[][] DP;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1][N+1];
        triangle = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] += Math.max(DP[i-1][j-1], DP[i-1][j])+triangle[i][j];
            }
        }

//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=N; j++) {
//				System.out.print(triangle[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println("================");
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=N; j++) {
//				System.out.print(DP[i][j]+ " ");
//			}
//			System.out.println();
//		}

        int answer = 0;
        for(int a : DP[N]) {
            if(answer < a) {
                answer = a;
            }
        }
        System.out.println(answer);

    }
}
