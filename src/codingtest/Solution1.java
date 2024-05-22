package codingtest;

import java.util.*;
import java.io.*;

// SSAFY 2024 1
/*
N개의 원소를 가지는 수열이 주어졌을 때, 총 N^2개의 순서쌍 (a, b)를 만들 수 있다.
a와 b는 모든 원소가 될 수 있다(중복가능).
각 순서쌍을 오름차순 정렬할 때, K번째 순서쌍의 합을 구하라.
 */
public class Solution1 {
    static PriorityQueue<Pair> que;
    static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            if(this.a == o.a) {
                return this.b - o.b;
            }
            return this.a - o.a;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            que = new PriorityQueue<>();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    que.add(new Pair(arr[i], arr[j]));
                }
            }

            for(int i=0; i<K-1; i++) {
                que.poll();
            }

            Pair kth = que.poll();
            bw.write("#"+tc+" "+(kth.a + kth.b)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
