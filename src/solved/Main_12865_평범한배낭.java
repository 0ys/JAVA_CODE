package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_12865_평범한배낭 {
    static int N, K;
    static PriorityQueue<Things> pq = new PriorityQueue<>();
    static class Things implements Comparable<Things> {
        int weight, value;
        public Things(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Things o) {
            if(this.value == o.value){
                return this.weight - o.weight;
            }
            return o.value - this.value;
        }
    }
    static int[] W; // weight
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            W[i] = weight;
            pq.add(new Things(weight, value));
        }
        Arrays.sort(W);

        int bag = 0;
        int maxValue = 0;
        int nowValue = 0;
        while(!pq.isEmpty()){
            Things t = pq.poll();
            bag += t.weight;
            nowValue += t.value;
            if(bag > K){
                nowValue = t.value;
                bag = t.weight;
            }
            if(nowValue > maxValue){
                maxValue = nowValue;
            }
        }

        System.out.println(maxValue);
    }
}
