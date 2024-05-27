package solved;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
    static ArrayList<Edge> edges;
    static class Edge {
        int start, end, time;
        public Edge(int s, int e, int t) {
            this.start = s;
            this.end = e;
            this.time = t;
        }
    }
    static class WormHole implements Comparable<WormHole>{
        int index, value;
        public WormHole(int i, int v) {
            this.index = i;
            this.value = v;
        }

        @Override
        public int compareTo(WormHole o) {
            return this.value - o.value;
        }
    }
    static int[] DP;
    static int N, M, W;
    static PriorityQueue<WormHole> wormhole;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for(int i = 0; i < M; i++) { // 도로
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));

            }

            wormhole = new PriorityQueue<>();
            for(int i = M; i < M+W; i++) { // 웜홀
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
                wormhole.add(new WormHole(e, -t));
            }

            boolean backward = BellmanFord();

            if(backward) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    static boolean BellmanFord() {
        DP = new int[N + 1];
        for(WormHole start : wormhole) {
            Arrays.fill(DP, Integer.MAX_VALUE);
            DP[start.index] = 0;
            for(int i = 0; i < N+500; i++) {
                for(Edge edge : edges) {
                    if(DP[edge.start] != Integer.MAX_VALUE && DP[edge.end] > DP[edge.start]+edge.time) {
                        DP[edge.end] = DP[edge.start]+edge.time;
                        //printDP();
                        if(i >= N) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    static void printDP (){
        for(int d = 1; d <= N; d++) {
            System.out.print(DP[d] + " ");
        }
        System.out.println();
    }
}
