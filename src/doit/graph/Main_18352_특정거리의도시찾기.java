package doit.graph;

import java.util.*;

public class Main_18352_특정거리의도시찾기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] DP;
    static int N, M, K, X;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 도시의 개수
        M = sc.nextInt(); // 도로의 개수
        K = sc.nextInt(); // 도로 가중치
        X = sc.nextInt(); // 출발 도시

        visited = new boolean[N+1];
        DP = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
        }

        BFS(X);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(DP[i] == K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for(int a : answer){
                System.out.println(a);
            }
        }
    }

    static public void BFS(int start){
        Queue<Integer> que = new LinkedList<>(); // 가중치를 따지지 않으니깐 일반 큐를 사용해야 함, priorityQueue를 쓰면 틀림
        que.add(start);
        visited[start] = true;
        DP[start] = 0;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int e : adj[now]){
                if(!visited[e]){
                    visited[e] = true;
                    DP[e] = DP[now]+1;
                    que.add(e);
                }
            }
        }
    }
}
