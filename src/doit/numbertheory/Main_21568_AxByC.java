package doit.numbertheory;

import java.util.Scanner;

public class Main_21568_AxByC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int gcd = gcd(A, B);
        if(C % gcd != 0) System.out.println(-1);
        else {
            int mok = C /gcd;
            long[] ret = Excute(A, B);
            System.out.println(ret[0]*mok + " " + ret[1]*mok);
        }
    }

    public static long[] Excute(long a, long b){ // 유클리드 호제법
        long[] ret = new long[2];
        if(b==0) {
            ret[0] = 1; ret[1] = 0; // x=1, y=0으로 설정하고 리턴하기
            return ret;
        }

        long q = a/b;
        long[] v = Excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 올라오면서 x, y값을 계산하는 로직
        ret[1] = v[0]-v[1]*q;
        return ret;
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
