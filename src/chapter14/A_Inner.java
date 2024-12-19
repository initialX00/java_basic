package chapter14;

/*
    내부 클래스(Inner Class) / 중첩 클래스(Nested Class)
    : 다른 클래스 내부에 선언된 클래스를 의미한다

    == 장점 ==
    : 코드의 가독성을 향상시켜 코드의 구조 파악에 용이하다
    : 클래스 간에 관계를 명확하게 하여 내부 클래스는 외부 클래스의 멤버(필드, 메서드)에 접근가능하다.

    == 종류 == (암기하지 말고 알고만 있자)
    1. (비정적) 내부 클래스 - 가장 기본적인 클래스의 형태
    : 외부 클래스의 인스턴스에 속한다
      외부 클래스의 인스턴스 변수 및 메서드에 직접 접근이 가능하다
      >> 외부클래스타입.내부클래스타입 변수멸 = 외부인스턴스명.new 내부클래스();

    2. 정적(static) 내부 클래스
    : 외부 클래스의 정적 멤버에 속한다.
      외부 클래스의 인스턴스 변수에 접근할 수 없다.
      외부 클래스의 정적 멤버에만 접근 가능하다.
      >>외부클래스타입.내부클래스타입 변수 = new 외부클래스명.내부클래스();

    3. 메서드 내부 클래스 (지역 클래스)
    : 메서드 내에 정의된 내부클래스를 말한다
    : 해당 메서드 내에서만 사용이 가능하다.
      메서드의 지역변수에만 접근이 가능하다.
      cf)로컬 변수(외부클래스 멤버변수)가 final인 경우에만 접근 가능하다

    4. 익명 (내부) 클래스 - anonymous : 익명의
    : 이름이 없는 내부클래스
    : 주로 인터페이스나 추상클래스의 구현에 사용된다
      즉시 객체를 생성가능하고, 주로 클래스를 일회성으로 사용할 때 사용한다.
 */

import java.lang.reflect.Method;

class OuterClass {
    private String outerField = "외부 클래스의 필드";
    static String staticField = "외부 클래스의 정적 필드";
    //1.비정적 내부 클래스 - 인스턴스 멤버처럼 사용한다
    class InnerClass {
        void display() {
            System.out.println("외부 클래스 필드에 접근: " + outerField);
        }
    }
    //2.정적 내부 클래스
    static class StaticClass {
        void display(){
            //외부 클래스의 인스턴스 변수에 접근이 불가
            //System.out.println("외부 클래스 필드에 접근 : " + outerField);

            //외부 클래스의 정적변수 사용 시 클래스명. 생략 가능하다
            System.out.println("외부 클래스의 정적 필드에 접근 : " + staticField);
        }
    }
    //3.메서드 내부클래스(지역 클래스)
    void outerMethod() {
        String localVar = "메서드 로컬 변수"; //암묵적으로 final로 간주 (생략)
        final String localFinalVar = "메서드 로컬 변수(Final)";

        class MethodClass {
            void display() {
                System.out.println("로컬변수에 접근(Final X) " + localVar);
                System.out.println("로컬변수에 접근(Final O) " + localFinalVar);
            }
        }
        System.out.println("외부클래스의 메서드를 호출");
        //로컬클래스의 인스턴스화
        //메서드 안에서만 쓰이기때문에 인스턴스화도 내부에서만 일어난다
        MethodClass methodClass = new MethodClass();
        methodClass.display();
    }
}

//추상클래스 : 하나이상의 추상메서드를 포함
//cf) 추상메서드는 구현부{}가 없는 메서드이다
abstract class AbstractClass {
    abstract void display();
}

//인터페이스
interface Greeting {
    void sayHello();
}
//interface ExampleInterface {
//    void something();
//}
//

public class A_Inner {
    public static void main(String[] args) {
        System.out.println("==비정적 내부클래스==");
        //1)외부 클래스의 인스턴스화
        OuterClass outerClass1 = new OuterClass();
        //2)외부클래스.내부클래스 형식으로 내부 클래스를 생성
        //외부클래스타입.내부클래스타입 변수멸 = 외부인스턴스명.new 내부클래스();
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display(); //외부 클래스 필드에 접근: 외부 클래스의 필드

        System.out.println();
        System.out.println("==정적 내부클래스==");
        //1)외부 클래스 인스턴스화가 불필요하며, 클래스를 통한 내부 클래스 생성이 가능하다
        //외부클래스타입.내부클래스타입 변수 = new 외부클래스명.내부클래스();
        OuterClass.StaticClass staticClass = new OuterClass.StaticClass();
        staticClass.display(); //외부 클래스의 정적 필드에 접근 : 외부 클래스의 정적 필드

        System.out.println();
        System.out.println("==메서드 내부클래스(지역클래스)==");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();
        //외부클래스의 메서드를 호출
        //로컬변수에 접근(Final X) 메서드 로컬 변수
        //로컬변수에 접근(Final O) 메서드 로컬 변수(Final)

        System.out.println();
        System.out.println("==익명 (내부) 클래스===");
        //클래스타입 변수명 = new 클래스명() {메서드 구현 - 추상클래스, 인터페이스의 추상메서드}
        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스");
            }
        }; //메서드취급이기에 ;으로 끝이난다
        AbstractClass abstractClass2 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("두번쨰 익명 내부 클래스");
            }
        };
        abstractClass1.display();
        abstractClass2.display();
        System.out.println(abstractClass1 == abstractClass2); //싱글톤과는 다르다

        //인터페이스 사용 익명 클래스
        System.out.println("==인터페이스 사용 익명클래스==");
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("안녕하세요. 인터페이스 익명클래스입니다");
            }
        };
        greeting.sayHello(); //안녕하세요. 인터페이스 익명클래스입니다
    }
}
