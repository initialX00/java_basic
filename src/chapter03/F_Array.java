package chapter03;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class F_Array {
    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<>();

        items.add("사과");
        items.add("연필");
        items.add("노트북");
        items.add("시계");
        items.add("텀블러");

        /*
            난수 생성 기능
            Random 랜덤명 = new Random();
            랜덤명.nextInt(숫자값)
            0이상 해당 숫자미만의 정수가 생성
         */
        Random random = new Random();  // 난수 선언
        int index = random.nextInt(items.size()); // 난수 생성
        String selectedItem = items.get(index); // 난수에 해당하는 배열 선택

        Scanner sc = new Scanner(System.in);
        String userGuess;
        while(true){
            System.out.println("아이템을 맞춰보세요");
            userGuess = sc.nextLine();

        /*
            비교문
            두 문자열을 비교하여 boolean값으로 반환
            >> 문자열A.equals(문자열B)
         */
            if(userGuess.equals(selectedItem)){
                System.out.println("정답입니다");
                break;
            } else if (userGuess.equals("종료")){
                break;
            } else {
                System.out.println("틀렸습니다. 다시 시도해주세요");
            }
        }
        sc.close();
        System.out.println("종료되었습니다");


    }
}
