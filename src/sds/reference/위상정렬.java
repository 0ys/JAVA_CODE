package sds.reference;

import java.io.*;
import java.util.*;

public class 위상정렬 {
    /*
    DAG(비순환 방향 그래프)에서 그래프의 방향성을 거스르지 않고 정점들을 나열하는 것.
    즉 그래프의 방향이 있고, 사이클은 없는 그래프를 정렬할 때 사용한다.
    위상정렬은 각 정점을 우선순위에 따라 배치한다. 일반적으로 위상정렬의 결과는 유일하지 않다.
     */
    static int[] degree;
    static ArrayList<Integer>[] adj;
    static Queue<Integer> que;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N+1]; // 그래프는 1번부터 시작하는 것이 편함
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>(); //그래프 초기화
        }

        // 노드를 받아서 인접리스트에 넣고,
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            degree[B]++; // 차수도 바로 더해줌
        }

        // 인접리스트를 출력
        for(int i=1; i<=N; i++) {
        	System.out.print("node "+i);
        	for(int j=0; j<adj[i].size(); j++) {
        		System.out.print(" -> "+adj[i].get(j));
        	}
        	System.out.print(" | degree: "+degree[i]);
        	System.out.println();
        }

        // 큐를 선언해서 in-degree가 0인 노드를 넣음
        que = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(degree[i]==0) { //leaf node를 찾음 = 진입차수가 0인 노드
                que.add(i);
            }
        }

        // 각 정점을 우선순위에 따라 배치함
        while(!que.isEmpty()) {
            int now = que.poll();
            bw.write(now + " ");

            for(Integer next : adj[now]) {
                degree[next]--;
                if(degree[next] == 0) {
                    que.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
