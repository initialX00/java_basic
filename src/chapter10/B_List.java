package chapter10;

/*
    List 인터페이스
    : 데이터를 "순차적"으로 저장하고 접근하는데 사용하는

    List 특징
    - 요소의 인덱스를 통한 정확한 위치 지정
    - 요소의 중복 허용
    - 다양한 구현체를 통해 사용 가능하다

    === ArrayList와 LinkedList ===
    List의 주요메서드이기때문에 메서드의 사용법은 같다.
    1) ArrayList
     : 내부적으로 배열을 사용하여 요소를 저장한다
     - 빠른 읽기 성능, 느린 삽입 및 삭제 성능을 가진다.
     - 순차적으로 데이터를 관리로 빠른 데이터 조회에 적합하다
     - 중간 삽입 및 삭제 시 데이터 이동이 필요하므로 상대적으로 성능이 저하된다.
     ex) 정렬된 책장
         책의 번호를 아는 경우 해당 책장에서 책을 빠르게 자져올 수 있다.
         새 책을 책장의 중간에 추가하는 경우 뒷책을 모두 한칸씩 옮겨야하므로 시간이 오래 걸린다

     2) LinkedList
      : 내부적으로 이중연결 리스트를 사용하여 요소를 저장한다
      : 빠른 삽입 및 삭제 성능, 느린 데이터 접근 성능을 가진다.
      - 연결 기반 데이터 관리로 비순차적 데이터 작업에 적합하다
      - 특정 요소 접근 시 순차 탐색이 필요하므로 성능이 저하됩니다.
      ex) 도서 대출 리스트
         새로운 대출 기록을 추가하거나 기존 기록을 제거하는 것이 용이하다
         옆의 요소와 연결만 변경하면 추가 및 삭제가 가능하다.
         특정 날짜와 대출 기록을 찾으려면 처음부터 하나씩 기록을 읽어야하므로 시간이 오래 걸린다


    cf)length : 배열의 길이 알려 할 때
       length() : 문자열의 길이를 알려 할 때
       size() : Collection, 자료구조의 크기를 알려 할 때

    cf)클래스 구조에는 객체 타입의 데이터만 삽입 가능하다
       - 기본 데이터 타입 : int, char, boolean 불가
       - 객체 형식 타입 : integer, Character, Boolean 가능
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class B_List {
    public static void main(String[] args) {
        //1.ArrayList
        System.out.println("=== ArrayList 에제 ===");
        //cf)ArrayList 클래스는 AbstractList를 상속받는다
        //   AbstractList 추상클래스는 List 인터페이스를 구현한다.
        ArrayList<String> arrayList = new ArrayList<>();
        //데이터추가 - 느림
        arrayList.add("Java");
        arrayList.add(0,"Python"); //원하는 인덱스에 요소 추가
        arrayList.add("JavaScript");
        System.out.println(arrayList); //[Python, Java, JavaScript]
        //데이터 읽기 - 빠름
        String firstElement = arrayList.get(0);
        System.out.println(firstElement); //Python
        //데이터 수정 - 빠름
        arrayList.set(2, "TypeScript");
        System.out.println(arrayList); //[Python, Java, TypeScript]
        //데이터 삭제 - 느림
        String removedElement = arrayList.remove(1);
        System.out.println(arrayList); //[Python, TypeScript]
        //리스트 크기
        System.out.println(arrayList.size()); //2
        //리스트 비우기
        arrayList.clear();
        System.out.println(arrayList); //[]

        //length : 배열의 길이 알려 할 때
        //length() : 문자열의 길이를 알려 할 때
        //size() : Collection, 자료구조의 크기를 알려 할 때


        //2.LinkedList
        System.out.println("=== LinkedList ====");
        LinkedList<String> linkedList = new LinkedList<>();
        //데이터 추가
        linkedList.add("Apple");
        linkedList.add("Orange");
        linkedList.add("Mango");
        linkedList.add(1, "Banana");
        System.out.println(linkedList);  //[Apple, Banana, Orange, Mango]
        //데이터 읽기
        String secondFruit = linkedList.get(1);
        System.out.println(secondFruit);  //Banana
        //데이터 포함 여부 확인
        System.out.println("리스트에 Orange 포함됐나? : " + linkedList.contains("Orange"));  //true
        System.out.println("리스트에 Strawberry 포함됐나? : " + linkedList.contains("Strawberry"));  //false
        //데이터 삭제
        linkedList.clear();
        System.out.println(linkedList);  //[]



        //=== ArrayList와 LinkedList 성능 비교 ===
        System.out.println("=== ArrayList와 LinkedList 성능 비교 ===");
        ArrayList<Integer> arrayListTest = new ArrayList<>();
        //: 클래스 구조에는 객체 타입의 데이터만 삽입 가능하다
        //- 기본 데이터 타입 : int, char, boolean 불가
        //- 객체 형식 타입 : integer, Character, Boolean 가능

        long startTime = System.nanoTime(); //시간을 나노초 단위로 변환
        for(int i = 0; i < 100000; i++){
            arrayListTest.add(0,i); //항상 맨압에 삽입
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList 삽입 시간 : " + (endTime - startTime) + "[ns]"); //3억 나노초



        LinkedList<Integer> linkedListTest = new LinkedList<>();
        startTime = System.nanoTime(); //시간을 나노초 단위로 변환
        for(int i = 0; i < 100000; i++){
            linkedListTest.add(0,i); //항상 맨압에 삽입
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 삽입 시간 :  " + (endTime - startTime) + "[ns]"); //3백만 나노초

    }
}
