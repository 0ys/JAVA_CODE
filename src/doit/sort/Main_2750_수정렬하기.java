package doit.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++){ // 모든 인접 데이터를 비교하여 swap
            for(int j=0; j<n-1-i; j++){ // 정렬된 영역을 제외 n-1-i
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //Arrays.sort(arr);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }
}
