package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maps;
    static boolean[][] visited;
    static int N, M;
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        visited = new boolean[N][M];
        boolean all = true;
        Queue<Pair> tomato = new LinkedList<>();
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 0) all = false;
                else if(a == 1) {
                    tomato.add(new Pair(i, j));
                    visited[i][j] = true;
                }
                maps[i][j] = a;
            }
        }

        while (!tomato.isEmpty()) {
            Pair cur = tomato.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(maps[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[cur.x][cur.y] + 1;
                    tomato.add(new Pair(nx, ny));
                    //printMap();
                }
            }
        }

        boolean flag = false;
        int day = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maps[i][j] == 0 && !visited[i][j]) flag = true;
                day = Math.max(day, maps[i][j]);
            }
        }

        if(all) System.out.println(0);
        else if(flag) System.out.println(-1);
        else System.out.println(day-1);

    }
    static void printMap() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
