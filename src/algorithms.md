# 알고리즘
## 알고리즘 정리
|   구분    | 알고리즘              | 시간복잡도    | 구현 유형         | 사용 기법          |
|:---------:|:------------------|----------|---------------|----------------|
| 완전 탐색 | DFS               | N^2      | List, 배열      | stack, 재귀      |
|           | BFS               | N^2      | List, 배열      | Queue          |
|           | 백트래킹              |          | List, 배열      |                |
|  최적화   | 분할정복              | NlogN    | 배열            |                |
|           | 동적계획법 DP          | N        | 배열            | 메모제이션, <br>점화식 |
|           | 슬라이딩 윈도우          | N        | 배열, Deque     |                |
|           | Greedy            |          | List, 배열      |                |
| 자료구조  | 우선순위큐             | NlogN    | List          |                |
|           | Union Find        | N        | List, 배열      |                |
|           | 이진탐색              | logN     | 배열            |                |
|           | lower/upper bound | logN     | 배열            |                |
|   수학    | 유클리드 호제법          |          |               |                |
|           | 확장 유클리드 호제법       |          |               |                |
|           | 에라토스테네스의 체        |          |               |                |
|           | 파스칼의 삼각형          |          |               |                |


|       구분        | 알고리즘                    | 확장 알고리즘                      | 시간복잡도 | 구현유형   | 사용기법              | 간선방향        |
|:---------------:|-------------------------| ---------------------------------- | ---------- | ---------- | --------------------- | --------------- |
|       트리        | LCA<br>(공통조상찾기)         |                                    | NlogN      | List       |                       |                 |
|                 | 인덱스트리<br>(Segment Tree) | 펙웍트리(BIT)<br>Lazy Propagation  | NlogN      | 배열       | 이진탐색              |                 |
|  그래프 <br>최단경로   | 다익스트라                   |                                    | ElogV      | List, 배열 | 우선순위큐            | 방향,<br>무방향 |
|                 | 벨만포드                    |                                    | VE         | List, 배열 | 완전탐색<br>음수가능  | 방향,<br>무방향 |
|                 | 플로이드-워셜                 |                                    | V^3        | 배열       | 완전탐색<br>음수가능  | 방향,<br>무방향 |
| 최소신장<br>트리(MST) | 크루스칼 Kruscal            |                                    | ElogV      | List, 배열 | 탐욕법,<br>UnionFind  | 무방향          |
|                 | 프림 Prim                 |                                    | V^2        | List, 배열 | 탐욕법,<br>우선순위큐 | 무방향          |
|       그래프       | 위상정렬                    |                                    | V+E        | List, 배열 | DAG                   | 방향            |
|                 | 단절점, 단절선                | 강한 연결 요소<br>- 타잔, 코사라주 | V+E        | List, 배열 |                       | 무방향          |


## 알고리즘 문제풀이 기초
- 히든케이스(Edge 검사) : 기본 테스트케이스 외에도 끝 값이나 시작 값으로 검사해보기
- 모든 테스트 케이스를 통과했는데도 틀린다면, 자료형을 고려!(int를 long으로)
- 20억이 넘어가면 자료형 long을 사용하자.
- 
- 1억 연산은 1초를 의미한다. 즉, 만*만이 넘어가면 틀린거임
- 자바는 실수를 double을 기본으로 사용한다.
- int 배열은 1억건 이상 넘어가면 힘들다.
- `연산 횟수 = 알고리즘 시간 복잡도 * 데이터의 크기`
- 예를 들어, 시간제한이 2초(2억번 연산)일 때, 데이터가 1,000,000이라면 N*N은 사용할 수 없다.
- 
- 100,000 이상의 데이터를 처리할 때 N*N 알고리즘은 어렵다.
- 1,000,000인 데이터를 처리할 때는 NlogN 알고리즘을 사용
- 5,000,000인 데이터일 경우, NlogN 알고리즘 사용 불가(단순 정렬은 가능)하므로 O(n) 알고리즘을 사용해야함

### 시간복잡도 문제 해결
1. 알맞은 알고리즘을 선택
   - 데이터와 시간 제한을 보고 그에 맞는 알고리즘을 선택해야 함
2. 내 코드를 살펴보기
   - 알고리즘이 맞았는데 시간초과가 나는 경우, 내 코드에 비효율적인 부분이 없는지 살펴봐야 함

#### 예시 : 제한시간이 1초일때
- N<=10 : N!, 2^N, 3^N
- N<=20 : 2^N
- N<=100 : N^4
- N<=500 : N^3
- N<=1,000 : N^2, N^2logN
- N<=100,000 : N, NlogN, logN, O(1)

