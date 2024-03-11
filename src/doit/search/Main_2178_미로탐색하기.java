package doit.search;

import java.util.*;
import java.io.*;

public class Main_2178_미로탐색하기 {
    static int[][] maze;
    static boolean[][] visited;
    // (1,0), (0,1), (-1,0), (0,-1)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        maze = new int[N][M];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = input.charAt(j)-'0';
            }
        }

        BFS(new Node(0, 0));
        System.out.println(maze[N-1][M-1]);
    }

    static void BFS(Node node){
        Queue<Node> que = new ArrayDeque<>();
        visited[node.x][node.y] = true;
        que.add(node);

        while(!que.isEmpty()){
            Node now = que.poll();
            for(int i=0; i<4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(maze[x][y] == 0 || visited[x][y]) continue;
                    visited[x][y] = true;
                    maze[x][y] = maze[now.x][now.y] + 1;
                    que.add(new Node(x, y));
                }
            }
        }
    }
}
