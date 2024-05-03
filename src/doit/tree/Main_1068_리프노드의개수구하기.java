package doit.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1068_리프노드의개수구하기 {
    static ArrayList<Integer>[] adj;
    static int N, deleteNode, rootNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1) {
                rootNode = i;
                continue;
            }
            adj[a].add(i);
        }

        deleteNode = Integer.parseInt(br.readLine());
        if(deleteNode == rootNode) {
            System.out.println(0);
        } else {
            System.out.println(BFS(rootNode));
        }

    }

    public static int BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int answer = 0; // 리프 노드의 개수
        while(!q.isEmpty()){
            int now = q.poll();
            int child = 0;
            for(int i : adj[now]){
                if(i == deleteNode) continue; // child가 제거할 노드임을 검사, 위치가 중요함(반례해결:루프노드가 리프노드가 될 수 있음)
                child++;
                q.add(i);
            }
            if(child == 0) answer++;
        }

        return answer;
    }
}
