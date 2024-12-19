package chapter14.review;

/*
    === 람다 표현식(Lambda Expression) ====
    : 자바 8에서 도입된 함수형 프로그래밍 스타일의 표현식
    - 익명 클래스를 간결하게 표현한다
    주로 @FunctionalInterface(하나의 추상 메서드만 가지는 인터페이스)와 함께 사용한다.

    1.람다 사용 방법
    (매개변수) -> {실행 코드}

    2.예시
      1)매개변수, 반환값이 모두 없는 람다
        () -> System.out.println("Hello, Lambda");
      2)매개변수가 하나인 람다 (매개변수 자리의 괄호 생략가능)
        x -> x * x;
      3)매개변수가 두개 이상인 람다
        (a,b) ->  a + b;
      4)실행문이 두줄 이상인 람다
       : 두줄 이상인 경우 return키워드를 사용하여 값을 반환해야한다.
        () -> {
                System.out.println("Hello, Lambda");
                return "Hello";
        }


      3.함수형 인터페이스
       1) Predicate<T>: boolean test<T t>
         - 주어진 조건을 테스트
         - String API와 결합되어 쓰인다.
       2) Function<T, R>: R apply(T t)
         - 입력값(T)을 다른 타입(R)으로 변환
       3) Consumer<T>: void accept(T t)
         - 입력값을 소비
       4) Supplier<T>: T get()
         - 값을 반환


      4.메서드 참조
      : 함수형 인터페이스를 간결하게 표현해준다
      - :: 연산자를 사용하여 기존 메서드를 참조한다
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class B_Lambda {
    public static void main(String[] args) {
//        (int x, int y) -> x + y;  //1번예
//        () -> System.out.println("Hello, Lambda"); //2번예
//        (String s) -> {  //3번예
//            System.out.println(s);
//            return s.length();
//        }

        //람다식 사용 예시
        List<String> list = Arrays.asList("apple","orange","banana");
        //.sort() : List를 정렬하는 메서드
        //a.compareTo(b) : a와 b 값을 비교하여 같은 경우 0을 반환한다.
        //              포함되어있을 경우 오름차순 정렬은 양수, 내림차순 정렬은 음수를 반환한다.
        list.sort((a,b) -> a.compareTo(b));
        System.out.println(list); //[apple, banana, orange]

        //함수형 인터페이스
        Function<String, Integer> fx = s -> s.length();
        Function<String, String> fx2 = s -> s.toUpperCase();
        Integer result = fx.apply("abcde");
        System.out.println(result); //5
        String result2 = fx2.apply("abcde");
        System.out.println(result2); //ABCDE

        Function<String, Integer> fx3 = s -> Integer.parseInt(s);
        Integer fx3Result = fx3.apply("10");
        System.out.println(fx3Result); //10

        Integer data = fx3
                .andThen(result4 -> result4 + 100)
                .apply("10");
        System.out.println(data); //110


        Predicate<Integer> even = n -> n % 2 == 0;
        System.out.println(even.test(10));  //true
        System.out.println(even.test(11));  //false


        //메서드 참조//
        List<String> names = Arrays.asList("이씨","김씨","박씨");
        //일반람다식
        System.out.println("일반람다식");
        names.forEach(name -> System.out.println(name));
        //메서드참조
        System.out.println("메소드 참조");
        names.forEach(System.out::println);

    }
}
