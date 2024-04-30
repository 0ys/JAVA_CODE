package doit.graph;

import java.io.*;
import java.util.*;

// 시간 제한 0.5초, 메모리 제한 128MB
public class Main_1916_최소비용구하기 {
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] DP;
    static boolean[] visited;
    static class Node implements Comparable<Node>{
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        DP = new int[N + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        DP[start] = 0;
        while(!pq.isEmpty()){
            Node e = pq.poll();
            int now = e.to;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node n : graph[now]){
                int next = n.to;
                int nextCost = n.cost;
                if(DP[next] > DP[now] + nextCost){
                    DP[next] = DP[now] + nextCost;
                }
                pq.add(new Node(next, DP[next]));
            }
        }

        System.out.println(DP[end]);
    }
}
