package doit.search;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1920_원하는정수찾기 {
    static int[] A;
    static int N;
    static boolean find;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i=0; i<M; i++){
            int t = sc.nextInt();
            System.out.println(binarySearch(t)? 1 : 0);
        }

    }

    static boolean binarySearch(int target){
        boolean find = false;
        int start = 0;
        int end = A.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            int value = A[mid];
            if(value==target){
                find = true;
                break;
            } else if(value>target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return find;
    }
}
