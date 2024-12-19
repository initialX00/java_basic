package chapter15;

/*
    === 스트림 API ===
    1.스트림 생성
      .stream() 메서드 사용

    2.중간(가공) 절차
      map(Function)
      filter(Predication)
      sorted(Comparator)

    3.최종(결과) 절차
      collect
      forEach


    === 자바에서 배열과 리스트의 정렬 ===
    1.배열(Arrays 클래스) 정렬
    1)오름차순
    : Arrays클래스에서 제공하는 정적 메서드 사용
    >> Arrays.sort()
    - 오름차순 정렬만 지원한다. int값 반환
    2)내림차순
    : Comparator 클래스 내의 reverseOrder() 정적 메서드를 사용한다.
    Collections.reverseOrder()는 Comparator<T>를 반환하는 메서드이다
    객체를 반환한다. 객체 간의 비교를 실시한다. 기본 데이터 타입에 대한 비교가 아니라 객체 타입에 대한 비교를 한다.

    2.리스트(List 클래스) 정렬
    : Collections.sort() 또는 List 클래스의 sort() 메서드를 사용한다.


    ===Comparator 클래스 사용 정렬===



    === 람다식 사용 ==

 */


import java.util.*;
import java.util.stream.Collectors;

public class A_sort {
    public static void main(String[] args) {
        //1. 배열 정렬
        //1) 오름차순 정렬
        int[] numbers = {5,4,1,2,3};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); //[1, 2, 3, 4, 5]

        //2) 내림차순 정렬
        //Comparator 클래스 내의 reverseOrder() 정적 메서드를 사용한다
        Integer[] numbers2 = {8,2,1,5,3};
        Arrays.sort(numbers2, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbers2)); //[8, 5, 3, 2, 1]

        //2. 리스트 정렬
        //1) 오름차순 >> Arrays.sort()
        List<Integer> numbers3 = new ArrayList<>(List.of(5,9,3,4,1));
        Collections.sort(numbers3);
        System.out.println(numbers3); //[1, 3, 4, 5, 9]
        //2) 내림차순
        Collections.sort(numbers3, Collections.reverseOrder());
        System.out.println(numbers3); //[9, 5, 4, 3, 1]


        //===Comparator 클래스 사용 정렬===
        List<String> names = new ArrayList<>(List.of("Tom","Jerry","Pororo", "Ruffy"));
        //문자열 길이 기준 정렬
        //순회)name -> name.length == String::length
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names); //[Tom, Jerry, Ruffy, Pororo]


        //=== 람다식 사용 ==
        List<String> names2 = new ArrayList<>(List.of("Pororo","Jerry","Tom", "Ruffy"));
        names2.sort((a,b) -> b.length() - a.length()); //문자열 길이 내림차순으로 정렬
        System.out.println(names2); //[Pororo, Jerry, Ruffy, Tom]
        //.sort() 메서드
        //: List 인터페이스의 메서드
        //  리스트를 특정 기준에 따라 정렬한다
        //  정렬 기준을 결정하는 Comparator(두 객체를 비교하여 정렬 순서를 결정)를 인수로 받는다
        //  내림차순 >> (a,b) -> b.length() - a.length()
        //    a와 b는 리스트의 두 요소를 나타낸다. 두 요소를 비교한 결과 값을 반환한다.
        //    반환값이 양수면 b가 a보다 앞에 온다. 반환값이 0이면 순서 변경이 일어나지 않는다. 반환값이 음수면 a가 b보다 앞에 온다.
        // 오름차순 >> (a,b) -> a.length() - b.length()


        //==스트림 API 사용 정렬==
        //: 정렬된 결과를 새로운 리스트로 받는다
        //1)오름차순
        List<Integer> listNumabers = new ArrayList<>(List.of(8,3,5,1,4));
        List<Integer> sorted = listNumabers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted); //[1, 3, 4, 5, 8]

        //2)내림차순
        List<Integer> reverseSorted = sorted.stream()
                .sorted((a,b) -> b - a)
                .collect(Collectors.toList());
        System.out.println(reverseSorted); //[8, 5, 4, 3, 1]

        //문자열 정렬
        List<String> characterNames = new ArrayList<>(List.of("Pororo", "Jerry", "Tom", "Ruffy"));
        List<String> sortedCharacter =  characterNames.stream()
                .sorted((n1,n2) -> n1.length() - n2.length())
                .collect(Collectors.toList());
        System.out.println(sortedCharacter); //[Tom, Jerry, Ruffy, Pororo]


        //==Comparator 클래스===
        //: 사용자 정의 정렬 정의 시 유용한 인터페이스
        //- 람다식 & 메서드 참조와 함께 사용
        List<String> fruits = new ArrayList<>(List.of("banana","strawberry","mango","kiwi","apple"));

        fruits.sort(Comparator.comparingInt(String::length)
                //String클래스의 compareTo 메서드
                //: 두 개의 문자열 값을 비교하여 int값으로 반환해주는 함수
                .thenComparing(String::compareTo));
        System.out.println(fruits); //[kiwi, apple, mango, banana, strawberry]
    }
}
