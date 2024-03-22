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

#### 코드트리 예시 : 제한시간이 1초일때
- N<=10 : N!, 2^N, 3^N
- N<=20 : 2^N
- N<=100 : N^4
- N<=500 : N^3
- N<=1,000 : N^2, N^2logN
- N<=100,000 : N, NlogN, logN, O(1)

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

---
# 탐색
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

---

























