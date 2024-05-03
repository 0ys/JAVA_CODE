package doit.tree;

import java.util.Scanner;

public class Main_14425_문자열찾기 {
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();

        // 트라이 자료구조 생성
        for (int i = 0; i < n; i++) {
            String text = sc.next();
            tNode now = root;
            for(int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                // 26개 알파벳의 위치를 배열 index로 나타내기 위해 (c - 'a')를 수행함
                if(now.next[c - 'a'] == null) { // 현재 문자가 공백상태라면 노드를 추가해줌
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a']; // 다음 문자로 이동
                if(j == text.length() - 1) {
                    now.isEnd = true; // 리프 노드를 표시
                }
            }
        }

        // 트라이 자료구조 검색
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            String text = sc.next();
            tNode now = root;
            for(int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                if(now.next[c - 'a'] == null) { // 공백 노드라면 검색 중단
                    break;
                }
                now = now.next[c - 'a'];
                if(j == text.length() - 1 && now.isEnd) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
