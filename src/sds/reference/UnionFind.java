package sds.reference;

public class UnionFind {
    static int[] parent;
    static int N = 4;
    public static void main(String[] args) {

        // initialize : parent 배열에 i 원소에 대한 부모 노드 번호를 저장, 루트 노드인 경우 자기 자신의 번호를 저장
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
    }

    // Union 연산 : 하나의 루트 노드를 다른 하나의 루트 노드의 자식 노드로 넣어 두 트리를 합친다.
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
        // parent[aRoot] = bRoot; // 합집합이기 때문에 방향은 상관없음!
    }

    // Find 연산 : 주어진 원소의 루트 노드 번호를 반환한다.
    static int find(int a){
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 새로운 parent 값을 저장함으로써 다음 턴에 더 빠르게 탐색가능
    }
}
