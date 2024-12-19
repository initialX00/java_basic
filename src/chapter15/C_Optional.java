package chapter15;

/*
    === Optional 클래스 ===
    : 값이 존재할 수도 있고 없을 수도 있는 객체를 감싸는 컨테이너, 자바 8에서 추가된 기능이다.
    - null값을 다룰 때 발생하는 NullPointerException(NPE) 문제를 줄이고, 명시적으로 값의 유무를 처리하도록 설계한다.

    1. Optional 클래스
    : null이 아닌 값을 포함하거나, 값이 없는 상태를 나타낼 수 있다.
    - 값이 명시적으로 검사하고 처리하는 방식
    - 코드의 안정성과 가독성을 높인다.

    2. Optional 생성방법
     1) .of() 메서드
     : null이 아닌 값을 감싸는 메서드
       null값을 전달하면 NullPointerException(NPE)을 발생시킨다
     2) .ofNullable() 메서드
     : null일 수도 있는 값을 감싸는 메서드
       null값이 들어오면 빈 Optional 객체를 반환한다.
     3) .empty() 메서드
     : 빈 Optional 객체를 생성한다

   3. Optional 주요 메서드
     1) 값이 있는지 확인
       .isPresent() - 있으면 true, 없으면 false
       .isEmpty() - 있으면 false, 없으면 true
     2) 값 가져오기
       .get() - 값이 있을 경우 값 반환, 없을 경우 NoSuchElementException 발생
     3) 기본값 처리
       .orElse() - 값이 없으면 기본값 반환
       .orElseGet() - 값이 없으면 함수형 인터페이스로 값을 생성
       .orElseThrow() - 값이 없으면 예외를 발생
     4)스트림 활용리 가능하다
       : Optional 객체는 스트림으로 변환이 가능하다
     5)Optional 사용 시 주의점
      - 모든 곳에 Optional을 사용할 필요는 없다.
        반환 값에만 사용하는 것을 권장한다.
        필드 & 매개변수로 사용하는걸 권장하지 않는다.
      - 값이 반드시 있어야하는 경우는 Optional 사용을 하지 않는다.
        null 방지에 대한 필수 값은 직접 값을 반환하고 null 여부를 확인한다.

 */

import java.util.Optional;

public class C_Optional {
    public static void main(String[] args) {
        //Optional 생성방법//
        // .of() 메서드
        Optional<String> optional1 = Optional.of("Hello Optional");
        //Optional<String> optional2 = Optional.of(null);

        // .ofNullable() 메서드
        Optional<String> optional3 = Optional.ofNullable(null);

        // .empty() 메서드
        Optional<String> optional4 = Optional.empty();


        //Optional 주요메서드//
        //값확인 -  .isPresent()  .isEmpty()
        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());
        System.out.println(optional3.isPresent());
        System.out.println(optional3.isEmpty());

        //값가져오기 - .get()
        System.out.println(optional1.get());
        //System.out.println(optional3.get()); //값이 없어서 오류발생

        //기본값 처리 - .orElse()  .orElseGet()  .orElseThrow()
        System.out.println(optional3.orElse("기본값"));
        System.out.println(optional3.orElseGet( () -> "발생시키는 값"));
        try{
            System.out.println(optional3.orElseThrow(() -> new Error("비워질 경우 사용자 정의 예외 발생")));
        } catch (Error e) {
            System.out.println("예외 발생");
        }



    }
}
