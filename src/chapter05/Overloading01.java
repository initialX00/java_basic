package chapter05;

/*
    === 용어 정리 ===
    클래스, 객체, 인스턴스
    필드(속성): 인스턴스 변수, 정적클래스 변수
    cf) 메서드에는 지역변수가 있다
    메서드: 인스턴스 메서드, 정적클래스 메서드
    생성자


    == (메서드) 오버로딩 ===
    : overloading, 중복 정의
    : 한 클래스 내에서 같은 이름의 '메서드'를 여러개 정의하는 것

    1.오버로딩의 성립 조건
    - 메서드 이름이 동일해야한다
    - 단, 매개변수의 개수 또는 타입이 달라야한다
    - 반환타입은 오버로딩 성립에 영향이 없다.

    2.오버로딩의 장점
    - 사용자가 메서드의 매개변수 순서를 외우지 않아도 사용가능하다.
    - 작업의 본질이 동일한 메서드를 하나의 이름으로 그룹화 가능하다.
      ( 코드의 재사용성 및 가독성이 향상된다. )
    - 컴파일 시 타입 체크가 강화된다.
      ( 올바른 매개 변수를 가진 메서드를 자동 선택된다. )

    3.오버로딩의 단점
    - 중복적으로 의미없이 생성하는 경우, 실질적으로 필요한 구현 메서드를 찾기 어렵다
      ( 복잡성 증가 )

 */

class Calc {
    int a, b, c, d;
    double x, y;

    int add(int a, int b) {
        return a + b;
    }

    //변수 차이 여부와 반환타입의 차이 여부는 오버로딩과 관련없다.
    //반드시 매개변수의 개수 또는 타입이 달라야한다.
//    long add(int c, int d){
//        return c + d;
//    }

    //매개변수의 데이터타입 차이
    double add(double x, double y) {
        return x + y;
    }
    double add(int x, double y) {
        return x + y;
    }
    double add(double x, int y) {
        return x + y;
    }

    //매개변수의 개수 차이
    int add(int a, int b, int c) {
        return a + b + c;
    }

    /*
        오버로딩의 사용 목적
        1. 메서드가 수행하는 기본적인 작업이 동일할 때, 같은 이름 사용 가능하다
           코드를 더 명확하고 가독성 있게 작성 가능하다
        2. 코드의 재사용성이 높아진다.
     */


}

public class Overloading01 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println(calc.add(10.0,30));
        System.out.println(calc.add(10,20));
        System.out.println(calc.add(10,20.0));
        System.out.println(calc.add(10.1,20.3));
        System.out.println(calc.add(10,20,30));

    }
}
