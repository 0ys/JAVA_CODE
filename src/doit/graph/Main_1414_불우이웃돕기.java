package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1414_불우이웃돕기 {
    static int N;
    static PriorityQueue<Edge> edges;
    static int[] parents;
    static class Edge implements Comparable<Edge> {
        int start, end, cost;
        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int total = 0; // 전체 랜선의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        edges = new PriorityQueue<>();
        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            String inputString = br.readLine();
            for(int j = 0; j < N; j++){
                int input = 0;
                char c = inputString.charAt(j);
                if(c >= 'A' && c <= 'Z'){
                    input = (c - 'A') + 27;
                }else if(c >= 'a' && c <= 'z'){
                    input = (c - 'a') + 1;
                }
                if(input != 0) {
                    edges.add(new Edge(i, j, input));
                    total += input;
                }
            }
        }

        int edgeCnt = 0; // 연결한 에지의 개수
        int result = 0; // 선택된 에지의 비용
        while(!edges.isEmpty()){
            if(edgeCnt == N) break;
            Edge now = edges.poll();
            int start = now.start;
            int end = now.end;
            int cost = now.cost;

            if(Find(start) != Find(end)){
                Union(start, end);
                edgeCnt++;
                result += cost;
            }
        }

        if(edgeCnt == N-1) System.out.println(total - result);
        else System.out.println(-1);
    }

    public static void Union(int a, int b){
        int aRoot = Find(a);
        int bRoot = Find(b);
        parents[aRoot] = bRoot;
    }

    public static int Find(int x){
        if(parents[x] == x) return x;
        return parents[x] = Find(parents[x]);
    }
}
