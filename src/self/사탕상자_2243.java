package self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 사탕상자_2243 {
    static int N;
    static int leafPointer;
    static int[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        initTree();

        int A, B;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(A == 1) {
                bw.write(recursion(1, B) + "\n");
            }else {
                update(B, Long.parseLong(st.nextToken()));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void update(int index, long value) {
        int treeIndex = leafPointer + index - 1;

        tree[treeIndex] += value;
//		System.out.println("tree: "+ treeIndex + ", " + tree[treeIndex]);
        treeIndex /= 2;

        while(treeIndex>0) {
            tree[treeIndex] = tree[treeIndex*2] + tree[(treeIndex*2)+1];
            treeIndex /= 2;
        }
//		System.out.println("root: "+tree[1]);

    }

    static int recursion(int index, int rank) {
        if(index >= leafPointer) {
            int result = index-leafPointer+1;
            update(result, -1);
            return result;
        }
        int left = tree[index*2];

        if(left < rank) { //right
            int new_rank = rank-left;
            index = index*2 + 1;
            index = recursion(index, new_rank);
        }else if (left >= rank) { // left
            index = index*2;
            index = recursion(index, rank);
        }
        return index;
    }

    static void initTree() {
        int leafCount = 1;

        while( 1000000 > leafCount) {
            leafCount <<= 1;
        }

        tree = new int[leafCount*2];
        leafPointer = leafCount;
//		System.out.println("leafPointer: "+leafPointer);


    }
}
