package self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202 {
    static class Jewel{
        int m, v;
        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    static PriorityQueue<Jewel> pq;
    static int[] bag;
    static Jewel[] jewel;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewel = new Jewel[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel[i] = new Jewel(m, v);
        }
        Arrays.sort(jewel, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.m - o2.m; // 보석 무게를 기준으로 오름차순 정렬 (가벼운거부터)
            }
        });

        bag = new int[K];
        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        pq = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o2.v - o1.v; // 보석 가격을 기준으로 내림차순 (비싼거부터)
            }
        });

        long result = 0;
        int jewelIndex = 0;
        for(int i=0; i<K; i++){
            // i번째 가방에 넣을 수 있는 무게의 보석들을 모두 pq에 추가
            // 무게 2를 담을 수 있는 가방에는 무게가 1, 2인 보석을 담을 수 있음
            while (jewelIndex < N && jewel[jewelIndex].m <= bag[i]) {
                pq.add(jewel[jewelIndex++]);
            }
            // 현재 i번째 가방에 넣을 수 있는 보석 중 제일 비싼 걸 더함
            // i+1번째 가방으로 넘어가도, 현재 pq에 담겨있는 보석을 담을 수 있음(미리 정렬했기 때문)
            if(!pq.isEmpty()){
                result += pq.poll().v;
            }
        }

        System.out.println(result);
    }
}
