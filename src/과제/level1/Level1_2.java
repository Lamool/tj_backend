package 과제.level1;

import java.time.LocalDateTime;

public class Level1_2 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_2 answer >> ");

        // 현재 날짜/시간
        LocalDateTime answer = LocalDateTime.now();
        System.out.println(" >> answer time : "+ answer + " >> \n");

        boolean bool1 = true;
        byte byteNum = 100;
        char ch = 'A';
        short shortNum = 30000;
        int intNum = 2000000000;
        long longNum = 40000000000l;
        float floatNum = 3.1231232f;
        double doubleNum = 3.123123123;

        System.out.printf("type \t value \t range \n");
        System.out.printf("--------------------------------------\n");
        System.out.printf("boolean %b", bool1);
        System.out.printf("byte %d", byteNum);
        System.out.printf("char %c", ch);
        System.out.printf("short %d", shortNum);
        System.out.printf("int %d", intNum);
        System.out.printf("long %d", longNum);
        System.out.printf("float %f", floatNum);
        System.out.printf("double %f", doubleNum);

    }

}
