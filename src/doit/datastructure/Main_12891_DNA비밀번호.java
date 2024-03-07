package doit.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12891_DNA비밀번호 {
    static int S, P;
    static int answer = 0;
    static char[] dna;
    static int[] ACGT, countACGT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dna = new char[S];
        dna = br.readLine().toCharArray();

        ACGT = new int[4];
        countACGT = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<P; i++){
            ADD(dna[i]);
        }

        if(checkSecret()) answer++;

        for(int i=P; i<S; i++){
            ADD(dna[i]);
            REMOVE(dna[i-P]);
            if(checkSecret()) answer++;
        }

        System.out.println(answer);
        br.close();

    }
    static boolean checkSecret(){
        boolean checked = true;
        for(int i=0; i<4; i++){
            if(ACGT[i]>countACGT[i]){
                checked = false;
                break;
            }
        }
        return checked;
    }

    static void ADD(char c){
        switch (c){
            case 'A':
                countACGT[0]++;
                break;
            case 'C':
                countACGT[1]++;
                break;
            case 'G':
                countACGT[2]++;
                break;
            case 'T':
                countACGT[3]++;
                break;
        }
    }

    static void REMOVE(char c){
        switch (c){
            case 'A':
                countACGT[0]--;
                break;
            case 'C':
                countACGT[1]--;
                break;
            case 'G':
                countACGT[2]--;
                break;
            case 'T':
                countACGT[3]--;
                break;
        }
    }
}
