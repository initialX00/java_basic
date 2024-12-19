package chapter02;

import java.util.Scanner;

public class A_If {
    public static void main(String[] args) {
        /*
            제어문: 조건문(Condition), 반복문(Loop)
         */

        /*
            조건문: 프로그램의 흐름을 제어할 수 있는 식.
            조건문의 종류
            1. if, else, else if
            2. switch, case, default
            + continue, break
         */

        /*
            if문
            if(조건식){
                조건이 참일 떄 실행 코드
            } else if(조건식) {
                if 거짓, else if 참일 때 실행 코드
            } else {
                if 거짓, else if 거짓일 때 실행 코드
            }
            (else의 경우 생략할 수 있다.)
         */

        //들여쓰기 : tap
        //내어쓰기 : shift + tap
        int age = 10;
        if (age > 19) {
            System.out.println("성인입니다");
        } else if (age > 13) {
            System.out.println("청소년입니다");
        } else {
            System.out.println("미성년자입니다");
        }
        //실행될 코드 블럭에 코드가 하나의 구문이라면 { } 생략 가능하다.(하나의 세미콜론으로 묶인다면 생략가능)
        if(age > 19) System.out.println("주류");
        else if (age > 15) System.out.println("탄산");
        else System.out.println("쥬스");

        /*
            ==조건문 문제==
            함수 위치 구하기
            1.스캐너를 사용하여 x,y 변수에 데이터를 저장
            2.(x,y)좌표가 제 1,2,3,4 사분면 중 어느 위치에 있는지 조건문으로 검사
            각 분기의 위치일 경우 functionScope 변수에 몇 사분면인지 할당한다
            ex) functionScope = "제1사분면"
            조건문 이행 완료시
            "결과: " + functionScope 출력
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("x좌표입력 >> ");
        int x = sc.nextInt();
        System.out.print("y좌표입력 >> ");
        int y = sc.nextInt();
        String functionScope = null;

        if(x >= 0 && y >= 0) {
            functionScope = "제1사분면";
        } else if(x <= 0 && y >= 0) {
            functionScope = "제2사분면";
        } else if(x <= 0 && y <= 0) {
            functionScope = "제3사분면";
        } else {
            functionScope = "제4사분면";
        }

        System.out.println("결과: " + functionScope);

        sc.close(); //스캐너 종료 까먹지 말기

    }
}
