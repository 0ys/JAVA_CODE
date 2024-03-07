package doit.datastructure;

import java.util.*;

public class Main_2018_연속된자연수의합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        while(end != N){
            if(sum == N) {
                count++;
                end++;
                sum += end;
            } else if(sum < N){
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
