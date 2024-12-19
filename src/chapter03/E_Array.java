package chapter03;

import java.util.ArrayList;

public class E_Array {
    public static void main(String[] args) {
        /*
            크기 10의 ArrayList를 생성하여
            1 ~ 10까지의 숫자를 추가한 뒤 출력하시오.
            단, 반복문을 사용하여 오름차순으로 정렬하시오.

            추가한 숫자 중 홀수만 제거하고 출력하시오.

            인덱스 3에 값 50을 삽입한 뒤 결과를 출력하시오.

         */

        //크기 10으로 생성
        ArrayList<Integer> list = new ArrayList<>(10);

        //1~10 추가
        for(int i = 0; i < 10; i++){ //null 상태일때는 축약하므로 .size()로는 크기가 없다
            list.add(i + 1);
        }
        System.out.println("원본 리스트 : " + list); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        //홀수 제거 /////// 증감 연산자 중요
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 != 0){
                list.remove(i);
                i--;  //사이즈가 변경됨에 따라 인덱스 번호를 리셋하여 다시 반복한다.
                      //연속된 제거요소에 관해 인덱스 조정이 없을 경우 제거되지 않고 건너뛰게 된다.
                      //감소하지 않을 경우 [1,3,5,7,8,9,10]처럼 홀수가 연속되면 3과 7이 제거되지 않는다.
            }
        }
        //괄호 요약
        // for(int i = 0; i < list.size(); i++) if(list.get(i) % 2 == 0) list.remove(i);
        System.out.println("홀수 제거 : " + list); //[2, 4, 6, 8, 10]

        //데이터 삽입
        list.add(3, 50);
        System.out.println("데이터 삽입 : " + list); //[2, 4, 6, 50, 8, 10]
    }
}
