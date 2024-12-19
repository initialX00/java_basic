package chapter01;

public class C_Conversion {
    public static void main(String[] args) {
        /*
            자바 형 변환 (Type Conversion)
            : 하나의 타입을 다른 다입으로 바꾸는것
            
            자료형의 크기에 따른 변환 규칙
            byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
            - 메모리 설계 상 정수 타입보다 실수 타입이 더 크다.
            char(2)
            boolean(1)
         */

        //    1. 자동 형 변환 (묵시적)
        //    : 크기가 큰 자료형으로 변환
        byte smallBox = 10; //1byte
        int bigBox = 10000; //4byte
        //  작은 범위의 타입을 큰 타입에 넣을 떄는 컴파일러가 자동으로 형 변환을 수행한다
        bigBox = smallBox;

        byte a = 32;
        short b = a;
        int c = b;
        long d = c;

        float e = d;
        //char f = e; //묵시적 형 변환 안됨

            
        //    2. 강제 형 변환 (명시적)
        //    : 크기가 작은 자료형으로 변환
        int number = 1234;
        float fNumber = number;

        float fNumber2 = 1234.123F;
        //  강제 형 변환 방법: (작은자료형타입) 큰데이터값;
        int number2 = (int) fNumber2;
        System.out.println(number2);

        //cf. 참조라는 뜻
        //char 자료형의 형 변환
        char a1 = 'a'; //a
        char a2 = 97; //a
        char a3 = '\u0061'; //a

        //줄복사 단축키 : ctrl + alt + 방향키
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        char example = '가';
        System.out.println((int)example); //44032
        System.out.println((int)example + 1); //44033
        System.out.println((char)((int)example + 1)); //각


        //char 자료형은 음수 표현식이 없다
        long longType = 123456;
        int intType = (int)longType;
        short shortType =(short)intType;
        char charType = (char)shortType;
        System.out.println(charType); //

    }
}
