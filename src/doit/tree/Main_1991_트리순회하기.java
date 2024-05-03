package doit.tree;

import java.util.Scanner;

public class Main_1991_트리순회하기 {
    static int[][] tree;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];
        for(int i = 1; i <= N; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = input[0].charAt(0) - 'A';

            char left = input[1].charAt(0);
            if(left == '.') tree[a][0] = -1;
            else tree[a][0] = left - 'A';

            char right = input[2].charAt(0);
            if(right == '.') tree[a][1] = -1;
            else tree[a][1] = right - 'A';
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    public static void preorder(int now) {
        if(now == -1) return;
        System.out.print((char)(now +'A'));
        preorder(tree[now][0]);
        preorder(tree[now][1]);
    }

    public static void inorder(int now) {
        if(now == -1) return;
        inorder(tree[now][0]);
        System.out.print((char)(now +'A'));
        inorder(tree[now][1]);
    }

    public static void postorder(int now) {
        if(now == -1) return;
        postorder(tree[now][0]);
        postorder(tree[now][1]);
        System.out.print((char)(now +'A'));
    }
}
