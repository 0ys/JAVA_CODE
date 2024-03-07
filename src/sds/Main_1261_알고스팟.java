package sds;

import java.util.*;
import java.io.*;

public class Main_1261_알고스팟 {
    static int N, M;
    static int[][] maze;

    static class Point implements Comparable<Point> {
        int x, y, cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt; // 벽을 부순 개수
        }
        @Override
        public int compareTo(Point arg0) {
            return this.cnt - arg0.cnt;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        //InputStream fileInput = new FileInputStream("input.txt");
        //System.setIn(fileInput);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                maze[i][j] = Character.getNumericValue(s.charAt(j - 1));
            }
        }

//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<=M; j++) {
//				System.out.print(maze[i][j] +" ");
//			}
//			System.out.println();
//		}

        int ans = BFS(1, 1);
        System.out.println(ans);
    }

    static int BFS(int x, int y) {
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.add(new Point(x, y, 0));
        boolean[][] visit = new boolean[N+1][M+1];
        visit[x][y] = true;

        int nextX, nextY;
        while(!que.isEmpty()) {
            Point p = que.poll();

            if(p.x == N && p.y == M) {
                return p.cnt;
            }

            for(int i=0; i<4; i++) {
                nextX = p.x + dx[i];
                nextY = p.y + dy[i];

                if(nextX<1 || nextY<1 || nextX>N || nextY>M) {
                    continue;
                }

                if(!visit[nextX][nextY] && maze[nextX][nextY] == 0) {
                    visit[nextX][nextY] = true;
                    que.add(new Point(nextX, nextY, p.cnt));
                }

                if(!visit[nextX][nextY] && maze[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    que.add(new Point(nextX, nextY, p.cnt+1));
                }
            }
        }

        return 0;

    }
}
