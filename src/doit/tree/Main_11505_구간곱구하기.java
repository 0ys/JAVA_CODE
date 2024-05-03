package doit.tree;

import java.io.*;
import java.util.*;

public class Main_11505_구간곱구하기 {
    static int modNum = 1000000007; // 나머지로 나오는 결과를 잘 생각해야 함!
    static int N, M, K;
    static long[] indexTree;
    static int leafPointer;
    static long[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        inputs = new long[N];
        for(int i = 0; i < N; i++) {
            inputs[i] = Long.parseLong(br.readLine());
        }

        initTree();

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                Update(b, c);
            } else {
                System.out.println(Query(b, c));
            }
        }
    }

    static void initTree(){
        int leafCnt = 1;
        while(leafCnt < N){
            leafCnt *= 2;
        }

        leafPointer = leafCnt;
        indexTree = new long[leafCnt*2];
        Arrays.fill(indexTree, 1);

        for(int i = 0; i < N; i++){
            indexTree[leafPointer+i] = inputs[i];
        }

        for(int i = leafPointer-1; i > 0; i--){
            indexTree[i] = (indexTree[i*2] * indexTree[i*2+1]) % modNum;
        }
    }

    static void Update(int index, int value) {
        index += leafPointer - 1;
        indexTree[index] = value;

        for(int i = index/2 ; i > 0; i /= 2){
            indexTree[i] = (indexTree[i*2] * indexTree[i*2+1]) % modNum;
        }
    }

    static long Query(int left, int right) {
        left += leafPointer - 1;
        right += leafPointer - 1;

        long result = 1L;
        while(left <= right){
            if(left % 2 == 1){
                result *= indexTree[left];
                result %= modNum;
                left++;
            }
            if(right % 2 == 0){
                result *= indexTree[right];
                result %= modNum;
                right--;
            }
            left /= 2;
            right /= 2;
        }

        return result;
    }
}
