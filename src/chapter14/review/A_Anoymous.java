package chapter14.review;

/*
    === 익명 (내부,중첩) 클래스===
    : 클래스를 정의하면서 동시에 인스턴스화가 이루어지는 방법이다.
    - 이름이 없기때문에 제사용이 불가하다. 1회성 객체 정의에 유용하다.

    //cf)람다 표현식으로 변환 가능한 인터페이스는 '함수영 인터페이스'로 단 하나의 추상 메서드만을 가져야한다.
 */

//1.인터페이스 구현예시
interface Animal {
    void sound(); //추상메서드 - 구현{}이 없는 메서드
    //cf)람다 표현식으로 변환 가능한 인터페이스는 '함수영 인터페이스'로 단 하나의 추상 메서드만을 가져야한다.
}

//인터페이스를 구현한 클래스 - 재사용이 가능하다
class dog implements Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}


//2.추상클래스
abstract class Vehicle { //vehicle 운송수단,탈것
    abstract void run(); //추상메서드
}
//추상클래스 - 반환 타입이 String
abstract class Person {
    abstract String getName();
}


public class A_Anoymous {
    public static void main(String[] args) {
        Animal dog1 = new Animal(){ //재사용 불가
            @Override
            public void sound() {
                System.out.println("멍멍");
            }
        };
        dog1.sound();

        Animal dog2 = new Animal() {
            @Override
            public void sound(){
                System.out.println("멍멍");
            }
        };
        dog2.sound();

        //추상메서드
        Vehicle car = new Vehicle() {
            @Override
            void run() {
                System.out.println("자동차가 달립니다");
            }
        };

        //추상메서드 - 반환타입 String
        Person person = new Person() {
            @Override
            String  getName() {
                return "이승아";
            }
        };
        System.out.println(person.getName());
    }
}
