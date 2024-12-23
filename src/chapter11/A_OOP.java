package chapter11;

/*
    === OOP(Object - Oriented Programming) === (중요)
    : 객체 지향 프로그래밍
    - OOP의 4가지 특징 : 상속, 추상화, 다형성, 캡슐화

    === SOLID 원칙 === (중요)
    : 객체 지향 프로그래밍의 5가지 소프트웨어 개발 원칙 (권장사항)
    : SRP, OCP, LSP, ISP, DIP
    - 소프트웨어 설계에서 유지보수성과 확장성을 높인다.
    - 다양한 디자인 패턴(Design Pattern)이 SOLID 설계 원칙에 입각한다.

      cf)SQLID 원칙 적용 시 주의점
       - SOLID 원칙의 적용 순서는 따로 없다.
       - 다섯가지 모든 원칙이 필수가 아니다.
       - 서로 독립적인 개념이 아니라 서로 개념적으로 연관되어있다.

    SRP : 하나의 클래스에 하나의 기능만을 구현하기
    OCP : 추상클래스나 인터페이스를 통해 새로운 기능 추가가 자유롭게 만들기
    LSP : 추상클래스의 추상메서드를 통해 자식클래스가 어떠한 기능도 가능하게 하고 일관성을 챙긴다.
    ISO : 인터페이스 구현시 다중상속을 이용하여, 인터페이스에는 하나의 기능만을 선언한다.
          인터페이스 구현 시에는 해당 인터페이스의 추상화를 전부 구현해야하므로
          사용하지 않는 것까지도 구현해야되는 경우가 생기기때문이다.
    DIP : 클래스가 아니라 추상화에 의존하여 새로운 기능을 추가하더라도 코드 수정없이 확장이 가능하다.




    1. 단일 책임 원칙 (SRP, Single Responsibility Principle)
    : 클래스는 단 하나의 책임을 가져야한다.
    : 한 가지의 역할(기능)만 가져야한다, 하나의 변화 이유만 가져야 한다.
    - 하나의 클래스가 가지는 하나의 역할과 관련된 변경사항만 클래스에 영향을 미쳐야 한다.
    - 하나의 코드를 변경할 떄 여러개의 클래스를 수정하지 않고 하나의 클래스만 수정하도록 유지보수성을 높인다.

    2.개방-폐쇄 원칙 (OPC, Open Closed Principle)
    : 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에는 열려있어야하고, 수정에는 닫혀있어야한다.
    - 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있어야한다.
    - 추상화를 통한 관계 구축을 권장한다. (추상클래스, 인터페이스)
    - 추상클래스, 인터페이스의 상속, 구현을 통한 클래스 관계 구축한다.
      cf)확정에 열려있다 - 유연한 코드 추가가 가능하다
         변경에 닫혀있다 - 객체에 대한 직접적 수정을 제한한다

    3.리스코프 치환 원칙 (LSP, liskov Substitution Principle)
    : 상위 클래스의 객체를 하위 클래스의 객체로 치환하더라도 프로그램의동작이 일관되게 유지되어야 한다.
    - 자식 클래스는 부모 클래스의 기능을 완전하게 대체할 수 있다.
    - 업캐스팅 상태에서 부모의 메서드 사용 시 동작이 가능해야한다.


 */


/// SRP ///
//잘못된 예시 - 서로 다른 객체(보고서,이메일)에 대한 메소드가 한 클래스에 작성됨
class ReportManager { //보고서 담당업무
    void generateReport() { //보고서 생성
        System.out.println("보고서가 생성됨");
    }
    void send() { //이메일 전송
        System.out.println("이메일이 전송됨");
    }
}
//올바른 예시
class ReportGenerator{
    void generateReport() { //보고서 생성
        System.out.println("보고서가 생성됨");
    }
}
class EmailSender {
    void send() { //이메일 전송
        System.out.println("이메일이 전송됨");
    }
}


/// OPC ///
//잘못된 예시 - 수능할인기간이 끝나면 해당 코드를 다시 수정해야됨
class Discount { //수능생들 할인
    double calculateDiscount(boolean isStudent, int amount){
        if(isStudent){
            return amount * 0.2;
        } else{
            return amount * 0.1;
        }
    }
}
//올바른 예시 - 추상클래스, 인터페이스의 상속, 구현을 통한 클래스 관계 구축한다.
interface DiscountPolicy {
    double calculateDiscount(int amount);
}
class CommonDiscount implements DiscountPolicy {
    public double calculateDiscount(int amount){
        return amount * 0.1;
    }
}
class StudentDiscount implements DiscountPolicy{
    public double calculateDiscount(int amount){
        return amount * 0.2;
    }
}


/// LSP ///
//잘못된 예시
class Bird {
    void fly() {
        System.out.println("새는 날 수 있습니다");
    }
}
class Penguin extends Bird {
    @Override
    void fly () { //펭귄은 Bird를 상속받지만 fly 메서드가 가지는 동작을 의도대로 구현되지 않았다.
        System.out.println("펭귄은 날 수 없습니다");
    }
}
//올바른 예시
abstract class AbstractBird {
    abstract void move();
}
class FlyingBird extends AbstractBird {
    @Override
    public void move() {
        System.out.println("날 수 있는 새들입니다");
    }
}
class Pororo extends AbstractBird {
    @Override
    public void move() {
        System.out.println("펭귄은 수영할 수 있습니다");
    }
}




public class A_OOP {
    public static void main(String[] args) {

    }
}
