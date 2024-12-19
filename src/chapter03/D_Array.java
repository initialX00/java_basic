package chapter03;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class D_Array {
    public static void main(String[] args) {
        /*
            자바의 기본 배열 형태
            : 한 번 생성되면 크기 변경이 불가하다.
              크기 변경 시 새로운 배열을 생성하여 원래 배열 요소를 복사해야한다.

            동적 배열 (ArrayList)의 개념
            1.ArrayList란
            : java의 동적 배열 구현체이다.
            - 크기 제한 없이 동적으로 요소를 추가/삭제가 가능하다
            >> Java Collection Framework의 일부인 'java.util.ArrayList'에서 제공한다

            2.ArrayList 장점
            - 동적 크기, 유연성, 다양한 메서드를 제공한다.

            3.ArrayList 주의사항
            - 일반 배열의 경우 int[] 배열명 = new int[크기];로 선언하지만 ArrayList는 아니다.
            - ArrayList의 경우 기본 데이터 타입(int, char 등) 사용이 불가하고,
              참조형 데이터 타입만 가능하다.
              String
              int >> Integer
              char >> Character
              boolean >> Boolean
            - 참조형 데이터 타입의 기본 값은 모두 null이다.
              cf) null : 아무런 객체도 참조하지 않음을 나타낸다.(기본 데이터 타입에서는 사용하지 않는다)


            동적 배열 (ArrayList)의 사용법
            1.ArrayList 생성
             >> ArrayList<데이터 타입> 변수명 = new ArrayList<>(초기용량);
             - 일반 배열과 달리 초기용량을 지정하지 않아도 되며, 크기 변경이 자유롭다.
             - 초기 용량 미설정 시 기본값 10이지만, null일 때는 축약하여 크기가 없다.

            2.ArrayList 데이터 추가
             : 배열의 마지막에 값을 추가한다.
             >> 배열명.add(추가할 데이터)

            3.ArrayList 데이터 변경
             >> 배열명.set(인덱스 번호, 변경할 데이터)

            4.ArrayList 데이터 제거
             >> 배열명.remove(인덱스 번호)
             - 안정성을 위해, 반복문 사용 시 배열의 크기가 변경됨에 따라 증감연산자를 통해 반복문을 리셋해준다.
               for(int i = 0; i < list.size(); i++){
                    if(list.get(i) % 2 != 0){
                        list.remove(i);
                        i--;  //사이즈가 변경됨에 따라 인덱스 번호를 리셋하여 다시 반복한다.
                             //연속된 제거요소에 관해 인덱스 조정이 없을 경우 제거되지 않고 건너뛰게 된다.
                    }
                }

            5.ArrayList 크기 확인
             >> 배열명.size();

            6.ArrayList 데이터 삽입
             >> 배열명.add(인덱스 번호, 변경할 데이터)
             - 해당 인덱스의 기존 데이터를 뒤로 밀어내고 삽입한만큼 용량이 커진다.

            7.ArrayList 요소 접근
             >> 배열명.get(인덱스 번호)

         */

        //참조형 데이터의 기본값 null
        Integer a = null;
        //int b = null; //참조형 데이터 타입이 아닌 기본 데이터 타입은 사용 불가

        //ArrayList 생성
        //int[] numbers = new int[];  //일반 배열은 크기를 지정하지 않으면 오류가 난다.
        ArrayList<Integer> arrayList = new ArrayList<>(); //초기 용량 미설정 시 기본값 10
        System.out.println(arrayList); //[]
        //ArrayList 데이터 추가
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println(arrayList); //[10, 20, 30]
        //ArrayList 데이터 변경
        arrayList.set(1, 50);
        System.out.println(arrayList); //[10, 50, 30]
        //ArrayList 데이터 제거
        arrayList.remove(2);
        System.out.println(arrayList); //[10, 50]
        //ArrayList 크기 확인
        System.out.println(arrayList.size()); //2
        //ArrayList 데이터 삽입
        arrayList.add(1,123);
        System.out.println(arrayList); //[10, 123, 50]
        //ArrayList 접근
        System.out.println(arrayList.get(1)); //123

    }
}
