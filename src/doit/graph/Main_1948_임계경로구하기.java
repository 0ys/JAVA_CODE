package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1948_임계경로구하기 {
    static int N, M;
    static ArrayList<City>[] graph;
    static ArrayList<City>[] reverseGraph;
    static int[] degree, result;
    static int start, end;
    static class City {
        int to, time;
        City(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        degree = new int[N + 1];
        result = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발도시
            int b = Integer.parseInt(st.nextToken()); // 도착도시
            int c = Integer.parseInt(st.nextToken()); // 걸리는 시간

            graph[a].add(new City(b, c));
            reverseGraph[b].add(new City(a, c));
            degree[b]++;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 임계 경로 시간 구하기
        Queue<City> q = new ArrayDeque<>();
        q.add(new City(start, 0));
        result[start] = 0;

        while(!q.isEmpty()){
            City e = q.poll();
            int now = e.to;
            int nowCost = e.time;
            for(City c : graph[now]){
                int next = c.to;
                int nextCost = c.time;
                result[next] = Math.max(result[next], nowCost + nextCost);
                degree[next]--;
                if(degree[next] == 0){
                    q.add(new City(next, result[next]));
                }
            }
        }

        // 1분도 쉬지 않고 달려야 하는 도로의 수 세기
        // 이 도시의 임계 경로값 + 도로 시간 == 이전 도시의 임계 경로값일 경우에 해당 도로를 카운트
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        Queue<Integer> reverseQue = new ArrayDeque<>();
        reverseQue.add(end);
        visited[end] = true;
        while(!reverseQue.isEmpty()){
            int now = reverseQue.poll();
            int nowCost = result[now]; // 이전 도시의 임계 경로 값
            for(City c : reverseGraph[now]){
                int next = c.to;
                int nextCost = result[next]; // 지금 도시의 임계 경로 값
                if(nowCost == nextCost + c.time){
                    cnt++;
                    if(visited[next]) continue; // 중복 노드에 방문하지 않도록 신경써서 큐에 넣어야 함!!!!!!!!
                    visited[next] = true;
                    reverseQue.add(next);
                }
            }
        }

        System.out.println(result[end]);
        System.out.println(cnt);


    }
}
