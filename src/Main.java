import java.util.HashMap;
import java.util.Map;

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