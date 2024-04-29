package doit.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1043_거짓말쟁이가되긴싫어 {
    static int N, M;
    static int[] truth;
    static int[] parents;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int tr = sc.nextInt();
        truth = new int[tr];
        for(int i = 0; i < tr; i++){
            truth[i] = sc.nextInt();
        }

        parents = new int[N+1];
        for(int i = 1; i < N+1; i++){
            parents[i] = i;
        }

        party = new ArrayList[M];
        for(int i = 0; i < M; i++){
            int partySize = sc.nextInt();
            party[i] = new ArrayList<>();
            for(int j = 0; j < partySize; j++){
                party[i].add(sc.nextInt());
            }
        }

        for(int i = 0; i < M; i++){
            int partySize = party[i].size();
            int firstPeople = party[i].get(0);
            for(int j = 0; j < partySize; j++){
                Union(firstPeople, party[i].get(j));
            }
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            boolean isPossible = true;
            int now = party[i].get(0);
            for(int j = 0; j < tr; j++){
                if(Find(now) == Find(truth[j])){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }

        System.out.println(result);
    }

    public static void Union(int a, int b){
        int aRoot = Find(a);
        int bRoot = Find(b);
        parents[bRoot] = aRoot;
    }

    public static int Find(int x){
        if(parents[x] == x) return x;
        return parents[x] = Find(parents[x]);
    }
}
