package doit.geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Main_17387_선분의교차여부구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //A
        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        //B
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        //C
        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());
        //D
        long x4 = Integer.parseInt(st.nextToken());
        long y4 = Integer.parseInt(st.nextToken());

        int ABC = CCW(x1, y1, x2, y2, x3, y3);
        int ABD = CCW(x1, y1, x2, y2, x4, y4);
        int CDA = CCW(x3, y3, x4, y4, x1, y1);
        int CDB = CCW(x3, y3, x4, y4, x2, y2);

        if(ABC * ABD == 0 && CDA * CDB == 0) // 선분이 일직선일 때
            isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        else if (ABC * ABD <= 0 && CDA * CDB <= 0)
            System.out.println(1);
        else System.out.println(0);
    }

    public static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long ccw = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3); // -백만 ~ 백만 범위의 정수로 계산하기 때문에 오버플로우 발생 -> long형으로 선언
        if(ccw > 0) return 1;
        else if(ccw < 0) return -1;
        else return 0;
    }

    public static void isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
        &&  Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3,y4) <= Math.max(y1, y2)){
            System.out.println(1);
        }
        else System.out.println(0);
    }
}
