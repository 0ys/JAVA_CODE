package doit.sort;

import java.util.Scanner;

public class Main_11399_ATM인출시간계산하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i=1; i<N; i++){
            int index = i;
            int insertValue = A[i];
            for(int j=i-1; j>=0; j--){
                if(A[j] < insertValue){
                    index = j+1;
                    break;
                }
                if(j == 0){
                    index = 0;
                }
            }
            for(int j=i; j>index; j--){
                A[j] = A[j-1]; // 뒤로 한칸씩 이동
            }
            A[index] = insertValue;
        }

        int[] S = new int[N]; // 합배열
        S[0] = A[0];
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + A[i];
        }

        int sum = 0;
        for(int num : S){
            sum += num;
        }
        System.out.println(sum);
    }
}
