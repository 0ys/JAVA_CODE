package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110_solved_ac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int remove = (int) Math.round(n * 0.15);
        //System.out.println(remove);

        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);

        int sum = 0;
        for(int i = remove; i < n-remove; i++){
            sum += score[i];
        }
        //System.out.println("sum = " + sum);

        double remain = n - 2 * remove;
        //System.out.println("remain = " + remain);
        double result = sum / remain;
        //System.out.println("result = " + result);
        System.out.println(Math.round(result));
    }
}
