package self.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19236_청소년상어 {
    static int[][] maps = new int[4][4];
    static class Fish {
        int x, y, direction;
        public Fish(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
    static int result = 0;
    static TreeMap<Integer, Fish> fishMap = new TreeMap<>();
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                maps[i][j] = a;
                fishMap.put(a, new Fish(i, j, b));
            }
        }

        moveShark(fishMap.get(maps[0][0]), maps[0][0]);

        System.out.println(result);

    }
    static void moveShark(Fish fish, int eat) {
        result = Math.max(result, eat);

        // Map 복사
        int[][] tempMaps = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(maps[i], 0, tempMaps[i], 0, 4);
        }

        // Fish 정보 복사
        TreeMap<Integer, Fish> tempFishMap = new TreeMap<>();
        tempFishMap.putAll(fishMap);

        moveFish();

        for(int i = 1; i < 4; i++) { // 1칸, 2칸, 3칸까지 최대로 이동 가능
            int nx = fish.x + dx[fish.direction]*i;
            int ny = fish.y + dy[fish.direction]*i;

            if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && maps[nx][ny] != 0) {
                int fishNum = maps[nx][ny];
                Fish nextFish = fishMap.get(fishNum);
                maps[fish.x][fish.y] = 0;
                maps[nx][ny] = -1;
                fishMap.remove(fishNum);

                moveShark(nextFish, eat+fishNum);

                // 물고기 상태, 상어 위치 원래대로 되돌리기
                fishMap.put(fishNum, nextFish);
                maps[fish.x][fish.y] = -1;
                maps[nx][ny] = fishNum;
            }
        }

        // 맵 상태, 물고기 정보 되돌리기
        for(int i = 0; i < 4; i++) {
            System.arraycopy(tempMaps[i], 0, maps[i], 0, 4);
        }
        fishMap.putAll(tempFishMap);


    }
    static void moveFish() {
        for(Map.Entry entry : fishMap.entrySet()) {
            int nowFish = (Integer) entry.getKey();
            Fish fish = (Fish) entry.getValue();
            int d = getDirection(fish.x, fish.y, fish.direction);
            if(d == -1) continue;

            int nx = fish.x + dx[d];
            int ny = fish.y + dy[d];

            int nextFish = maps[nx][ny];
            maps[fish.x][fish.y] = nextFish;
            maps[nx][ny] = nowFish;
            fishMap.put(nowFish, new Fish(nx, ny, d));
            if(nextFish != 0) fishMap.put(nextFish, new Fish(fish.x, fish.y, fishMap.get(nextFish).direction));
        }
    }
    static int getDirection(int x, int y, int direction) {
        int d = direction;
        for(int i = 0; i < 8; i++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && maps[nx][ny] != -1){
                return d;
            } else {
                if(d == 8) d = 0;
                d++;
            }
        }
        return -1;
    }
    static void printMap() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //System.out.print(maps[i][j] + " " + fishMap.getOrDefault(maps[i][j], new Fish(0, 0, 0)).direction + " ");
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}
