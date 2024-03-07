package doit.reference;

public class 자바에서의형변환 {
    public static void main(String[] args) {
        // String형 -> 숫자형
        String sNum = "1234";

        int i1 = Integer.parseInt(sNum);
        int i2 = Integer.valueOf(sNum);

        double d1 = Double.parseDouble(sNum);
        double d2 = Double.valueOf(sNum);

        float f1 = Float.parseFloat(sNum);
        float f2 = Float.valueOf(sNum);

        long l1 = Long.parseLong(sNum);
        long l2 = Long.valueOf(sNum);

        short s1 = Short.parseShort(sNum);
        short s2 = Short.valueOf(sNum);

        // 숫자형 -> String형
        int i = 1234;
        String i3 = String.valueOf(i);
        String i4 = Integer.toString(i);

        double d = 1.23;
        String d3 = String.valueOf(d);
        String d4 = Double.toString(d);

        float f = 1.23f;
        String f3 = String.valueOf(f);
        String f4 = Float.toString(f);

        long l = 1234L;
        String l3 = String.valueOf(l);
        String l4 = Long.toString(l);

        short s = 1234;
        String s3 = String.valueOf(s);
        String s4 = Short.toString(s);
    }
}
