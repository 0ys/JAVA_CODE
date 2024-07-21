# 설치 및 실행
1. JDK 설치 - bellsoft-jdk 17.0.9+11
    1. JDK 설치는 앞으로 자바에 사용할 부품들을 준비하는 것이다.
    2. OpenJDK인 BellSoft를 사용한다.
2. spring-tool-suite-4-4.22.1 jar 파일의 압축을 푼다.
    1. jar는 자바에서 쓰는 압축파일로 더블클릭했을 때 실행이 가능한 파일을 말한다.
    2. JDK를 깔았기 때문에 jar를 사용할 수 있다.
    3. sts-4.22.1 폴더를 얻을 수 있다. spring-tool-suite를 줄여서 sts라 표시한다.
    4. 폴더 안의 ini 파일에 `-Dfile.encoding=UTF-8` 추가한다. 전체 설정에서 한국어를 추가할 수 있다.
3. Spring Tool Suite4 앱을 열어 워크스페이스 설정한다.
    1. 새로운 폴더를 만들어 워크스페이스로 지정한다.
    2. 전체 폴더 > 워크스페이스 > 프로젝트 > 소스코드 순으로 폴더가 구성된다.
    3. ssafy > startcamp > StartCampProject > src...
    4. 하나의 워크스페이스에는 여러 프로젝트를 만들 수 있다.
5. 웹에서 돌아가는 자바 프로그래밍 설치하기 위해서,,
    1. help > 이클립스 마켓플레이스에 java web을 검색해서 Eclipse Enterprise Java and Web 설치한다.
    2. selected all > trust 선택 후 설치 완료
    3. perspective에서 JAVA EE로 환경 변경 후 사용가능하다
6. tomcat.apache.org에서 tomcat10.1.25의 zip파일을 다운로드해서 워크스페이스의 상위폴더에 옮긴다.
    1. https://tomcat.apache.org/download-10.cgi
    2. 워크스페이스 폴더의 상위 폴더에 설치해서 한꺼번에 관리할 수 있다.
7. JAVA EE로 변경후 Servers 탭에서 새로운 서버 연결한다.
    1. 다운로드한 아파치 톰캣 폴더로 연결해서 설치한다.
    2. Window > Preferences > Server> runtime environments에 아파치 톰캣있는지 확인한다.
8. Servers 탭에 있는 설치한 Tomcat 10.1 클릭하면 서버를 시작할 수 있다.
    1. started로 상태 바뀐다.
    2. 콘솔창에서 로그 확인 → “서버가 밀리초 내에 시작되었습니다.”
    3. 문제가 생기면 콘솔창에서 확인 가능하다.
    4. 서버를 종료한다.
9. JAVA로 다시 perspective를 바꾸고 새 자바 프로젝트를 생성한다.
    1. 탐색기 > 워크스페이스 폴더 안에 방금 만든 프로젝트를 볼 수 있다.
    2. 프로젝트와 패키지로 구성되어 있지만 사실 폴더로 전부 구분되어 있는 걸 확인할 수 있다.
    3. 그래서 프로젝트 단위에 맞춰서 폴더를 구성하면 된다.
    4. 워크스페이스 > 프로젝트 > 패키지 > 자바파일 순서로 구성된다.
    5. com.one, come.two, … 처럼 하위 패키지 구성으로 해서 모든 작업을 완료 후 가장 상위 폴더만 압축해서 서버에 배포할 수 있다.
10. 자바 파일 작성 후 실행한다.
    1. Select a way to run 에서 Java  Application 선택한다.
11. 탐색기에서 프로젝트 폴더 안을 보면 bin안에 class파일이 있다.
    1. 선언한 class당 .class파일이 만들어진다.
12. 자바로 프로그램을 만들고(.java) → javac.exe가 컴파일함 → 실행파일(.class)을 만든다 → 실행파일의 실행은 java.exe가 함 → JVM에서 돌아감 → 플랫폼(맥 또는 윈도우) 위에서 동작함
    1. 자바의 실행파일은 어떤 환경에서 돌아갈지 모르기 때문에 아직 완벽한 기계어가 아니다. 그래서 실행을 할 때 자바 가상머신(JVM)을 필요로 한다. JDK에 JVM, java.exe, javac.exe가 있다. JVM 덕분에 맥과 리눅스, 윈도우에 상관없이 실행이 가능하다.
    2. 자바는 플랫폼에 상관없이 모두 실행 가능하다. JVM이 플랫폼에 맞춰서 .class파일을 실행해준다.


# 이클립스 단축키
- `ctrl+alt+아래화살표` = 아래쪽으로 코드 한줄 복사(위 화살표는 위로 복사)
- `ctrl+D` = 한 줄 삭제
- `ctrl+space` = 자동완성
- `alt+화살표` = 한 줄 위아래로 이동


