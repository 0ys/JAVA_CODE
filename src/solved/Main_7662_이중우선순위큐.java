package solved;

import java.io.*;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
    static TreeMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());

                if(c == 'I') {
                    map.put(a, map.getOrDefault(a, 0) + 1);
                    //printTree();
                }
                else {
                    if(map.isEmpty()) continue;
                    if(a == 1) {
                        int b = map.lastKey();
                        if(map.get(b) == 1) map.remove(b);
                        else map.put(b, map.get(b) - 1);
                        //printTree();
                    }
                    else {
                        int b = map.firstKey();
                        if(map.get(b) == 1) map.remove(b);
                        else map.put(b, map.get(b) - 1);
                        //printTree();
                    }
                }
            }

            if(map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(map.lastKey()+" "+map.firstKey()+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void printTree(){
        for(Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("-----------");
    }
}
