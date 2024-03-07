package doit.sort;

import java.io.*;
import java.util.Arrays;

public class Main_1377_버블소트프로그램1 {
    static class Data implements Comparable<Data>{
        int index, value;
        public Data(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value; // 오름차순
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Data[] A = new Data[N];
        for(int i=0; i<N; i++){
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(A);

        int Max = 0;
        for(int i=0; i<N; i++){
            if(Max < A[i].index - i){
                Max = A[i].index - i;
            }
        }

        System.out.println(Max+1);

    }
}