# 정렬
## 정렬의 응용
1. 유일성 검사/ 중복 제거
   - Set도 같은 역할을 함 = treeSet(정렬이 되는 Set)
2. 빈도 구하기(logN)
   - lower bound ~ upper bound
3. 합집합/교집합 구하기
   - 2 pointers 알고리즘을 이용
4. 이분 탐색(log N) = priority queue
   1. Array.binarySearch를 사용
   2. N이 10만대이면 NlogN 알고리즘을 사용

## 라이브러리를 이용한 정렬
보통 퀵 정렬로 구현되어 있다. 시간 복잡도는 O(NlogN)이며 최악의 경우 O(N^2)이다.
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 1. 기본 Arrays Sort
        int[] A = new int[N];
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        // 2. Collections Sort
        ArrayList<Integer> A = new ArrayList<>();
        Collections.sort(A);
    }
}
```

## 병합 정렬 (=분할 정복 Divide and Conquer) O(NlogN)
분할 정복 방식을 사용해 데이터를 분할하고, 분할한 집합을 정렬하며 합친다.
코딩 테스트의 정렬 관련 문제에서 자주 등장하며, 특히 2개의 그룹을 병합하는 원리는 알아야 한다.
#### 2개의 그룹을 병합하는 과정
- 투 포인터 개념을 사용하여 왼쪽, 오른쪽 그룹을 병합한다.
- 왼쪽 포인터와 오른쪽 포인터의 값을 비교하여 작은 값을 결과 배열에 추가하고 포인터를 오른쪽으로 1칸 이동한다.
```java
public class Main {
    static void mergeSort(int s, int e) {
        if(e-s < 1) return; // 배열 한칸까지 재귀함수로 나누기
        int m = s + (e-s)/2;
        // 재귀 함수 : Divide
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i=s; i<=e; i++){
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m+1;
        // 두 그룹을 병합하는 로직 : Conquer
        // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 배열에 저장하고,
        // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
        while(index1<=m && index2<=e){
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while(index1<=m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2<=e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
```
---
# 탐색
## 백트래킹

## 2 Pointers O(N)

## 슬라이딩 윈도우 O(N)

## Lower & Upper Bound O(logN)

## 깊이 우선 탐색 DFS O(V+E)
그래프 완전 탐색 기법 중 하나이다.
깊이 우선 탐색은 그래프의 시작 노드부터 시작하여 탐색 분기의 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행한다.
시간 복잡도는 O(V+E)로 V는 노드의 개수, E는 엣지의 개수를 의미한다.
DFS는 재귀함수 또는 스택 자료구조로 구현한다. 즉 DFS는 재귀 함수 그 자체로 생각할 수 있다.
#### 응용 문제
- 백트래킹
- 위상 정렬
- 단절선 찾기
- 단절점 찾기
- 사이클 찾기

```java
public class Main {
   static ArrayList<Integer>[] adj; // 그래프 인접리스트
   static boolean[] visited;
   
   static void DFS(int v){
      if(visited[v]) return;
      visited[v] = true;

      for(int i : adj[v]){
         if(!visited[i]){
            DFS(i);
         }
      }
   }
}
```

## 너비 우선 탐색 BFS O(V+E)
그래프 간선의 가중치가 모두 동일할 때, BFS로 탐색한다.
너비 우선 탐색은 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
선입선출 방식으로 탐색하므로 큐를 이용해 구현하는데, 주로 ArrayDeque를 사용한다. 
또한 BFS는 탐색 시작 노드와 가까운 노드를 우선하여 탐색하므로 목표 노드에 도착하는 경로가 여러 개일 때, 최단 경로를 보장한다. 
시간 복잡도는 O(V+E)로 DFS와 같다.
#### 응용 문제
- 최단 경로 찾기
- 위상 정렬

```java
public class Main {
   static ArrayList<Integer>[] adj; // 그래프 인접리스트
   static boolean[] visited;
   
   static void BFS(int v){
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(v);
      visited[v] = true;

      while(!queue.isEmpty()){
         int now = queue.poll();
         for(int i : adj[now]){
            if(!visited[i]){
               visited[i] = true;
               queue.add(i);
            }
         }
      }
   }
}
```

## 이진 탐색 O(logN)
데이터가 정렬돼 있는 상태에서 대상 데이터의 중앙값과 찾고자 하는 값을 비교해
데이터의 크기를 절반씩 줄이면서 대상을 찾는다.
이진 탐색을 사용하면 N개의 데이터에서 logN 번의 연산으로 원하는 데이터의 위치를 찾을 수 있다.
다만 이진 탐색은 데이터가 정렬되어 있어야 한다.
```java
public class Main {
   static boolean binarySearch(int target){
      boolean find = false;
      int start = 0;
      int end = A.length-1; // 배열의 마지막 인덱스
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
```

## 우선순위 큐 Priority Queue : O(NlogN)
우선순위 큐는 값이 들어간 순서와 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조이다.
큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치한다.
일반적으로 힙을 이용해 구현하며, Comparable 또는 Comparator를 이용하여 우선순위를 설정한다.
```java
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 오름차순
            // 반환 값이 음수인지 양수인지에 따라 우선순위가 결정됨
            // 내 것과 새로 들어온 객체를 계산해서 0, 음수면 그대로, 양수면 바꿔라
        }
    }

    public static void main(String[] args) {
        // 1. 기본 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        // 2. Comparable 를 활용한 우선순위 설정
        PriorityQueue<Node> que = new PriorityQueue<>();

        // 3. 새로운 우선순위 설정 : 절댓값에 따라 순위결정하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) return o1 > o2 ? 1 : -1; // 절댓값이 같으면 더 작은 수를 먼저(오름차순)
            else return first_abs - second_abs;
        });
        
        // 4. Comparator 클래스를 활용한 우선순위 설정
        PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>(){
           @Override
           public int compare(Jewel o1, Jewel o2) {
              return Integer.compare(o2.v, o1.v); // 내림차순
              // <. =. > 순으로 true 일 경우 -1, 0, 1을 반환
           }
        });

        pq.add(1);
        pq.poll();
    }
}
```

---
# 정수론
## 에라토스테네스의 체
코딩테스트에서 소수를 구하는 가장 일반적인 방법이다.
1. 구하고자 하는 소수 범위만큼 1차원 배열을 생성한다.
2. 소수를 찾으면 해당하는 소수의 배수들을 모두 지워줌으로써 지워지지 않은 숫자를 찾는다.
```java
public class Main_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] prime = new int[N+1]; // 1차원 배열 생성 후 초기화
        for(int i=2; i<=N; i++){
            prime[i] = i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){ // 제곱근까지만 탐색
            if(prime[i] == 0) continue;
            for(int j=i+i; j<=N; j += i){ // 배수 지우기
                prime[j] = 0;
            }
        }

        for(int i=M; i<=N; i++){ // M 이상 N 이하의 소수 출력
            if(prime[i] != 0) System.out.println(prime[i]);
        }
    }
}
```
이중 for문을 사용하지만 실제 시간 복잡도는 최적화의 정도에 따라 다르겠지만, 일반적으로 `O(Nlog(logN))`이다.
그 이유는 배수를 삭제하는 연산으로 실제 구현에서 바깥쪽 for문을 생략하는 경우가 빈번하게 발생하기 때문이다.

## 팰린드롬 수
79,179와 324,423 처럼 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라고 부른다.
숫자를 char 배열 형태로 변환한 후 양끝의 투 포인터를 비교하면 쉽게 판별할 수 있다.
```java
public class Main {
   private static boolean isPalindrome(int target){
      char[] temp = String.valueOf(target).toCharArray();
      int s = 0;
      int e = temp.length -1;
      while(s<e){
         if(temp[s] != temp[e]) {
            return false;
         }
         s++;
         e--;
      }
      return true;
   }
}
```

## 오일러 피
[정의] : 자연수 n이 주어졌을 때, gcd(n,k)=1 (1<=k<=n)를 만족하는 자연수의 개수\
오일러 피 함수 P[N]의 정의는 1부터 N까지 범위에서 N과 서로소인 자연수의 개수를 뜻한다.\
예) P[6] = 1~6 범위에서 6과 서로소인 자연수의 개수 = (1, 5)로 2개이다.
1. 구하고자 하는 오일러 피의 범위만큼 배열을 자기 자신의 인덱스값으로 초기화한다.
2. 2부터 시작해 현재 배열의 값과 인덱스가 같으면(=소수일 때) 현재 선택된 숫자(K)의 배수에 해당하는 수를
   끝까지 탐색하며 `P[i] = P[i] - P[i]/K` 연산을 수행한다. (i는 K의 배수)
```java
public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();

      int[] P = new int[N+1];
      for(int i=0; i<=N; i++){
         P[i] = i;
      }

      for(int K=2; K<=N; K++){
         if(P[K] == K){
            for(int i=K; i<=N; i += K){
               P[i] = P[i] - P[i]/K;
            }
         }
      }

      for(int p : P){
         System.out.print(p+" ");
      }
   }
}
```


## 유클리드 호제법
두 수의 최대공약수(GCD)를 구하는 알고리즘이다.\
2개의 자연수 a, b에 대해 a를 b로 나눈 나머지를 r이라 하면 (단, a > b), 
a와 b의 최대공약수는 b와 r의 최대공약수와 같다는 성질을 이용한다.\
즉, `gcd(a, b) = gcd(b, a%b) (단, a>=b)`이다.
1. 큰 수를 작은 수로 나누는 MOD 연산을 수행한다.
2. 앞 단계에서의 작은 수와 MOD 연산 결괏값(나머지)으로 다시 MOD 연산을 수행한다. (재귀)
3. 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택한다.
```java
static int gcd(int a, int b){
    if(b==0) return a; // 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택함
    return gcd(b, a%b); // 앞 단계의 작은 수(b)와 큰 수에서 작은 수 MOD 연산(a%b)로 다시 MOD 연산 수행
}
```
#### 최소 공배수: `A*B/gcd(A, B)`
#### 세 개 이상의 정수의 최대 공약수를 구하는 방법
유클리드 호제법을 재귀적으로 사용한다. 
`gcd(A, B, C) = gcd(gcd(A, B), C)`를 이용한다.


## 확장 유클리드 호제법 (베주 항등식 Bezout's identity)
유클리드 호제법이 최대 공약수를 구하는 것이라면, 확장 유클리드 호제법은 방정식의 해 x, y를 구한다.
- 해를 구하고자 하는 방정식 : `ax + by = c (a, b, c, x, y, 는 정수)`

위 방정식은 `c % gcd(a,b) = 0`인 경우에만 정수해를 가진다. 만약 c가 gcd(a,b)의 배수가 아니라면 해당 방정식을 만족하는 x, y값은 정수 범위에서 존재하지 않는다.\
다시 말해 ax + by = c가 정수해를 갖게 하는 c의 최솟값이 gcd(a,b)라는 것을 의미한다. 이 때 x, y 중 한개는 보통 음수가 된다.\
특히 a, b가 서로소(gcd(a,b)=1)인 경우 유용하다. 이 경우, ax + by = 1이 되고, 여기서 x는 MOD 연산의 곱의 역원이 되기 때문이다. 
#### 5x+9y=2일 때 이 식을 만족하는 정수 x, y를 구해보자.
1. 해당 식이 정수해를 갖게 하는 c의 최솟값이 gcd(5,9)=1이므로 5x+9y=1로 식을 놓고 mok=2를 저장한다.
2. a, b로 유클리드 호제법을 반복하면서 몫, 나머지를 저장한다. 나머지가 0이 되면 반복을 중단한다.
3. 반복으로 구한 나머지와 몫을 이용하여 거꾸로 올라가며 x=y', y=x'-y'*q를 계산한다.
이때 x'는 이전 x, y'는 이전 y를 의미하고, q는 현재 보고 있는 몫을 의미한다.
4. 이렇게 재귀 방식으로 알아낸 최종 x, y는 ax+by=gcd(a,b)를 만족하므로 mok를 곱해서 최종 Kx, Ky를 간단히 구할 수 있다.
```java
public class Main_21568_AxByC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int gcd = gcd(A, B);
        if(C % gcd != 0) System.out.println(-1);
        else {
            int mok = C /gcd;
            long[] ret = Excute(A, B);
            System.out.println(ret[0]*mok + " " + ret[1]*mok);
        }
    }

    public static long[] Excute(long a, long b){ // 유클리드 호제법
        long[] ret = new long[2];
        if(b==0) {
            ret[0] = 1; ret[1] = 0; // x=1, y=0으로 설정하고 리턴하기
            return ret;
        }

        long q = a/b;
        long[] v = Excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 올라오면서 x, y값을 계산하는 로직
        ret[1] = v[0]-v[1]*q;
        return ret;
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
```

---
# 그래프
## 그래프의 표현
#### 에지 리스트
에지를 중심으로 그래프를 표현한다. 배열에 출발 노드와 도착 노드를 저장하면 에지를 표현할 수 있다.\
노드가 N개일 때, 가중치가 없는 그래프의 경우 `A[N][2]`(S, E)로 표현할 수 있고, 가중치가 있을 경우 `A[N][3]`(S, E, V)으로 표현할 수 있다.\
에지 리스트는 구현은 쉽지만 특정 노드와 관련되어 있는 에지를 탐색하기는 어렵다. 
그래서 에지 리스트는 벨만 포드나 크루스칼 알고리즘에 사용되며, 노드 중심 알고리즘에는 사용하지 않는다.

#### 인접 행렬
노드가 N개일 때, `A[N][N]`인 2차원 배열을 자료구조로 이용하여 그래프를 표현한다. 인접 행렬은 노드 중심으로 그래프를 표현한다.\
인접 행렬을 이용한 구현 역시 쉽다. 두 노드를 연결하는 에지의 여부와 가중치 값은 배열에 직접 접근하면 바로 확인할 수 있는 것도 장점이다.\
하지만 노드와 관련되어 있는 에지를 탐색하려면 N번 접근해야 하므로 노드 개수에 비해 에지가 적을 때는 공간 효율성이 떨어진다. 
또한 노드 개수가 많으면 아예 2차원 배열을 선언할 수 없다. 특히 노드가 3만 개가 넘으면 자바 힙 스페이스 에러가 발생한다.

#### 인접 리스트
인접 리스트는 ArrayList로 그래프를 표현한다. 즉, 노드의 개수만큼 ArrayList를 선언한다.\
예를 들어 Integer형인 N개의 노드는 `ArrayList<Integer>[N]`으로 선언할 수 있다.
가중치가 있는 그래프의 경우 Node 클래스를 자료형으로 사용하여 `ArrayList<Node>[N]`으로 선언한다.\
인접 리스트 방식은 구현이 복잡하지만, 노드와 연결되어 있는 에지를 탐색하는 시간이 매우 뛰어나며, 
노드 개수가 커도 공간 효율이 좋아 메모리 초과 에러도 발생하지 않는다.

```java
import java.util.ArrayList;

public class Main {
   static ArrayList<Node>[] adj;

   static class Node {
      int to, cost;

      public Node(int to, int cost) {
         this.to = to;
         this.cost = cost;
      }
   }

   public static void main(String[] args) {
       int a = 3, b = 2, c = 4; 
       adj[a].add(new Node(b, c));
       adj[b].add(new Node(a, c)); // 양방향
   }
}
```

## 유니온파인드
그래프의 사이클이 있는지 판별하는 알고리즘이다.
일반적으로 여러 노드가 있을 때, 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과 두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성된다.\
특히 find 연산은 특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환한다.
1. 각 노드의 대표 노드를 저장하는 1차원 배열을 초기화함
2. union 연산을 수행하면서 같은 대표 노드를 가지도록 배열을 업데이트함
   1. 선택된 노드끼리 연결하는 것이 아닌, 선택된 노드의 대표 노드끼리 연결하는 것임!
3. find 연산을 수행한다.
   1. 대상 노드 배열에 index 값과 value 값이 동일한지 확인
   2. 동일하지 않으면 value 값이 가리키는 index 위치로 이동
   3. 이동 위치의 index 값과 value 값이 같을 때까지(대표노드를 찾을 때까지) 재귀
   4. 대표 노드에 도달하면 재귀 함수를 빠져나오면서 거치는 모든 노드 값을 루트 노드값으로 변경(중요!)
find 연산은 자신이 속한 집합의 대표 노드를 찾는 연산으로 그래프를 정돈하고 시간복잡도를 향상시킨다.(경로 압축의 효과)

```java
public class Main {
    static int[] parent; // 대표 노드 배열
    public static void main(String[] args){
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }

    public static void Union(int a, int b){
        int aRoot = Find(a); // 선택된 노드의 대표 노드를 찾음
        int bRoot = Find(b);
        if(aRoot != bRoot) parent[aRoot] = bRoot; // 같은 대표 노드를 가지도록 업데이트
    }

    public static int Find(int a){
        if(parent[a] == a) return a; // index와 value가 같으면 리턴
        return parent[a] = Find(parent[a]); // 재귀 함수에서 탐색한 모든 노드의 대표 노드값을 이번 연산에서 발견한 대표 노드로 업데이트(중요)
    }
}
```
#### 그래프 내 사이클을 판별 = MST에서 활용
이러한 유니온 파인드 연산으로 그래프의 사이클을 판별할 수 있다.
union 연산은 그래프에서의 간선으로 표현될 수 있다. 따라서 간선을 하나씩 확인하면서 두 노드가 포함되어 있는 집합을 합치는 과정을 반복하는 것만으로도 그래프 내 '사이클'을 판별할 수 있다.
1. 각 간선을 확인하며 두 노드의 대표 노드를 확인함
2. 만약 서로의 parent가 다르면 두 노드에 대해 union 연산을 수행함
3. 만약 parent가 같다면 사이클이 발생한 것임!
4. 그래프에 포함되어 있는 모든 간선에 대해 위의 과정을 반복함

## 위상정렬 O(V+E)
사이클이 없고 방향이 있는 그래프일 때, 그래프를 선형으로 정렬한다.
그래서 정답이 여러 개 존재할 수 있다. 예를 들어 수강 신청이나 게임 빌드 순서 등의 문제가 나온다.
진입 차수 배열을 기준으로 노드의 순서가 정렬된다.
사이클이 존재하면 노드 간의 순서를 명확하게 정의할 수 없으므로 위상 정렬을 적용할 수 없다.
- 진입 차수란? 자기 자신을 가리키는 에지의 개수
1. 인접 리스트로 표현된 그래프와 진입 차수 배열을 초기화함
2. 진입 차수가 0인 노드를 선택하고, 선택된 노드를 정렬 배열에 저장함
3. 인접 리스트에서 선택된 노드가 가리키는 노드들의 집입 차수를 1씩 뺌
4. 다음 집입 차수가 0인 노드를 찾아 반복

```java
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] D; // 진입 차수 배열
    public static void main(String[] args){
        int n, m; // input
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        D = new int[n+1];

        for (int i = 1; i <= m; i++) {
            int a, b; //input
            graph[a].add(b);
            D[b]++;
        }
        
        // 위상 정렬 수행
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(D[i] == 0){ // 진입 차수가 0인 노드를 찾아 큐에 추가
                q.add(i);
            }
        }
        
        int result = new int[n+1];
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" "); // 정렬된 노드 출력
            for(int next : graph[now]){
                D[next]--; // 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺌
                result[next] = Math.max(result[next], result[now]+next.value); // 임계 경로 값 구하기
               // 타깃 노드의 현재 경로 값과 (현재 노드의 경로 값 + 도로의 시간값) 중 큰 값으로 저장함
                if(D[next] == 0){
                    q.add(next); // 다음 선택 노드를 큐에 추가
                }
            }
        }
    }
}
```
단순한 정렬 문제 보다는, 임계 경로를 찾는 것처럼 최대 경로 값을 구하는 문제에 이용된다. 
예를 들어, 위상 정렬을 수행하면 출발 도시에서 도착 도시까지 거치는 모든 도시와 관련된 임계 경로값을 구할 수 있다. 
특히, 1분도 쉬지 않고 달려야 하는 도로의 수를 구할 때는 에지 뒤집기 아이디어를 사용하여 도착 도시에서부터 출발하는 reverseGraph를 그려서 해결할 수 있다. 
visited 배열을 사용하여 중복 카운트를 방지한다. (1516_게임개발, 1948_임계경로)

## 다익스트라 O(ElogV)
출발 노드에서 다른 모든 노드로 가는 최단 거리를 구하는 알고리즘이다.
단, 음수 간선이 존재하면 풀 수 없다.

1. 인접 리스트로 그래프 구현하고, 최단 거리 배열을 초기화함
   1. 인접 리스트에 연결한 배열의 자료형은 보통 (노드, 가중치) 형태로 선언함
   2. 최단 거리 배열은 출발 노드는 0, 이외의 노드는 무한으로 초기화함
3. 값이 가장 작은 노드를 선택하여 최단 거리 배열을 업데이트함
   1. 선택된 노드에 연결된 에지의 값을 바탕으로 다른 노드의 값을 업데이트함
   2. 최단 거리 = Min(선택 노드의 최단 거리 배열의 값 + 에지 가중치, 연결 노드의 최단 거리 배열의 값)
4. 모든 노드가 처리될 때까지 위의 과정을 반복함
   1. 재방문하지 않기 위해 visited[] 배열을 만들어 처리함

대부분 다익스트라 알고리즘이 출발 노드와 도착 노드 간의 최단 거리를 구하는 알고리즘이라고 생각하지만,
실제로 완성된 배열은 출발 노드와 이외의 모든 노드 간의 최단 거리를 표현하고 있다.

```java
public class Main {
    static public class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int V, E, S;
    static ArrayList<Node>[] adj;
    static int[] DP;
    static boolean[] visited;

