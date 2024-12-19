package chapter02;

import java.util.Scanner;

public class D_While {
    public static void main(String[] args) {
        //줄 번호 옆 우클릭 -> soft wrap
        //or settings -> edit -> general -> soft wrap these files 체크 후 * 입력
        //화면에 글이 넘어갈 경우 자동으로 줄 바꿈처리

        /*
            while문
            일반적으로 반복 횟수가 지정되지 않았을 때 사용한다
            조건을 검사하고 해당 조건이 true인 경우 코드 블록을 실행한다.
            조건에 true를 작성할 경우 무한 루프한다.

            변수 초기화;
            while (조건) {
                조건이 참일 때 실행
                증감연산자;
            }

            무한반복될 때 'ctrl + f2' or '중단버튼'으로 멈춘다.
         */

        int num = 1;
        while(num <= 5) {
            System.out.print(num + " ");
            num++;
        }
        System.out.println();


        /*
            continue와 break문
            while문에서 아래코드를 무시하고 다시 반복할 때 continue;
            while문 코드블럭을 중단할 때 break;
         */

        //0부터 20까지 정수 중에서 홀수만 출력하시오
        int number = 0;
        while(true){
            if(number == 20){
                break;
            }
            if(number % 2 == 0){
                number++;
                continue;
            }
            System.out.print(number + " ");
            number++;
        }
        System.out.println();


        /*
            do while문
            while문과 비슷하지만 조건이 맞지 않더라도 최소 한번은 반드시 실행된다.
            사용자 입력값을 반복적으로 받아 조건에 맞는 값을 처리할 때 유용하다.

            초기화;
            do {
                실행할 코드
                증감연산자;
            } while (조건);
         */

        //1부터 5까지 반복
        int n = 1;
        do{
            System.out.println(n);
            n++;
        } while(n <= 5);


        //특정 값을 받을 때까지 반복
        Scanner sc = new Scanner(System.in);
        int n2;
        do{
            System.out.print("1부터 10 사이의 숫자를 입력하시오 >> ");
            n2 = sc.nextInt();
        } while(n2 < 1 || n2 > 10);
        System.out.println("입력한 숫자는 " + n2);
        sc.close();

        //동일한 입력공간(System.in)을 여러번 여는 경우
        //표준 입력 스트림을 닫고 재실행 할 때 에러가 발생한다
        //운영체제 자원의 스트림이기때문에 한 번 닫으면 다시 열 수 없다.



    }
}
