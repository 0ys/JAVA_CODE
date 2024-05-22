package codingtest;

import java.util.*;
import java.io.*;

// SSAFY 2024 2
/*
N명 사람은 원하는 크기의 모자가 있고, N개의 모자의 사이즈가 주어진다.
원하는 크기와 모자 사이즈의 차이가 3이하일 때 해당 모자를 쓸 수 있다.
최대 몇 명의 사람이 모자를 쓸 수 있는가?
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] want = new int[N]; // 사람들이 원하는 모자의 크기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                want[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(want);

            int[] hat = new int[N]; // 주어지는 모자의 사이즈
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                hat[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(hat);

            int cnt = 0;
            int usedHat = 0;
            for(int i=0; i<N; i++) {
                if(usedHat == N) break;
                int hatPointer = usedHat;
                while(hatPointer<N) {
                    if(Math.abs(want[i] - hat[hatPointer]) <= 3) {
                        cnt++;
                        usedHat = hatPointer+1;
                        break;
                    }
                    else hatPointer++;
                }
            }

            bw.write("#"+tc+" "+cnt+"\n");

        }

        bw.flush();
        bw.close();
    }
}
