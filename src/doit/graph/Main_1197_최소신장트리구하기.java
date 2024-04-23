package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1197_최소신장트리구하기 {
    static PriorityQueue<Edge> edges;
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int[] parent; // 유니온 파인드 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new PriorityQueue<>();
        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }
        int usedEdge = 0;
        int result = 0;
        while(usedEdge < V-1){
            Edge e = edges.poll();
            int now = e.from;
            int next = e.to;
            if(Find(now) != Find(next)){
                Union(now, next);
                result = result + e.cost;
                usedEdge++;
            }
        }

        System.out.println(result);

    }

    public static void Union(int a, int b) {
        int aRoot = Find(a);
        int bRoot = Find(b);
        parent[aRoot] = bRoot;
    }

    public static int Find(int v) {
        if(v == parent[v]) return v;
        return parent[v] = Find(parent[v]);
    }
}
