# 자바의 입출력

## Scanner
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        double d = sc.nextDouble();
        String s = sc.next();
        char c = sc.next().charAt(0);
    }
}
```

## Buffered

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long L = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        bw.write(a+b); // string만 입력가능!
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
```

## String
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuffer bf = new StringBuffer();
        
        bf.append("1234");
        bf.append("5678");

        System.out.println(bf.toString());
    }
}
```

## File
```java
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
```