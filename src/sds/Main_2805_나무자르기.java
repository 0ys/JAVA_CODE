package sds;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
    static int N, M;
    static int[] treeArr;
    static int ANSWER = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeArr = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        for(int i=0; i<N; i++){
            treeArr[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, treeArr[i]);
        }
        br.close();

        binarySearch(maxHeight);

        System.out.println(ANSWER);
    }

    static void binarySearch(int maxHeight){
        int min = 0;
        int max = maxHeight;
        int mid;

        while(min < max) {
            mid = (min + max)/2;
            if(calcSum(mid) >= M){
                // #1. mid 값은 만족 에 포함
                // bar 를 높인다
                min = mid + 1;
            }
            else{
                // #2. mid 값은 만족 에 포함되지 않음
                // bar 를 낮춘다
                max = mid;
            }
        }

        // 마지막 만족값을 찾고 - #1 수행 - 그 다음 루프에 min == max라서 while 탈출 이므로
        // 답은 마지막 min - 1 값 (다시 말하자면 upperbound를 구한 것이다.)
        ANSWER = min - 1;
    }

    static long calcSum(int cuttingHeight){
        long sum = 0L;
        for(int treeHeight : treeArr){
            int gap = treeHeight - cuttingHeight;
            if(gap > 0){
                sum += gap;
            }
        }
        return sum;
    }
}