# 자바의 기본

```java
class ByeWorld {}
class Static {}
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("this is my first java program...");
		System.out.println("this is my second java program...");
	}
}
```

- 자바의 특징
    - 객체지향 언어이다.
    - 플랫폼에 독립적이다.
- 객체지향
    - 객체지향에서 클래스는 하나의 부품이다.
    - 클래스는 재사용성을 염두에 두고 만든다.
- main 메소드
    - 클래스 실행을 위한 부분
    - 즉, 실행되는 클래스(main이 있는 클래스)와 실행되지 않는 클래스(main이 없는 클래스)로 구분할 수 있다.
        - 실행되지 않는 클래스는 다른 클래스의 부품으로 사용될 수 있다.
    - 프로젝트를 할 때 main 메소드는 하나만 정의하면 된다.

## 자바의 데이터타입

### 기본형(primitive)

char도 정수형에 속함(숫자를 저장할 수 있음)

```java
public class DataTypeTest {
	public static void main(String[] args) {
		// 참조형 : HelloWorld 타입
		HelloWorld hello;
	
		// 논리형
		boolean flag = true;
		
		// 정수형 : integer
		byte b = 125;
		short s = 12345;
		int i = 1234567;
		long l = 123456789;
		char c = 'b'; // 글자 한 개
		String name = "tom"; // 참조형, String 문자열 타입
		
		// 실수형 : double
		float f = 1.2f;
		double d = 3.14;
		
		System.out.println(flag);
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
	}
}
```

💡 **크기 비교**
byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
float가 long보다 사이즈는 작지만, 저장할 수 있는 값의 개수가 훨씬 많다.

- 논리형
  - boolean : true, false
- 정수형
  - byte : 8비트, -128 ~ 127
  - short : 16비트, -32,768 ~ 32,767
  - int : 32비트, -2,147,483,648 ~ 2,147,483,647
  - long : 64비트, -9223372036854775808 ~ 9223372036854775807
  - char : 16비트 유니코드, 수치로는 0~65535
- 실수형
  - float : 32비트, IEEE 754-1985표준
  - double : 64비트, IEEE 754-1985표준

### 참조형
기본형을 제외한 나머지
- String, Class
    - 정의한 클래스를 데이터 타입으로 사용할 수 있다.

### 리터럴
```java
public class DataTypeTest {
	public static void main(String[] args) {
		// 정수형 : integer
		byte b = 125;
		int b2 = b + 1; // 정수 리터럴(4byte)과 연산하는 경우 결과는 int로 나옴(업캐스팅)
		b = (byte)(b+1); // Explicit 형 변환
		
		short s = 12345;
		s = (short)(s+1); // 형 변환
		
		int i = 1234567;
		long l = 123456789;
		
		// 실수형 : 실수 리터럴은 8byte에 저장됨
		float f = 1.2f;
		double d = 3.14;
		
		float y = 10L; // 가능 : implicit 형 변환
		long x = 1.1;  // 불가능
		
		System.out.println(flag);
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
	}
}
```

- literal 값 1은 정수 리터럴이다. 정수 리터럴은 4byte로 저장된다.
    - 정수 리터럴과 연산하는 경우 결과는 int로 나온다.
- 실수 리터럴은 8byte에 저장된다.
- 그래서 기본 데이터 타입은 정수는 int, 실수는 double을 사용한다.
    - 리터럴과 계산할 때 형 변환이 필요하지 않다.

### Type Casting
- Implicit Type Casting : 작은 크기의 타입은 큰 크기의 타입으로 자동으로 형 변환됨
- Explicit Type Casting : 큰 크기의 타입을 작은 크기의 타입으로 변경할 경우


## 연산자

```java
public class OperatorTest {
	public static void main(String[] args) {
		int a1 = 5, b1 = 6;
		// 숏 서킷 예제
		if(++a1 > 7 && ++b1 < 10)
			System.out.println("hello");
		System.out.println(a1 + ":" + b1); //6:6
		
		if(++a1 > 7 & ++b1 < 10)
			System.out.println("hello");
		System.out.println(a1 + ":" + b1); //6:7
		
		boolean a = true, b = false, c = true;
		int x = 10, y = 3;
		int result = x % y; // 나머지
		System.out.println(result);
		
		// &&: and, ||: or
		if(a && b) System.out.println("a && b");
		// short circuit logic 숏 서킷 적용 : 연산자 앞을 체크해서 거짓이면 뒤를 체크하지 않음
		if(b && a) System.out.println("b && a");
		// 연산자 앞을 체크하고도 뒤 연산자를 체크함 -> 실행속도가 느림
		if(b & a) System.out.println("b & a"); 

		if(a && c) System.out.println("a && c");
		if(a || b) System.out.println("a || b");
		
		int max = (x > y) ? x: y;
		System.out.println(max);
	}
```

