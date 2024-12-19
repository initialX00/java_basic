package chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {
        /*
            1.점수에 따른 학점 출력 (if문 사용)
            사용자로부터 점수를 입력받아 아래 기준에 따라 학점을 출력
            90이상: A
            80이상: B
            70이상: C
            60이상: D
            그 외: F
            0미만 또는 100초과인 경우 : 유효하지 않은 값이라고 출력

            2.삼각형 모양의 별(*)출력 (중첩for문)
            1)
            *
            **
            ***
            ****
            *****
            2)
                *
               **
              ***
             ****
            *****
         */

        //1번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("성적을 입력하세요 >> ");
        int score = sc.nextInt();
        if(score < 0 || score > 100){  //예외 범주 처리
            System.out.println("유효하지 않은 값입니다");
        } else if(score >= 90){  //성적 처리
            System.out.println("학점 A");
        } else if(score >= 80){
            System.out.println("학점 B");
        } else if (score >= 70) {
            System.out.println("학점 C");
        } else if(score >= 60){
            System.out.println("학점 D");
        } else{
            System.out.println("학점 F");
        }
        


        //2-1 문제
        for(int i = 1; i <= 5; i++){ //줄 갯수
            for(int j = 1; j <= i; j++){ //별 갯수
                System.out.print("*");
            }
            System.out.println();
        }

        //2-2 문제
        for(int i = 1; i <= 5; i++){ //줄 갯수
            for(int j = 1; j <= 5-i; j++){ //공백 갯수
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){ //별 갯수
                System.out.print("*");
            }
            System.out.println();
        }



        //괄호 요약형식
        if(score < 0 || score > 100) System.out.println("유효하지 않은 값입니다");
        else if(score >= 90) System.out.println("학점 A");
        else if(score >= 80) System.out.println("학점 B");
        else if (score >= 70) System.out.println("학점 C");
        else if(score >= 60) System.out.println("학점 D");
        else System.out.println("학점 F");
        sc.close();
        
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
        
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5-i; j++) System.out.print(" ");
            for(int k = 1; k <= i; k++) System.out.print("*");
            System.out.println();
        }


    }
}
