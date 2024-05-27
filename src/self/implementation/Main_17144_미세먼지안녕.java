package self.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
    static int[][] maps;
    static int[][] offset;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int R, C, T;
    static ArrayList<Integer> air = new ArrayList<>();
    static int up, down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        maps = new int[R][C];
        offset = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
                maps[i][j] = a;
                if(a == -1){
                    air.add(i);
                }
            }
        }
        up = air.get(0);
        down = air.get(1);
        //System.out.println("up="+up+" down="+down);

        for(int t = 0; t < T; t++) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(maps[i][j] != 0 && maps[i][j] != -1) {
                        Spread(i, j);
                    }
                }
            }
            AddOffset();
            //System.out.println("Spread");
            //printMaps();

            Circular();
            //System.out.println("Circular");
            //printMaps();
        }

        System.out.println(cntAnswer());
    }

    static void Circular() {
        int[][] temp = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                temp[i][j] = maps[i][j];
            }
        }

        for(int i = 1; i < R; i++) { // 위에서 아래
            if(i < up) maps[i][0] = temp[i-1][0];
            if(i > down) maps[i][C-1] = temp[i-1][C-1];
        }

        for(int j = 2; j < C; j++) { // 왼쪽에서 오른쪽
             maps[up][j] = temp[up][j-1];
             maps[down][j] = temp[down][j-1];
        }
        maps[up][1] = 0;
        maps[down][1] = 0;

        for(int i = R-2; i >= 0; i--) { // 아래에서 위
            if(i > down) maps[i][0] = temp[i+1][0];
            if(i < up) maps[i][C-1] = temp[i+1][C-1];
        }

        for(int j = C-2; j >= 0; j--) { // 오른쪽에서 왼쪽
            maps[0][j] = temp[0][j+1];
            maps[R-1][j] = temp[R-1][j+1];
        }
    }

    static void Spread(int x, int y){
        int a = maps[x][y] / 5;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && maps[nx][ny] != -1){
                offset[nx][ny] += a;
                offset[x][y] -= a;
            }
        }
    }

    static void AddOffset() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                maps[i][j] += offset[i][j];
            }
        }
        // offset 초기화
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                offset[i][j] = 0;
            }
        }
    }

    static int cntAnswer() {
        int answer = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(maps[i][j] != -1) answer += maps[i][j];
            }
        }

        return answer;
    }

    static void printMaps() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