## 조건문

Switch는 백프로 if-else로 변경가능하지만, if-else는 전부 Switch문으로 바꿀 수 없다. 크기 비교하는 부등호를 Switch문을 쓸 수 없다.(=동등비교만 한다)

```java
public class SwitchTest {
	public static void main(String[] args) {
		int score = 90;
		switch (score) { // byte, short, int, char, String 타입만 가능함!
		case 100:
			System.out.println("levle-1");
			break;
			
		case 90:
			System.out.println("levle-2");
			break;
			
		case 80:
			System.out.println("levle-3");
			break;
			
		default:
			System.out.println("no level");
			break;
		}
	}
}
```

```java
public class SwitchTest {
	public static void main(String[] args) {
		char code = 'A';
		switch (code) { // 대소문자 구분 없이 결과를 처리함
		case 'A':			
		case 'a':
			System.out.println("class-1");
			break;
		
		case 'B':			
		case 'b':
			System.out.println("class-2");
			break;
			
		case 'C':			
		case 'c':
			System.out.println("class-3");
			break;

		default:
			System.out.println("no class");
			break;
		}
	}
}
```

## 배열
동일한 타입의 데이터 여러 개를 저장할 수 있는 자료 구조

```java
public class ArrayTest {
	public static void main(String[] args) {
		// 지역변수의 경우 명시적으로 초기화를 해야 함
		int a = 99;
		System.out.println(a);
		
		// 배열을 생성하면 디폴트 값으로 초기화가 일어남
		// 정수형 배열: 0, 실수형 배열: 0.0, 논리형 배열: false, 참조형 배열: null
		int[] score; // 1. 배열 선언
		//int score[];
		int[] name[], point; // name은 2차원, point는 1차원
		int age[][][];
		//int[] age[][];
		
		score = new int[300]; // 2. 배열 생성, 생성할 때 크기 지정
		score[0] = 90; // 3. 배열 사용
		score[1] = 35;
		score[2] = 78;
		System.out.println(score[1]);
		System.out.println(score[128]); // 0
		System.out.println(score.length); // 배열의 길이: 300
		
		double[] points = new double[99]; // 1-2. 선언과 생성을 동시에
		System.out.println(points[33]); // 0.0
		
		boolean[] flags = new boolean[10]; 
		System.out.println(flags[6]); // false
		
		String[] names = new String[3];
		System.out.println(names[1]); // null
	}
}
```

```java
public class ArrayTest2 {
	public static void main(String[] args) {
		// 배열 선언, 생성, 초기화가 한번에 일어남
		int[] score = {100, 56, 78, 90, 88};
		
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		System.out.println(Arrays.toString(score));
		
		// enhanced loop : 향상된 반복문 for each
		for (int i : score) {
			System.out.println(i);
		}
		
		String[] names = {"tommy", "harry", "jane"};
		for (String s : names) {
			System.out.println(s);
		}
	}
}
```

다차원 배열은 배열 안에 배열이 있는 구조이다. 그래서 2차원 배열 nums의 길이는 2가 된다.
2차원 배열 안에 있는 배열 길이를 구하기 위해서는 `nums[0].length`를 해줘야 3이 나온다.
3차원 `nums = new int[2][3][4];`은 3x4(행x열)짜리 달걀판이 2개 있는거다.
자바에서 배열은 행마다 다른 길이의 다차원 배열 선언이 가능하다! wow~!

```java
public class ArrayTest3 {
	public static void main(String[] args) {
		int[][] nums = new int[2][3];
		System.out.println(nums[1][1]); // 디폴트 값으로 초기화되어 있음
		System.out.println(nums.length); //2
		System.out.println(nums[0].length); //3
		
		int[][] wow = new int[2][]; // 행마다 다른 길이의 배열 선언이 가능함!
		wow[0] = new int[3];
		wow[1] = new int[2];
		
		int[][] score = {
				{1, 2, 3, 4},
				{4, 5, 6, 7, 8, 9},
				{7, 8},
				{10, 11, 12}
		};
		
		for (int i=0; i<score.length; i++) { // 4번 반복, 행
			for (int j=0; j<score[i].length; j++) { // 3번 반복, 열
				System.out.print(score[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==========");
		for (int[] out : score) {
			for (int in : out) {
				System.out.print(in+" ");
			}
			System.out.println();
		}
		
	}
}
```
