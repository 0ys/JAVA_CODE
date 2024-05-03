package doit.tree;

import java.io.*;
import java.util.*;

public class Main_10868_최솟값찾기2 {
    static int N, M;
    static int leafPointer;
    static int[] indexTree;
    static int[] inputs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        initTree();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(Query(a, b)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void initTree() {
        int leaftCnt = 1;
        while(leaftCnt < N){
            leaftCnt *= 2;
        }

        indexTree = new int[leaftCnt*2];
        Arrays.fill(indexTree, Integer.MAX_VALUE);
        leafPointer = leaftCnt;

        for(int i = 0; i < N; i++){
            indexTree[leafPointer + i] = inputs[i];
        }

        for(int i = leafPointer-1; i > 0; i--){
            indexTree[i] = Math.min(indexTree[i*2], indexTree[i*2+1]);
        }
    }

    static int Query(int a, int b) {
        int left = leafPointer + a - 1;
        int right = leafPointer + b - 1;
        int minValue = Integer.MAX_VALUE;

        while(left <= right){
            if(left % 2 == 1){
                minValue = Math.min(minValue, indexTree[left]);
                left++;
            }
            if(right % 2 == 0){
                minValue = Math.min(minValue, indexTree[right]);
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return minValue;
    }
}
