package doit.datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1546_평균구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        double max = 0;
        double sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            if(max<score[i]) max = score[i];
            sum += score[i];
        }

        System.out.println(sum*100/max/N);
    }
}