    public static void main(String[] args) {
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        DP = new int[V + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        visited = new boolean[V + 1];

        for(int i=0; i<E; i++){
            int u, v, w;
            adj[u].add(new Node(v, w));
        }

        dijkstra(S);
    }

    public static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        DP[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if(nowCost > DP[now]) continue;
            if(visited[now]) continue;
            visited[now] = true;

            for(Node e : adj[now]){
                int next = e.to;
                int nextCost = DP[now] + e.cost;
                if(DP[next] > nextCost){
                    DP[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }

    }
}
```

## 벨만-포드 O(VE)
다익스트라와 똑같이 특정 출발 노드에서 다른 모든 노드로 가는 최단거리를 구한다.
벨만-포드 알고리즘은 음수 간선이 존재해도 가능하기 때문에 음수 사이클을 판별하는 문제가 많이 나온다.
예를 들어, 시간 여행이나 웜홀을 통한 워프 등 실제로 일어날 수 없는 상황들이 주어진다.
- 최단 거리를 N-1번의 에지 업데이트로 구한다. 
- 한번 더 업데이트(N번째)를 시도해서 업데이트가 발생하면, 해당 그래프는 최단 거리를 구할 수 없으며 음수 싸이클이 존재한다.

1. 에지 리스트로 그래프를 구현(`ArrayList<edge> edges;`)하고, 최단 경로 배열(`DP[index]`)을 초기화함
   1. edge 클래스는 일반적으로 출발 노드, 도착 노드와 가중치 변수로 구성됨 
   2. 최단 경로 배열은 출발 노드는 0, 나머지 노드는 무한대로 초기화함
2. 모든 에지를 확인해 N-1번 정답 배열을 업데이트함
   1. 노드의 개수가 N이고, 음수 사이클이 없을 때 특정 두 노드의 최단 거리를 구성할 수 있는 에지의 최대 개수는 N-1개임
   2. `DP[s] != 무한대`이며 `DP[e] > DP[s] + w` 일 때 `DP[e] = DP[s] + w`로 배열의 값을 업데이트함
   3. 업데이트 반복 횟수가(에지 사용 횟수)가 k번이라면 해당 시점에 정답 배열의 값은 시작점에서 k개의 에지를 사용했을 때 각 노드에 대한 최단 거리임
3. 음수 사이클이 존재하는지 확인하기 위해 한번 더 업데이트를 수행함
   1. 모든 에지를 한 번씩 다시 사용해 업데이트되는 노드가 발생하는지 확인함.
   2. 만약 업데이트되는 노드가 있다면, 음수 사이클이 존재하여 최단 거리를 구할 수 없음 

```java
public class Main_11657_타임머신으로빨리가기 {
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static int N, M;
    static long[] DP;
    static ArrayList<Edge> edges; // 에지 리스트 형태로 그래프를 저장함
    
    public static void main(String[] args) {
        DP = new long[N + 1];
        Arrays.fill(DP, Long.MAX_VALUE);
        DP[1] = 0L;
       
        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            edges.add(new Edge(from, to, cost)); // 모든 에지를 저장
        }
        
        // 벨만 포드 알고리즘
        boolean checked = false; // 음수 사이클 여부
        for (int i = 1; i <= N; i++) { // DP 업데이트를 N-1번 반복하고, N번 째에 음수 사이클을 확인함
            for(Edge e : edges) { // 모든 에지에 대해 계속 탐색함
                int start = e.from;
                int end = e.to;
                int time = e.cost;
                // 정답 배열 업데이트 조건 : 무한대가 아닌 DP 값 중에 최단 거리
                if(DP[start] != Long.MAX_VALUE && DP[end] > DP[start]+time) {
                    DP[end] = DP[start]+time;
                    if(i==N) checked = true; // N 번째에 업데이트가 발생함 = 음수 사이클이 존재함
                }
            }
        }
    }
}
```
위의 알고리즘처럼 최단 거리를 구하는 것이 아닌, 최대 비용을 구하고 싶을 때는 DP 업데이트 방식을 반대로 변경해주면 된다. 
즉 `DP[end] < DP[start]+time`일 때 업데이트하며, 이 때 음수 사이클 검사 구문도 양수 사이클을 찾는 구문으로 바뀌게 된다.

## 플로이드-워셜 O(V^3)
정해진 시작점 없이, 주어진 모든 노드 간의 최단 경로를 탐색한다. 시간복잡도가 크기 때문에 주어진 정점 V가 500개 이하일 때 사용할 수 있다.
음수 가중치 에지가 있어도 계산이 가능하다. 동적 계획법의 원리를 이용해 알고리즘에 접근할 수 있다.

- 전체 경로의 최단 경로는 부분 경로의 최단 경로의 조합으로 이루어진다.
- 즉, 점화식은 `D[S][E] = Math.min(D[S][E], D[S][K]+D[K][E]`이다.

1. 인접 행렬로 최단 거리 배열 `D[S][E]`를 선언하고 초기화함
   1. `D[S][E]`는 노드 S에서 노드 E까지의 최단 거리를 저장하는 배열임
   2. S와 E의 값이 같은 칸은 0, 다른 칸은 무한으로 초기화함 (자기 자신에게 가는 최단 거리는 0이기 때문)
2. 최단 거리 배열에 그래프 데이터를 저장함
   1. 플로이드-워셜 알고리즘은 사용하는 정점 V의 개수가 적기 때문에 인접 행렬로 그래프를 표현함
   2. 출발 노드 S, 도착 노드 E, 에지의 가중치 W에 대해 `D[S][E] = W`로 배열에 입력함
3. 점화식을 3중 for 문의 형태로 반복하면서 배열을 업데이트함
```text
# 플로이드-워셜 알고리즘 로직
for 경유지 K에 관해 (1~N) // N=노드 개수
    for 출발 노드 S에 관해 (1~N)
        for 도착 노드 E에 관해 (1~N)
        D[S][E] = Math.min(D[S][E], D[S][K]+D[K][E])
        
```

```java
public class Main {
    public static void main(String[] args) {
        long[][] D = new long[N+1][N+1]; // 최단 거리 배열
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) D[i][j] = 0;
                else D[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) { // 인접 행렬에 그래프 저장
            D[a][b] = Math.min(D[a][b], c);
        }
        
        // 플로이드-워셜 알고리즘
        for(int k = 1; k <= N; k++){
            for(int s = 1; s <= N; s++){
                for(int e = 1; e <= N; e++){
                    D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
                }
            }
        }
    }
}
```
완성된 배열은 모든 노드 간의 최단 거리를 저장하고 있다.
값이 무한대일 경우, 경로가 존재하지 않는 것이다.


## 최소 신장 트리 (MST; Minimum Spanning Tree)
그래프가 주어졌을 때, 최소 비용으로 모든 노드를 연결하는 알고리즘이다.
사이클 여부를 확인해야 하기 때문에 유니온 파인드를 활용한다.
음수 가중치를 가지는 에지가 있어도 가능하다.

- 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않음 (유니온 파인드로 판별)
- N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1개임

크루스칼 알고리즘과 프림 알고리즘으로 구현할 수 있다.

### 크루스칼 O(ElogV)
가중치가 가장 작은 에지부터 먼저 연결해서 최소 신장 트리를 구성한다. 이 때 유니온 파인드 기법으로 사이클 여부를 검사한다.

1. 에지 리스트로 그래프를 구현하고 유니온 파인드 배열을 초기화함
   1. 노드 변수 2개와 가중치 변수를 가지는 `A[N][3]`형태의 `ArrayList<edge> edges`를 선언함
   2. 사이클 처리를 위한 유니온 파인트 배열을 자기 자신의 인덱스 값으로 초기화함
2. 그래프 데이터를 가중치를 기준으로 정렬함
   1. 에지 리스트에 담긴 데이터를 가중치 기준으로 오름차순 정렬함
3. 가중치가 낮은 에지부터 연결을 시도함
   1. 에지를 연결했을 때 그래프에 사이클 형성 유무를 find 연산을 이용해 확인
   2. 사이클이 형성되지 않을 때만 union 연산으로 두 노드를 연결함
   3. 만약 사이클이 존재한다면, 현재 더 낮은 가중치의 에지로 연결되어 있다는 뜻임
4. 연결한 에지의 개수가 N-1이 될 때까지 과정 3을 반복함
5. 총 에지 비용 출력하기

```java
public class Main {
    static PriorityQueue<Edge> edges; // 에지 리스트
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int[] parent; // 유니온 파인드 배열

    public static void main(String[] args) {
        // 우선순위 큐로 에지 리스트를 구성함으로써 오름차순 정렬을 수행함
        edges = new PriorityQueue<>();
        
        // 유니온 파인드 배열을 자기 자신의 인덱스 값으로 초기화
        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        // 그래프 저장
        for (int i = 0; i < E; i++) {
            edges.add(new Edge(a, b, c));
        }
        
        // 크루스칼 알고리즘
        int usedEdge = 0;
        int result = 0;
        while(usedEdge < V-1){ // 에지의 개수가 N-1이 될 때까지 반복
            Edge e = edges.poll(); // 가장 작은 가중치의 에지를 선택
            int now = e.from;
            int next = e.to;
            if(Find(now) != Find(next)){ // 사이클 여부 판별
                Union(now, next);
                result = result + e.cost;
                usedEdge++;
            }
        }
        System.out.println(result);
    }
}

```

---
# 트리
## 이진 트리


## 인덱스 트리 O(MlogN)
2042 구간 합 구하기 참고
1. 구간 left, right가 주어졌을 때, A[left] + A[left+1] + ... + A[r-1] + A[r]
2. i번째 수 A[i]를 V로 바꾸어라 = update

트리를 저장하는 1차원 배열은 2^n * 2 크기로 선언한다.\
왜냐하면 리프 노트의 개수가 N개 이상이 되도록 높이 T인 트리 배열을 만들어야 함\
배열의 0번째는 사용하지 않는다.\
그래서 리프 노드가 8개라면 arr[16]으로 선언하고 0번째 배열을 제외한 15개의 노드를 사용함\
리프 포인터를 설정해서 리프 노드를 저장하고 업데이트할 때 사용함

parent index = current index/2


## 최소 공통 조상(LCA)


---

























