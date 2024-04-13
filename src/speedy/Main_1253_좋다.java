package speedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253_좋다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            long target = arr[i];

            while (start < end) {
                long sum = arr[start] + arr[end];
                if (sum == target) {
                    if(start != i && end != i){
                        cnt++;
                        break;
                    } else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }

                } else if(sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}
