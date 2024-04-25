package doit.tree;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기3 {
    static long[] input, tree;
    static int leafPointer;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new long[N];
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(br.readLine());
        }

        initTree();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b, Long.parseLong(st.nextToken()));
            } else if (a == 2) {
                bw.write(query(b, Integer.parseInt(st.nextToken()))+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void initTree() {
        int leafCount = 1;
        while (N > leafCount) {
            leafCount *= 2;
        }

        leafPointer = leafCount;
        tree = new long[leafCount * 2];
        for (int i = 0; i < N; i++) {
            tree[leafPointer + i] = input[i];
        }

        for (int i = leafPointer - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public static void update(int index, long value) {
        int leafIndex = index + leafPointer - 1;
        tree[leafIndex] = value;
        leafIndex /= 2;

        while(leafIndex > 0){
            tree[leafIndex] = tree[leafIndex*2] + tree[leafIndex*2 + 1];
            leafIndex /= 2;
        }
    }

    public static long query(int start, int end) {
        int left = start + leafPointer - 1;
        int right = end + leafPointer - 1;

        long result = 0L;
        while (left <= right) { // 교차할 때까지이니깐 <= 로 비교해야 함!!
            if(left % 2 == 1){
                result += tree[left];
                left++;
            }
            if(right % 2 == 0){
                result += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return result;
    }
}
