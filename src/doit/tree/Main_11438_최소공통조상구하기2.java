package doit.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main_11438_최소공통조상구하기2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

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
