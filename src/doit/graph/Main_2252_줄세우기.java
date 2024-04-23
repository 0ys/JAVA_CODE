package doit.graph;

import java.io.*;
import java.util.*;

public class Main_2252_줄세우기 {
    static ArrayList<Integer>[] graph;
    static int[] D; // 진입 차수 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        D = new int[n+1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            D[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(D[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            bw.write(now+" ");
            for(int next : graph[now]){
                D[next]--;
                if(D[next] == 0){
                    q.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
