package doit.graph;

import java.io.*;
import java.util.*;

public class Main_11657_타임머신으로빨리가기 {
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static int N, M;
    static long[] DP;
    static ArrayList<Edge> edges; // 에지 리스트 형태로 그래프를 저장함
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 버스의 개수
        
        DP = new long[N + 1];
        Arrays.fill(DP, Long.MAX_VALUE);
        
        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost)); // 모든 에지를 저장
        }
        
        // 벨만 포드 알고리즘
        boolean checked = false; // 음수 사이클 여부
        DP[1] = 0L;
        for (int i = 1; i <= N; i++) { // DP 업데이트를 N-1번 반복하고, N번 째에 음수 사이클을 확인함
            for(Edge e : edges) { // 모든 에지에 대해 계속 탐색함
                int start = e.from;
                int end = e.to;
                int time = e.cost;
                // 정답 배열 업데이트 조건 : 무한대가 아닌 DP 값 중에 최단 거리
                if(DP[start] != Long.MAX_VALUE && DP[end] > DP[start]+time) {
                    DP[end] = DP[start]+time;
                    if(i==N) checked = true; // N 번째에 업데이트가 발생함 = 음수 사이클이 존재함
                }
            }
        }

        if(checked) bw.write("-1\n");
        else {
            for(int i = 2; i <= N; i++) {
                if(DP[i] == Long.MAX_VALUE) bw.write("-1\n");
                else bw.write(DP[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
