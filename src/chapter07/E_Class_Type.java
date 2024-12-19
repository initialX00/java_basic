package chapter07;

/*
    === 자바에서의 타입 변환 ===
    1) 자료형 변환 : 변수 & 자료형에서의 자동 형 변환(묵시적), 강제 형 변환(명시적)
    2) 클래스 타입 변환
    - 자동 타입 변환(Upcasting), 강제 타입 변환(Downcasting)
    : 상속 관계에 있는 클래스 사이에서만 변환 가능하다. (자료형 변환보다 가능한 범위가 좁다)

    1.자동 타입 변환(Upcasting)
    : 자식 객체를 부모 클래스 타입으로 변환한다
      직접 명시 없이, 자동으로 타입 변환이 일어난다
    - 해당 객체는 보존되면서 사용은 부모 객체처럼 사용된다.
      두 클래스 간의 공통된 특성이 아닌 자식 클래스의 고유 메서드는 호출이 불가능하다
     1)자식 객체를 생성하면서 즉시 부모 타입으로 변환하여 저장하는 방법
      >> 부모클래스명 객체변수명  = new 자식클래스명();
     2)이미 생성된 객체를 부모 타입으로 변환하는 방법
      >> 부모클래스명 객체변수명 = 자식객체변수명;

    2.강제 타입 변환(Downcasting)
    : 부모 클래스 타입으로 변환된 객체를 다시 자식 클래스 타입으로 변환하는 것
      업캐스팅되지 않은 객체를 다운캐스팅할 수 없다.
    - 자식 클래스에만 정의된 멤버에 접근 가능해진다.
      >> 자식타입 객체변수명 = (자식타입) 부모객체변수명;

      cf)클래스명 = 타입
         클래스명은 데이터타입처럼 클래스타입으로서 사용할 수 있다.

      cf)클래스 타입 변환 시 주의점
        반드시 상속 관계와 객체의 실제 타입을 확인해야한다.
        잘못된 캐스팅은 Exception 오류 발생.
 */

class Parent {
    void displayInfo() {
        System.out.println("부모 클래스입니다");
    }
}
class Child extends Parent{
    @Override
    void displayInfo() {
        System.out.println("자식 클래스입니다");
    }
    void childMethod() {
        System.out.println("자식 클래스만 가진 메서드입니다");
    }
}

public class E_Class_Type {
    public static void main(String[] args) {
        //자동타입 변환 (Upcasting)
        //1. 자식 객체를 생성하면서 즉시 부모 타입으로 변환하여 저장하는 방법
        //>> 부모클래스 객체변수  = new 자식클래스();
        Parent childObject = new Child();
        childObject.displayInfo(); //자식클래스입니다
        //childObject.childMethod(); -Cannot resolve method 'childMethod' in 'Parent'

        //2. 이미 생성된 객체를 부모 타입으로 변환하는 방법
        //>> 부모클래스 객체변수 = 자식객체변수;
        Child childObject2 = new Child();
        childObject2.displayInfo();
        childObject2.childMethod();
        Parent parentObject = childObject2;
        parentObject.displayInfo();
        //parentObject.childMethod();


        //강제 타입 변환(Downcasting)
        //>> 자식클래스명 객체변수명 = (자식클래스명) 부모객체변수명;
        Child child = (Child) parentObject;
        child.childMethod();
        child.displayInfo();

    }
}
