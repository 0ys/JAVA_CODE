package doit.graph;

import java.io.*;
import java.util.*;

public class Main_1516_게임개발하기 {
    static int[] degree;
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] cost;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        cost = new int[N+1];
        degree = new int[N+1];
        result = new int[N+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            cost[i] = time;
            int prefix = Integer.parseInt(st.nextToken());
            while(prefix != -1){
                adj[prefix].add(i);
                degree[i]++;
                prefix = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0){
                q.add(i);
                result[i] = cost[i];
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : adj[now]){
                if(result[next] < result[now] + cost[next]){
                    result[next] = result[now] + cost[next];
                }
                degree[next]--;
                if(degree[next] == 0){
                    q.add(next);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.println(result[i]);
        }
    }
}
