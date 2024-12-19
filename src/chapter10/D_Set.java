package chapter10;

/*
    ==== List 인터페이스와 Set 인터페이스 ===
    List 인터페이스 : 중복 가능, 순서 있음, null 포함 가능
    Set 인터페이스 : 중복 불가, 순서 없음, null 포함 가능

    === Set 인터페이스 ===
    : 중복된 요소를 포함하지 안는 객체의 집합
    : 객체의 저장 순서를 저장하지 않는다 (삽입 순서가 유지되지 않는다)
    : null 요소를 포함 가능하다

    === Set 컬렉션 종류 (구현체) ===
    1. HashSet
    : 가장 많이 사용되는 Set 구현체, 빠른 데이터 접근과 삽입을 지원하다
    - 정렬 또는 순서를 보장하지 않는다

    2. LinkedHashSet
    : HashSet에서 순서를 추가한 형태
    - 중복은 안되지만 순서는 있다. 인덱스 번호는 존재하지 않는다. 요소끼리의 접근 요소로 순서가 생긴다.

    3. TreeSet
    : 데이터가 자동 정렬, 중복 제거와 정렬된 순서 유지가 필요할 때 사용한다.
    - 중복은 안되지만 순서는 있다. 특정 차순으로 정렬을 한다.

    === Set 컬렉션의 주요 메서드 ===
    : add(), remove(), contains(), size(), isEmpty()

    Set 컬렉션의 선언 방법
    >> Set<E데이터타입> set명 = new Set컬렉션종류<>();

 */

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {
        Set<String> exampleSet = new HashSet<>();

        exampleSet.add("자바");
        exampleSet.add("파이썬");
        exampleSet.add("C++");
        exampleSet.add("자바스크립트");
        System.out.println(exampleSet);  //[C++, 파이썬, 자바, 자바스크립트] - 순서없음

        exampleSet.remove("자바");
        System.out.println(exampleSet); //[C++, 파이썬, 자바스크립트] - 제거
        System.out.println(exampleSet.size()); //3 - 길이

        exampleSet.add("파이썬");
        System.out.println(exampleSet); //[C++, 파이썬, 자바스크립트] - 중복불가

        System.out.println(exampleSet.contains("자바스크립트")); //true
        System.out.println(exampleSet.contains("자바")); //false - set에서는 부분이 아니라 그자체를 비교한다.

        System.out.println(exampleSet.isEmpty());  //false
        exampleSet.clear();                        //삭제
        System.out.println(exampleSet.isEmpty());  //true

    }
}
