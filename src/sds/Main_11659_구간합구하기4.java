package sds;

import java.util.*;
import java.io.*;

public class Main_11659_구간합구하기4 {
    static int N, M;
    static int[] number;
    static int[] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        number = new int[N+1];
        sum = new int[N+1];
        for(int i=1; i<=N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i-1]+number[i];
        }

//		for(int s : sum) {
//			System.out.print(s+ " ");
//		}

        for(int a=0; a<M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write((sum[j]-sum[i-1])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
