package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1219_세일즈맨의고민 {
    static int N, M, start, end;
    static ArrayList<Edge> edges;
    static long[] DP;
    static int[] Money;

    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, w));
        }

        Money = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Money[i] = Integer.parseInt(st.nextToken());
        }

        DP = new long[N];
        Arrays.fill(DP, Long.MIN_VALUE);
        DP[start] = Money[start];

        for(int i = 0; i < N + 100; i++){
            for(Edge e : edges){
                int from = e.from;
                int to = e.to;
                int cost = e.cost;
                if(DP[from] == Long.MIN_VALUE) continue; // 미방문 노드를 스킵
                else if(DP[from] == Long.MAX_VALUE){ // 양수 싸이클에 포함되는 노드를 표시
                    DP[to] = Long.MAX_VALUE;
                } else if(DP[to] < DP[from] + Money[to] - cost){
                    DP[to] = DP[from] + Money[to] - cost;
                    if(i >= N-1){
                        DP[to] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(DP[end] == Long.MAX_VALUE){
            System.out.println("Gee");
        } else if(DP[end] == Long.MIN_VALUE){
            System.out.println("gg");
        } else {
            System.out.println(DP[end]);
        }
    }
}
