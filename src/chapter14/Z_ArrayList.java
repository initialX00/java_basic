package chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z_ArrayList {
    public static void main(String[] args) {
                /*
            ===배열 & 리스트===
            Array 배열
            : 여러 데이터를 하나의 object로 관리하기 위한 자료 구조를 말한다.
            : 0부터 시작하는 저장순서를 가지며 해당 index 번호를 통해 데이터를 접근한다.
            : 연속된 메모리 공간에 저장된다
            : 배열은 정의와 동시에 길이를 지정해야하며 길이를 바꿀 수 없다.

            List 리스트
            : 순서가 있는 element(요소)의 모임을 말한다.
            : ArrayList, LinkedList 등이 존재한다.
            : Array의 Index번호가 데이터의 식별자 역할을 한다
              List의 Index번호는 데이터의 저장 위치만 확인한다.
            : 불연속적 메모리 공간을 차지한다
            : Array와 달리 동적이다, 배열의 크기가 정해져있지 않다.



            === List.of() 메서드 ===
            : 읽기 전용(불변) 리스트를 생성하는데 사용한다.
            : 수정 불가(추가, 수정, 변경), null값을 포함할 수 없다
            - List<>타입 변수에는 List.of()와 ArrayList를 통해 생성된 불변리스트, 가변리스트 모두 할당 가능하다

             cf)Array.asList()
              : 배열을 리스트로 변환하는 메서드
              List<데이터타입> 객체명 = Arrays.asList()

            new ArrayList<>() / Arrays.asList() / List.of()
            1.구현방식
            new ArrayList<>()는 생성자 방식
            Arrays.asList()는 Arrays 클래스의 asList 메서드
            List.of()는 List 인터페이스의 of 메서드

            2.원소 추가, 삭제 (add, remove)
             O / X / X

            3.원소 수정 (set)
            O / O / X

              cf)Arrays.asList()가 반환하는 리스트는 가짜 ArrayList이다.
                  Arrays 클래스 내부에 구현된 별개의 ArrayList이다 (컬렉션프레임워크가 아니다)
         */

        List<String> immutableList = List.of("사과","바나나","체리","감"); //List.of() 메서드
        //immutableList.add("오렌지"); 추가불가
        //immutableList.remove("사과"); 삭제불가
        //immutableList.set(0,"오렌지"); 수정불가

        List<String> dynamicList = new ArrayList<>(); //ArrayList 클래스
        dynamicList.add("오렌지");
        dynamicList.add("망고");
        System.out.println(dynamicList); //[오렌지, 망고]
        dynamicList.remove("망고");
        System.out.println(dynamicList);  //[오렌지]

        List<String> chageList = new ArrayList<>(immutableList); //List.of를 가변으로 사용
        chageList.add("딸기");
        System.out.println(chageList); //[사과, 바나나, 체리, 감, 딸기]

        List<String> changeList2 = new ArrayList<>();
        changeList2 = List.of("과일1", "과일2");
        //changeList2.add("과일3");


        // Array.asList()
        List<String> asList = Arrays.asList("사과","바나나","키위");
        //asList.add("수박");
    }
}
