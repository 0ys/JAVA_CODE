package sds;

import java.util.*;
import java.io.*;

public class Main_2579_계단오르기 {
    static int[] DP;
    static int[] score;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1];
        score = new int[N+1];
        for(int i=1; i<=N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = score[1];

        if(N >= 2) {
            DP[2] = score[1]+score[2];
        }

        for(int i=3; i<=N; i++) {
            DP[i] = Math.max(DP[i-2], DP[i-3]+score[i-1]) + score[i];
        }

//		for(int d : DP) {
//			System.out.print(d+" ");
//		}

        System.out.println(DP[N]);
    }
}
