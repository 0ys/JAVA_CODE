package doit.datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기 {
    static int N, M;
    static long[] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sum = new long[N+1];
        for(int i=1; i<=N; i++) {
            sum[i] += sum[i-1]+Integer.parseInt(st.nextToken());
        }

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
