package doit.search;

import java.util.Scanner;

public class Main_2023_신기한소수찾기 {
    // 재귀함수에 자릿수 개념을 붙여 구현함
    static  int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu){
        if(jarisu==N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }

        for(int i=1; i<10; i++){
            if(i%2 != 0 && isPrime(number*10 + i)){
                DFS(number*10+i, jarisu+1);
            }
        }
    }

    static boolean isPrime(int num){
        for(int i=2; i<=num/2; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
