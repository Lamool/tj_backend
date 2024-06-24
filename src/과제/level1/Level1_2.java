package 과제.level1;

import java.time.LocalDateTime;

public class Level1_2 {
    public static void main(String[] args) {
        System.out.println(" >> Level1_2 answer >> ");

        // 현재 날짜/시간
        LocalDateTime time = LocalDateTime.now();
        System.out.println(" >> answer time : "+ time + " >> \n");

        boolean bool1 = true;
        byte byteNum = 100;
        char ch = 'A';
        short shortNum = 30000;
        int intNum = 2000000000;
        long longNum = 40000000000l;
        float floatNum = 3.1231232f;
        double doubleNum = 3.123123123;

        System.out.printf("%s %25s %39s \n", "type", "value", "range");
        System.out.printf("----------------------------------------------------------------------\n");
        System.out.printf("boolean  %21b    %36s \n", bool1,     "true or false");
        System.out.printf("byte     %21d    %36s \n", byteNum,   "-128 ~ 127");
        System.out.printf("char     %21c    %36s \n", ch,        "0~65535[ character 1 ]");
        System.out.printf("short    %21d    %36s \n", shortNum,  "-32768 ~ 32767");
        System.out.printf("int      %21d    %36s \n", intNum,    "-+2000 million");
        System.out.printf("long     %21d    %36s \n", longNum,   "-+2000 million Excess");
        System.out.printf("float    %21.3f  %38s \n", floatNum,  "8 decimal places");
        System.out.printf("double   %21.8f  %38s \n", doubleNum, "17 decimal places");

    }

}
