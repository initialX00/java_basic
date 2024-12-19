package chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        /*
            switch조건문

            특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정한다.
            비교할 변수와 case값을 비교하여 같은 값일 경우, 해당 블록부터 끝까지 실행한다.
            break 키워드로 switch문이 종료된다.

            switch(조건 변수){
                case 조건값1:
                    실행 문장;
                    break;
                case 조건값2:
                    실행 문장;
                case 조건값3:
                    실행 문장;
                default:
                    실행 문장;
                (default의 경우 생략할 수 있다)
            }
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Chapter를 선택하세요 >> ");
        int chapter = sc.nextInt();

        switch(chapter){
            case 1:
                System.out.println("자바 기본 문법");
                break;
            case 2:
                System.out.println("자바 제어문");
                break;
            case 3:
                System.out.println("자바 배열");
                break;
            default:
                System.out.println("해당 챕터는 없습니다");
        }
        
        sc.nextLine(); // nextInt()의 개행 문자 처리

        System.out.print("과일을 입력하세요 >> ");
        String fruit = sc.nextLine();
        switch(fruit){
            case "banana":
                System.out.println("바나나는 노랗다");
                break;
            case "strawberry":
                System.out.println("딸기는 빨갛다");
                break;
            case "grape":
                System.out.println("포도는 보랗다");
                break;
            default:
                System.out.println("해당 과일은 없습니다");
        }
        
        sc.close(); // 종료 까먹지 말기

    }
}
