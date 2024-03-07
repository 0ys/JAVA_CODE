package sds;

import java.io.*;
import java.util.*;

public class Main_1516_게임개발 {
    public static int[] bDegree;
    public static int[] bTime;
    public static int[] bResult;
    public static ArrayList<Integer>[] adj;
    public static int N;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        bDegree = new int[N+1];
        bTime = new int[N+1];
        bResult = new int[N+1];

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            bTime[i] = time;
            int cBuilding = Integer.parseInt(st.nextToken());
            while(cBuilding != -1) {
                adj[cBuilding].add(i);
                bDegree[i]++;
                cBuilding = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=1; i<=N; i++) {
//        	System.out.print("node "+i);
//        	for(int j=0; j<adj[i].size(); j++) {
//        		System.out.print(" -> "+adj[i].get(j));
//        	}
//        	System.out.print(" | degree: "+bDegree[i]+" | time: "+bTime[i]);
//        	System.out.println();
//        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(bDegree[i] == 0) {
                que.add(i);
                bResult[i] = bTime[i];
            }
        }

        while(!que.isEmpty()) {
            int now = que.poll();

            for(Integer next : adj[now]) {
                bResult[next] = Math.max(bResult[now]+bTime[next], bResult[next]);
                bDegree[next]--;
                if(bDegree[next]==0) {
                    que.add(next);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            bw.write(bResult[i]+"\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }
}
