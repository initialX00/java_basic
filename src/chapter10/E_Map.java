package chapter10;

/*
    === Map 인터페이스 ===
    : 키(key)와 값(value)의 쌍으로 용소를 저장하는 데이터 구조
    - 키는 고유한 데이터를 가진다 (중복 키 불가)
    - 동일한 키값에 서로 다른 값을 전달하는 경우 기존 값이 새로운 값으로 덮어씌워진다
    - 서로 다른 키에서 동일한 값 저장은 가능하다.
    - 키의 유일성, 값의 중복성, 순서보장이 되지 않는다.
      단 LinkedHashMap은 순서를 보장한다.
    - 키를 기반으로 빠른 검색이 가능하다.
    ex) name : "김씨"가 존재한 상태에서 name : "이씨"을 추가하는 경우 name의 키에는 "이씨"만이 존재한다.

    === Map 인터페이스 종류 (구현체) ===
    1. HashMap
    : 가장 많이 사용되는 Map 구현체
    : 키와 값에 null을 허용한다
    - 빠른 검색 및 삽입 성능을 제공한다.
    - 순서 유지는 보장하지 않는다.

    2. LinkedHashMap
    : HashMap + 삽입 순서 유지
    - 삽입 순서가 중요하고 빠른 검색이 중요할때 쓰인다

    3. TreeMap
    : 키에 따라 자동 정렬 기능을 보장한다.
    - 키에 null을 허용하지 않는다.

    === Map 인터페이스 메서드 ===
    put(key, value) : 키와 값을 Map에 추가한다
    get(Object key) : 지정된 키에 매핑된 '값'을 반환한다
    remove(Object key) : 주어진 키와 연관되니 '키-값' 쌍을 삭제한다 (반환)
    containsKey(Object Key) : 주어진 키가 Map에 있는 지 확인 후 boolearn값으로 반환한다.

    keySet() : Map의 키를 Set으로 반환한다
    values() : Map의 값을 List로 반환한다
               Collection의 경우 켈럭션 프레임워크들의 상위 집합이다.
    entrySet() : Map의 키-값 쌍을 나타내는 Set을 반환한다.

    === Map 컬렉셔 선언 방법 ===
    Map<키타입, 값타입> 인스턴스명 = new Map종류<>();

 */

import java.util.*;

public class E_Map {
    public static void main(String[] args) {

        //Map 컬렉션 선언
        Map<String, Integer> students = new HashMap<>();

        students.put("이씨",50); //이름(키),나이(값);
        students.put("김씨",60);
        students.put("서씨",70);
        System.out.println(students); //{서씨=70, 이씨=50, 김씨=60}
        //순서를 보장하지 않고, {}중괄호 형식, 키와 값을 =로 구분한다

        System.out.println(students.get("이씨")); //50
        students.remove("이씨");
        System.out.println(students); //{서씨=70, 김씨=60}
        System.out.println(students.containsKey("김씨"));  //true
        System.out.println(students.containsKey("최씨"));  //false
        System.out.println(students.size()); //2

        System.out.println(students.keySet()); //[서씨, 김씨]
        System.out.println(students.values());  //[70, 60]


        Set<String> names = students.keySet();
        Collection<Integer> ages = students.values();
        //Collection을 List로 변환
        //: List 인터페이스의 구현체로 변환
        List<Integer> listAges = new ArrayList<>(ages);

    }
}
