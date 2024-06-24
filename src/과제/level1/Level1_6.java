package 과제.level1;

public class Level1_6 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_6 answer >> \n");

        short value1 = 30000;
        int value2 = 2000000000;
        long value3 = 40000000000L;
        float value4 = 3.123123123F;
        double value5 = 3.123123123;

        byte num1 = (byte)value1;
        short num2 = (short)value2;
        int num3 = (int)value3;
        long num4 = (long)value4;
        float num5 = (float)value5;

        System.out.println("byte <- short : " + num1);
        System.out.println("short <- int : " + num2);
        System.out.println("int <- long : " + num3);
        System.out.println("long <- float : " + num4);
        System.out.println("float <- double : " + num5);



    }
}
