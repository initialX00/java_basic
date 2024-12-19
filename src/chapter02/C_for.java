package chapter02;

public class C_for {
    public static void main(String[] args) {
        /*
            반복문
            특정 조건이 만족될 때까지 동일한 작업을 반복적으로 실행할 때 사용한다

            반복문의 종류
            for, while, do-while
        */

        /*
            for문
            특정 조건이 만족될 때까지 코드 블럭을 반복 실행한다. 횟수가 정해져있는 경우 주로 사용한다.

            for (초기화; 조건; 증감) {
                조건이 만족될 때 실행할 코드
            }

            cf) 초기화: 반복에 사용할 변수, for문 내에서만 유효하다(범위,스코프 내에서만 유효하다)
                조건: 해당 조건이 참인동안 반복문이 실행된다
                증감: 매 반복마다 변수를 증감한다
        */

        for(int num = 1; num <= 5; num++){
            System.out.print(num + " ");
        }
        System.out.println();


        // ===문제===

        //for반복문을 사용하여 1부터 10까지 짝수만 출력
        for(int i = 1; i <= 10; i++){
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //for 반복문을 사용하여 구구단을 출력
        System.out.println("===3단===");
        int num = 3;
        for(int i = 1; i <= 9; i++){
            System.out.print(num + "X" + i + "=" + num * i + " ");
        }
        System.out.println();


        /*
            중첩 반복문
            for () {
                for () {
                }
            }
         */

        System.out.println("===구구단===");
        for (int i = 0; i < 8; i++){
            int dan = i + 2;
            for(int j = 0; j < 9; j++){
                int dadan = j + 1;
                System.out.print(dan + "X" + dadan + "=" + dan * dadan + " ");
            }
            System.out.println();
        }

    }

}
