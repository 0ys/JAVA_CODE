package sds;

import java.io.*;
import java.util.*;

public class Main_2252_줄세우기 {
    static int[] sDegree;
    static ArrayList<Integer>[] adj;
    static int N, M; // 학생들의 번호N, 키 비교 건수: M

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sDegree = new int[N+1]; // 그래프는 1번부터 시작하는 것이 편함
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>(); //그래프 초기화
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            sDegree[B]++; // 차수도 바로 더해줌
        }

//        for(int i=1; i<=N; i++) {
//        	System.out.print("node "+i);
//        	for(int j=0; j<adj[i].size(); j++) {
//        		System.out.print(" -> "+adj[i].get(j));
//        	}
//        	System.out.print(" | degree: "+sDegree[i]);
//        	System.out.println();
//        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(sDegree[i]==0) { //leaf node를 찾음 = 진입차수가 0인 노드
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int now = que.poll();
            bw.write(now + " ");

            for(Integer next : adj[now]) {
                sDegree[next]--;
                if(sDegree[next] == 0) {
                    que.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }
}
