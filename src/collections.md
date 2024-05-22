# 목차
- [자바의 자료구조](#자바의-자료구조)
  * [Iterator](#iterator)
  * [Sort](#sort)
- [기본 자료구조](#기본-자료구조)
  * [ArrayList](#동적-배열--arraylist)
  * [Linked List](#연결-리스트--linked-list)
  * [Stack](#스택--stack)
  * [Queue](#큐--queue)
- [중급 자료구조](#중급-자료구조)
  * [ArrayDeque](#arraydeque)
  * [HashMap](#hashmap)
  * [TreeMap](#treemap)
  * [HashSet](#hashset)
  * [TreeSet](#treeset)
  * [Priority Queue](#우선순위-큐--priority-queue)


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

## Sort
Collections에 포함되는 자료구조는 라이브러리를 통해 간단하게 정렬을 수행할 수 있다.
특히 Comparator<>를 선언하여 커스텀으로 정렬할 수 있다.
보통 퀵 정렬로 구현되어 있다. 시간 복잡도는 O(NlogN)이며 최악의 경우 O(N^2)이다.
```java
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
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


---
# 기본 자료구조
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
### 정적 배열 
`int[] a = new int[100];`
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
각 노드는 data, prev, next를 가진다. 즉 하나의 노드를 표현하는 구조체는 다음과 같이 구현된다.
```java
class Node {
    Data data;                 // Linked list의 노드에 담을 데이터
    Node prev, next;           // 노드의 prev와 next를 가리키는 포인터
    
    public Node(Data data) {   
        this.data = data;      // 초기에는 이전 노드와 다음 노드가 존재하지 않는다.
        this.prev = null;
        this.next = null;
    }
}
```
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
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();

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
import java.util.Queue;
import java.util.LinkedList;

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



---
# 중급 자료구조

## ArrayDeque
```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(2);
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
        deque.getFirst();
        deque.getLast();
        deque.peekFirst();
        deque.peekLast();
    }
}
```
ArrayDeque 공식문서에 보면 스택구조로 사용하면 Stack 클래스보다 빠르고, 큐 구조로 사용하면 Queue 클래스보다 빠르다.
다만 Thread-Safe하지 않아 멀티 쓰레드 환경에서는 문제가 있다. (synchronized를 장식해 만들어야 함)

### ArrayDeque vs LinkedList
ArrayDeque는 Queue의 서브인터페이스인 Deque의 구현체이고, LinkedList는 List와 Queue의 구현체이다. 
따라서 LinkedList는 List의 특징을 가지고 있고, ArrayDeque은 배열의 특성을 가지고 있다고 할 수 있다. 

- 연산 성능 
  - ArrayDeque을 배열의 측면에서 바라봤을 때, deque의 양끝에서 삽입/삭제 연산이 일어날 경우 시간 복잡도가 O(1)이므로 삽입/삭제 성능이 우수하다. 또한 Random access가 가능하기에 원소 조회 시에도 속도가 빠르다. 
  - LinkedList도 삽입/삭제 연산 성능이 좋지만, 특정 원소에 접근 시의 성능은 ArrayDeque에 비해 떨어진다. 
  - ArrayDeque는 LinkedList에 비해 cache-locality에 더 친숙하여 연산 속도가 더 빠르다.
- 메모리 
  - ArrayDeque은 LinkedList와 달리 다음 노드에 대한 참조를 유지할 필요가 없기 때문에 더 적은 메모리를 사용한다.

이런 차이점 때문에 큐 구현 시 ArrayDeque가 LinkedList보다 속도와 메모리 측면에서 더 효율적이라고 할 수 있으며, 이는 자바 공식문서에도 언급되어있다.


## HashMap
HashMap은 해싱을 기반으로 데이터를 관리하는 자료구조이다.
(key, value)쌍 형태로 데이터를 저장하기 때문에 삽입, 삭제, 탐색 등 모든 함수의 시간복잡도가 O(1)이다.
HashMap은 TreeMap보다 속도가 빠르지만, 값 자체에만 관심이 있고 그 순서에는 전혀 관심이 없는 자료구조이다.

```java
import java.util.HashMap;

HashMap<K, V> name = new HashMap<>();
// K, V는 Integer 등의 타입을 명시함, K는 key, V는 value
```

기본적인 사용방법은 아래와 같다.

1. m.put(K, V) : HashMap에 쌍(K, V)를 추가
2. m.remove(K) : 현재 HashMap에 들어있는 데이터 중 key가 K인 쌍을 찾아 제거
3. m.get(K) : 현재 HashMap에 들어있는 데이터 중 key가 K인 쌍을 찾아 V를 반환

만약 해당하는 쌍이 없다면 에러가 발생하기 때문에 미리 `m.containsKey(K)`를 확인하여 true인 경우에만 get(K)을 사용한다.
또는 `m.getOrDefault(K, D)` 함수를 사용하면 K에 해당하는 key가 없을 시에는 값 D를 기본으로 반환해준다.
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        m.put(5, 6); // m.put(K, V);
        m.put(2, 2);
        m.put(10, 1);
        
        if(m.containsKey(2)) System.out.println(m.get(2)); // m.get(K);
      
        m.remove(5);
        
        if(!m.containsKey(5)) System.out.println("not exists!");
        
        m.put(2, 10); // key가 2인 곳의 value 값을 업데이트함
        System.out.println(m.get(2)); // 10

        //전체 출력 : entrySet() 활용
        for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
          System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}
```

아래와 같은 문제에서 활용될 수 있다.
- 아주 큰 숫자를 Array의 Index로 사용하기
```java
/*서로 다른 6개의 숫자가 주어진 뒤 끝에 숫자 k가 주어졌을 때, 
숫자 k가 몇 번째로 주어졌는지를 판단하는 프로그램을 작성해보세요.
단, 주어지는 숫자의 범위는 -10^9 ~ 10^9 사이입니다.

예를 들어 [-656, 234, 65756344, 7678678, 123123, 567567567] 에서
k가 65756344라면, 3번째로 주어진 숫자이므로 답은 3이 됩니다.*/
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 6;
  
    public static int[] arr = new int[MAX_N];
    public static HashMap<Integer, Integer> numToIndex = new HashMap<>();
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
          numToIndex.put(arr[i], i + 1);
        }
    
        int k = sc.nextInt();
        System.out.println(numToIndex.get(k));
    }
}

/*
입력
6
-656 234 65756344 7678678 123123 567567567
65756344

출력
3
*/
```
- 문자열을 마치 Array의 Index처럼 사용하기
```java
/*서로 다른 6개의 문자열이 주어진 뒤 끝에 문자열 K가 주어졌을 때, 
문자열 K가 몇 번째로 주어졌는지를 판단하는 프로그램을 작성해보세요.

예를 들어 ["aba", "banana", "apple", "code", "tree", "foo"] 에서
K가 "banana"라면, 2번째로 주어진 문자열이므로 답은 2가 됩니다.*/

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 6;
  
    public static String[] arr = new String[MAX_N];
    public static HashMap<String, Integer> stringToIndex = new HashMap<>();
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
          arr[i] = sc.next();
          stringToIndex.put(arr[i], i + 1);
        }
    
        String k = sc.next();
        System.out.println(stringToIndex.get(k));
    }
}

/*
입력
6
aba banana apple code tree foo
banana

출력
2
*/
```


## TreeMap
TreeMap은 균형잡힌 이진트리 구조로 데이터를 관리하는 자료구조이다. 
각 노드에 (key, value)쌍 형태로 들어가 있어, key를 기준으로 노드의 위치가 결정되고 각 key에 대한 value 값을 저장하는 형태이다.
따라서 TreeMap에서의 삽입, 삭제, 탐색 등 모든 함수의 시간 복잡도는 전부 O(logN)이다.

```java
import java.util.TreeMap;

TreeMap<K, V> name = new TreeMap<>();
//K, V는 타입으로 K는 key, V는 value에 해당하는 타입을 선언함
```

기본적인 사용방법은 아래와 같다.

1. m.put(K, V) : TreeMap에 쌍(K, V)를 추가
2. m.remove(K) : 현재 TreeMap에 들어있는 데이터 중 key가 K인 쌍을 찾아 제거
3. m.get(K) : 현재 TreeMap에 key가 K인 쌍을 찾아 값 V를 반환
4. m.lastKey() : key를 기준으로 오름차순 정렬되므로, 최댓값을 반환
5. m.firstKey() : 최솟값을 반환

만약 해당하는 쌍이 없다면 에러가 발생하기 때문에 미리 `m.containsKey(K)`를 확인하여 true인 경우에만 get(K)을 사용한다.
또는 `m.getOrDefault(K, D)` 함수를 사용하면 K에 해당하는 key가 없을 시에는 값 D를 기본으로 반환해준다.
TreeMap은 key를 기준으로 오름차순 정렬한다. 그래서 중복된 key 값이 들어올 경우 Set처럼 하나의 값만을 유지한다.
입력으로 중복된 값이 주어질 경우, value에 들어오는 값의 count를 핸들링해서 문제를 해결할 수 있다.(백준 7662_이중 우선순위 큐 문제 참고)
```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> m = new TreeMap<>();

        m.put(5, 6); // m.put(K, V);
        m.put(2, 2);
        m.put(2, 3); // key값이 2인 entry의 value를 3으로 바꿈 (중복허용안함)
        m.put(10, 1);
  
        if(m.containsKey(2)) System.out.println(m.get(2)); // m.get(K);
  
        m.remove(5);

        //map.put(a, map.getOrDefault(a, 0) + 1); // value에 중복된 값을 cnt
        int b = m.lastKey(); // 최댓값
        int c = m.firstKey(); // 최솟값
  
        if(!m.containsKey(5)) System.out.println("not exists!");
  
        m.put(2, 10); // key가 2인 곳의 value 값을 업데이트함
        System.out.println(m.get(2)); // 10
    }
}
```

### iterator를 이용한 TreeMap을 key 기준 오름차순으로 순회
자바에서는 vector, stack 등의 컨테이너들을 iterator라는 반복자를 이용해 순회가 가능하다.
그 중에서도 TreeMap을 iterator로 순회하면 자동으로 key 기준 오름차순으로 순회가 된다.
TreeMap에서 iterator를 통해 나오는 결과는 `Entry<K, V>` 형태이다. 이 타입은 .getKey()와 .getValue()를 이용해 각 쌍의 key와 value 값을 얻을 수 있다.
다만 `import java.util.Map.Entry;`로 선언해주어야 한다!!
만약 순회 전에 TreeMap이 비어있는지를 알고 싶다면, isEmpty() 함수나 size()가 0인지를 확인하면 된다.
```java
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // 정수 쌍을 관리할 TreeMap을 선언
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(5, 6);
        m.put(2, 2);
        m.put(10, 1);
    
        // Iterator를 이용한 map 컨테이너 내의 원소를 순회
        Iterator<Entry<Integer, Integer>> iterator = m.entrySet().iterator();
        // key 기준 오름차순으로 순회하게 되므로 (2,2) (5,6) (10,1) 순으로 출력됨
        while (iterator.hasNext()) {
          Entry<Integer, Integer> entry = iterator.next();
          System.out.println(entry.getKey()+" "+entry.getValue());
        }
        
        //또는 간단하게
        for(Entry<Integer, Integer> entry : m.entrySet()){
          System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
```

또한 TreeMap<String, Integer> 타입으로 선언하면 문자열 인덱스 기준으로 단어를 사전순으로 오름차순 정렬할 수 있다.
```java
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> m = new TreeMap<>();
        // 각 단어가 주어진 횟수를 이미 알고 있다고 가정
        m.put("banana", 6);
        m.put("helloworld", 2);
        m.put("apple", 5);

        // Iterator를 이용한 TreeMap 컨테이너 내의 원소들 순회
        // key에 해당하는 문자열이 사전순으로 앞선 쌍 부터 조회! (apple, banana, helloworld 순)
        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
/*>> 결과
apple 5
banana 6
helloworld 2
*/
```


## HashSet
Set 인터페이스는 쉽게 말해 집합으로, 중복된 값을 저장할 수 없으며 하나의 null 값만 저장할 수 있다.
Set은 비선형 구조이기 때문에 순서의 개념과 인덱스가 존재하지 않는다.
HashSet은 이러한 Set 인터페이스를 상속받는다. 해싱을 기반으로 데이터를 관리해주는 자료구조이다.
삽입, 삭제, 탐색 등 모든 함수의 시간복잡도가 O(1)이다.
HashSet은 TreeSet보다 속도가 빠르지만, 값의 존재 여부에만 관심있지 그 순서에는 전혀 관심이 없는 자료구조이다.

```java
import java.util.HashSet;

HashSet<T> s = new HashSet<>();
// T는 타입으로, HashSet 안에 들어갈 원소의 타입을 명시함
```

기본적인 사용방법은 아래와 같다.

1. s.add(E) : HashSet에 데이터 E를 추가
2. s.remove(E) : 현재 HashSet에 들어있는 데이터 중 E을 찾아 제거
3. s.contains(E) : 현재 HashSet에 데이터 E가 들어있는지를 찾아서 true/false를 반환

```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        s.add(3);
        s.add(9);
        s.add(5);
        
        if(s.contains(3)) System.out.println("exists!");
        
        s.remove(9);
        if(!s.contains(9)) System.out.println("not exists!");
    }
}
```

또한 집합 자료구조이기 때문에 HashSet을 이용하면 두 배열의 원소가 모두 일치하는지 검사할 수 있다.
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 5, 3, 2};
        int n1 = 5;
        HashSet<Integer> set1 = new HashSet<>(); // 1번 배열 Set

        for(int i = 0; i < n1; i++)
            set1.add(arr1[i]);
        
        int[] arr2 = new int[]{5, 5, 2, 3, 1, 2, 2, 5};
        int n2 = 8;
        HashSet<Integer> set2 = new HashSet<>(); // 2번 배열 Set

        for(int i = 0; i < n2; i++)
            set2.add(arr2[i]);

        boolean notExist = false;
        for(int i = 0; i < n1; i++)
            if(!set2.contains(arr1[i])) // 2번 Set에 대해 1번 배열의 원소가 모두 존재하는지 확인
                notExist = true;

        for(int i = 0; i < n2; i++)
            if(!set1.contains(arr2[i])) // 1번 Set에 대해 2번 배열의 원소가 모두 존재하는지 확인
                notExist = true;

        if(notExist == false)
            System.out.println("Same!");
    }
}

```

## TreeSet
TreeSet은 균형잡힌 이진트리 구조로 데이터를 관리한다. 따라서 삽입, 삭제, 탐색 등 모든 함수의 시간복잡도가 O(logN)이다.
```java
import java.util.TreeSet;

TreeSet<T> s = new TreeSet<>();
// T는 TreeSet 안에 들어갈 원소의 타입
```

기본적인 사용방법은 아래 7가지이다.

1. s.add(E) : TreeSet에 데이터 E를 추가
2. s.remove(E) : 현재 TreeSet에 들어있는 데이터 중 E을 찾아 제거
3. s.contains(E) : 현재 TreeSet에 데이터 E가 들어있는지를 찾아서 true/false를 반환
4. s.ceiling(E) : TreeSet 내에 있는 값들을 오름차순으로 정렬했다고 가정했을 때, `E보다 같거나 큰 최초의 값을 반환`, 없다면 null 값을 반환
   - 반대로 같거나 작은 최초의 값을 반환하고 싶은 경우 s.floor(E)를 사용
5. s.higher(E) : TreeSet 내에 있는 값들을 오름차순으로 정렬했다고 가정했을 때, `E보다 큰 최초의 값을 반환`, 없다면 null 값을 반환
   - 반대로 E보다 작은 최초의 숫자를 반환하고 싶은 경우 s.lower(E)를 사용
6. s.first() : TreeSet은 오름차순 정렬이기 때문에 가장 작은 값을 반환
7. s.last() : TreeSet의 가장 큰 값을 반환

first()와 last()로 탐색하기 전에 TreeSet이 비어있는지 isEmpty()로 확인해야 한다. 비어있는 트리에 first(), last()로 접근할 경우 에러가 발생한다.
마찬가지로 ceiling이나 higher도 null값을 반환하는지 확인하는 조건문을 다는 것이 좋다.
또한 Comparable<>을 선언하여 정렬 기준을 세우면, 해당 기준에 맞게 데이터를 정렬하여 저장한다. 즉, 문제 조건에 맞게 정렬을 수행하고 데이터를 탐색할 수 있다.

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer, Integer> s = new TreeSet<>();
        s.add(3);
        s.add(9);
        s.add(5);
        
        if(s.contains(3)) System.out.println("exists!");

        System.out.println(s.ceiling(3)); // 3
        System.out.println(s.higher(3)); // 5
        System.out.println(s.first()); // 3
        System.out.println(s.last()); // 9
        
        s.remove(9);
        s.remove(s.last());
        if(s.contains(9)) System.out.println("not exists!");
    }
}
```

또한 TreeSet을 이용하면 배열의 최댓값을 O(longN)에 찾을 수 있다.
특히나 특정 값이 삭제되고 추가될 수 있는 상황에서 최댓값을 빠르게 구해야 한다면 TreeSet을 사용해 효율적으로 해결할 수 있다.
즉, 아래와 같은 문제에서 활용될 수 있다.
- 현재까지의 최댓값을 빠르게 구하기
- 같거나 큰 숫자 중 최솟값 빠르게 구하기
- 원하는 값을 삭제하며 최댓값 유지하기
```java
/*[3, 6, 2, -6, 7, -7, -2] 와 같이 숫자들이 순서대로 주어졌을 때,
각각의 숫자가 주어질 때 마다 지금까지 주어진 숫자들 중 
최댓값을 출력하는 프로그램을 작성해보세요.

단, 음수가 주어지면 해당 숫자에 -1을 곱한 양수 값을 찾아 제거해줍니다. 
이 숫자를 제외한 숫자들 중 최댓값을 출력해야 합니다.*/

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 2, -6, 7, -7, -2};
        int n = 7;
        
        TreeSet<Integer> s = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0)              // 양수인 경우에는
                s.add(arr[i]);          // set에 넣어줍니다.
            else                        // 음수인 경우에는
                s.remove(-arr[i]);      // set에서 제거해줍니다.
            
            System.out.print(s.last() + " "); // 최댓값을 출력해줍니다.
        }
    }
}

//>> 출력 : 3 6 6 3 7 3 3
```
- 기준이 여러 개일때의 lower, upper bound : Comparable<>활용
```java
/*사람들의 키와 몸무게 정보가 주어졌을 때,
주어진 (height, weight)를 기준으로
우선순위가 가장 높은 사람을 찾는 프로그램을 작성해보세요.

1. 키가 height와 동일하면서 몸무게가 weight보다 같거나 큰 사람이 있다면 
   그 중 몸무게가 가장 적은 사람을 선택합니다.
2. 1을 만족하는 사람이 없다면,
   키가 height보다 큰 사람들 중 키가 가장 작은 사람을 찾습니다. 
   만약 키가 작은 사람이 여러 명이라면, 그 중 몸무게가 가장 작은 사람을 골라주세요.

예를 들어
[(170, 60), (160, 55), (180, 82), (185, 77), (170, 30)] 이렇게 사람 정보가 주어졌을 때

(height, weight)값이 (165, 50) 이었다면, 키 165 이상이면서 가장 키가 작은 경우는 
키가 170인 경우인데, 그런 경우가 여럿 있으므로 그 중 몸무게가 가장 작은 
(170, 30)이 답이 됩니다.*/

import java.util.TreeSet;

class Pair implements Comparable<Pair> {
  int height, weight;

  public Pair(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Pair p) {          // (키, 몸무게) 순 오름차순 정렬
    if(this.height != p.height)         // 키가 다르다면     
      return this.height - p.height;  // 키를 기준으로 오름차순 정렬을 진행합니다.
    else                                // 키가 같다면     
      return this.weight - p.weight;  // 몸무게 기준으로 오름차순 정렬을 진행합니다.
  }
};

public class Main {
  public static void main(String[] args) {
    TreeSet<Pair> s = new TreeSet<>();

    s.add(new Pair(170, 60));
    s.add(new Pair(160, 55));
    s.add(new Pair(180, 82));
    s.add(new Pair(185, 77));
    s.add(new Pair(170, 30));

    Pair bestPerson = s.ceiling(new Pair(165, 50));
    System.out.println(bestPerson.height + " " + bestPerson.weight);
  }
}

// >> 출력 결과 : 170 30
```
- 인접한 두 숫자를 빠르게 구하기 : lower, higher 함수 활용
```java
/*[1, 5, 2, 10, 6] 와 같이 수들이 주어져 있는 상황에서
수 9와 가장 가까이에 있는 
양쪽 두 숫자를 구하는 프로그램을 작성해보세요.
*/
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();

        s.add(1);
        s.add(5);
        s.add(2);
        s.add(10);
        s.add(6);

        int x = 9;

        int rightNum = s.higher(x);      // x보다 큰 최초의 숫자를 구한 뒤
        System.out.println(rightNum);      // 출력합니다. (10)
        
        int leftNum = s.lower(rightNum); // lower 함수를 이용하여 한칸 전으로 이동합니다.
        System.out.println(leftNum);       // 해당 값을 출력합니다. (6)
    }
}

//>> 10
//    6

```

## 우선순위 큐 : Priority Queue
우선순위 큐는 값이 들어간 순서와 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조이다.
큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치한다.
일반적으로 힙을 이용해 구현하며, Comparable 또는 Comparator를 이용하여 우선순위를 설정한다.

```java
import java.util.PriorityQueue;

PriorityQueue<T> pq = new PriorityQueue<>();
// T는 우선순위 큐 안에 들어갈 원소의 타입
```

기본적인 사용방법은 아래와 같다.

1. add(E)
2. size()
3. isEmpty()
4. peek()
5. poll()

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

