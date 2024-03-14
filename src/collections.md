# 자바의 자료구조
자바에서는 ArrayList, Stack, Queue, Deque 등의 자료구조를 사용할 수 있다.
이렇게 사용이 가능한 이유는 자바에서 이런 자료구조를 사용할 수 있도록 미리 Collection을 만들어 놓았기 때문이다.
이렇게 Collection으로 정의되어 있는 자료구조들을 컨테이너라고 부른다.
이러한 컨테이너 내에는 원소들을 순회하기 위한 iterator라는 이름의 반복자를 사용하기도 한다.

## Iterator
`iterator.next()`로 한 칸씩 원소를 확인하고 `iterator.hasNext()`로 그 다음 값이 남았는지 확인한다.
```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();   // 정수를 관리할 ArrayList를 선언하고
        v.add(5);                                   // v : [5]
        v.add(2);                                   // v : [5, 2]
        v.add(9);                                   // v : [5, 2, 9]

        // Iterator를 이용한 Vector 컨테이너 내의 원소들 순회
        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);                // 5 2 9
        }
    }
}
```

## 동적 배열 : ArrayList
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();

        v.add(E);
        v.remove(i);
        v.size();
        v.get(i);
    }
}
```
1. add(E) : 맨 뒤에 데이터 E를 추가
2. remove(index) : index 위치에 있는 원소를 삭제
    - remove(0)부터 remove(v.size()-1)까지
3. size() : 현재 ArrayList에 들어있는 데이터의 수를 반환
4. get(index) : index 위치에 있는 원소를 조회
### 정적 배열 `int[] a = new int[100];`
동적 배열에서 삽입, 삭제, 탐색하는 과정은 모두 정적 배열과 동일하기 때문에 시간복잡도는 완전히 일치한다.
하지만 메모리를 동적으로 필요한만큼만 사용한다는 차이가 있다.

### ArrayList vs LinkedList
|           | ArrayList                         | LinkedList                         |
| --------- | --------------------------------- | ---------------------------------- |
| 컬렉션 구성    | 배열을 이용                            | 노드를 연결(linked)                     |
| 데이터 접근 시간 | 모든 데이터 상수 시간 접근                   | 위치에 따라 이동시간 발생                     |
| 삽입/삭제 시간  | 삽입/삭제 시 데이터 이동이<br>필요한 경우 추가시간 발생 | 삽입/삭제 위치에 따라 그 위치<br>까지 이동하는 시간 발생 |
| 리사이징 필요   | 공간이 부족할 경우 새로운<br>배열에 복사해야 함      | -                                  |
| 데이터 검색    | 최악의 경우 리스트에 있는 <br>아이템 수만큼 확인     | 최악의 경우 리스트에 있는 <br>아이템 수만큼 확인      |
| CPU Cache | 캐시 이점을 활용                         | -                                  |

## 연결 리스트 : Linked List
탐색은 O(N)으로 느리지만, 삽입과 삭제 연산은 O(1)로 매우 빠르다.
일반적으로 연결 리스트에서 하나의 노드는 데이터와 다른 노드로 이동하는 경로를 갖고 있다.
각 노드는 data와 next를 가지며, next는 그 다음 노드의 위치를 가리킨다.
- 단일 연결 리스트 : 단방향 연결
  - Head 부터 Tail까지 탐색한다.
- 양방향 연결 리스트 : 역순 탐색이 가능
  - 실제 자바의 컬렉션 프레임워크에 구현된 방식이다. 
- 양방향 원형 연결 리스트 : head와 tail을 연결

Linked List는 리스트 용도 뿐만 아니라, 구조 특성 상 Stack이나 Queue로서도 이용 가능하다. 
```java
import java.util.LinkedList;
public class Main {
   public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>();
      
      list.add("new");
      list.add(1, "new");
      list.get(1);
      list.subList(0,1);
      list.remove(1);
      list.clear();
      list.poll();
      list.peek();
      list.size();
      list.isEmpty();
   }
}
```
1. add(index, element) : index 위치에 객체를 저장
2. remove(A) : index 위치에 있는 객체 또는 지정된 객체를 제거
3. subList(int fromIndex, int toIndex) : 범위안에 저장된 객체를 List로 반환

## 스택 : Stack
삽입과 삭제 연산이 후입선출로 이뤄지는 자료구조이다. top이 삽입과 삭제가 일어나는 위치를 뜻한다.
스택은 깊이 우선 탐색(DFS), 백트래킹 종류의 코딩테스트에 효과적이다. 특히 개념 자체가 재귀 함수 알고리즘 원리와 일맥상통한다.
```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.pop();
        stack.peek();
        stack.size();
    }
}
```
1. push(E) : top 위치에 데이터 E를 추가
2. pop() : top 위치에 현재 있는 데이터를 삭제하고 확인
3. peek() : top 위치에 있는 데이터를 확인

## 큐 : Queue
삽입과 삭제 연산이 선입선출로 이뤄지는 자료구조이다. 그래서 삽입과 삭제가 양방향에서 이뤄진다.
rear는 큐에서 가장 끝 데이터를 가리키며, front는 큐에서 가장 앞 데이터를 가리킨다.
큐는 너비 우선 탐색(BFS)에서 자주 사용한다.
```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.poll();
        queue.peek();
        queue.size();
    }
}
```
1. add(E) : rear 부분에 새로운 데이터를 삽입
2. poll() : front 부분에 있는 데이터를 삭제하고 확인
3. peek() : front 위치에 있는 데이터를 확인

### 우선순위 큐 : Priority Queue
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
        // 기본 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        // Comparable 를 활용한 우선순위 설정
        PriorityQueue<Node> que = new PriorityQueue<>();

        // 새로운 우선순위 설정 : 절댓값에 따라 순위결정하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) return o1 > o2 ? 1 : -1; // 절댓값이 같으면 더 작은 수를 먼저(오름차순)
            else return first_abs - second_abs;
        });
        
        // Comparator 클래스를 활용한 우선순위 설정
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

## ArrayDeque
```java
ArrayDeque<A> deque = new ArrayDeque<>();
```

## Arrays.sort
```java
public class Main {
    public static void main(String[] args) {
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
    }
}
```