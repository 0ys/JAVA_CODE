package doit.sort;

import java.util.*;
import java.io.*;

public class Main_1517_버블소트프로그램2 {
    static int N;
    static long swap; // long으로 선언해줘야 맞음
    static long[] A, tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new long[N+1];
        tmp = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        merge_sort(1, N);

        System.out.println(swap);
    }

    static void merge_sort(int s, int e){
        if(e-s < 1) return;
        int m = s + (e-s)/2;
        merge_sort(s, m);
        merge_sort(m+1, e);

        for(int i=s; i<=e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1<=m && index2<=e){
            if(tmp[index1]>tmp[index2]){
                A[k] = tmp[index2];
                swap += m-index1+1;
                index2++;
                k++;
            } else {
                A[k] = tmp[index1];
                index1++;
                k++;
            }
        }
        while(index1<=m){
            A[k] = tmp[index1];
            k++;
            index1++;

        }
        while(index2<=e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
