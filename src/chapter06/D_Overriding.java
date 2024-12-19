package chapter06;

/*
    ===오버라이딩===
    : 자식클래스가 부모클래스에서 상속받은 메서드를 자신의 상황에 맞게 '재정의'하는것
    - 부모 클래스의 기본 동작을 자식클래스에서 변경하거나 확장할 때 사용한다.
    - 부모로부터 상속받은 속성이나 메서드를 확장하는 개념으로
      해당 상태나 동작을 반드시 가지지만 상속받은 클래스마다 차이를 두고 싶을 때 사용한다.

    @Override
    : 자바에서 제공하는 어노테이션(annotation) (주석)
    - 부모클래스의 메서드를 자식 클래스에서 재정의했다는 것을 명시적으로 나타낸다.
    - 생략해도 오류가 나지 않는 이유는 자바 컴파일러가 메서드 시그니처(이름, 매개변수, 반환타입)을 비교하여
      부모클래스의 메서드를 자식 클래스에서 재정의헀는지 자동으로 판단한다.

    cf)어노테이션
      : 코드에 메타데이터를 제공하는 방법

    1. 오버라이딩의 특징
     - 메서드의 시그니처가 일치해야한다
       부모클래스에서 정의된 메서드와 동일한 이름과 매개변수 구성을 가져야한다.
       반환 타입은 같거나 자동 형 변환이 가능하게 작성해야한다.
    2. 오버라이딩 구형 방법
     - 부모클래스의 상속받은 메서드를 자식클래스에서 다시 정의한다.
       매서드명, 매개변수, 반환타인이 같아야한다. (반환타입은 자동 형 변환 가능하게)
       메서드 위에 @Override 어노테이션을 작성하여 안정성과 가독성을 챙긴다.
    3. 오버라이딩 사용 목적
     - 다형성 구현 : 하나의 이름으로 여러 기능을 수행할 수 있다
     - 재사용성, 확장성 향상 : 기존의 코드 변경 없이, 새로운 기능을 추가하거나 변경이 가능하다.

    === 오버로딩(Overloading)과 오버라이딩(Overriding) ===
    : 메서드의 이름을 재사용하는 방법 (다형성)
    1)오버로딩
     - 같은 클래스 내에서 같은 이름을 가진 메서드를 여러개 정의한다
     - 메서드의 동작을 다양한 상황에 맞게 조정한다
     : 메서드명은 동일
     : 매개변수의 타입, 개수, 순서 중 하나는 달라야한다
     : 반환타입은 관련이 없다

    2)오버라이딩
     - 상속 관계에 있는 클래스에서 사용
     - @Override 이노테이션을 사용한다 (컴파일러에게 정보 전달)
     : 메서드의 시그니처(반환타입, 이름, 매개변수)가 같아야한다.
     : 메서드의 동작을 변경하거나 확장시키는 개념이다

 */

class ParentClass {
    void exercise () {
        System.out.println("달리기를 잘합니다");
    }
}
class ChildClass extends ParentClass {
//    void exercise () {  //부모클래스의 메소드가 생략되어있음
//        System.out.println("달리기를 잘합니다");
//    }
    @Override
    void exercise () { //JVM이 자동으로 오버라이딩 해줌
        System.out.println("달리기도 잘하고 피구도 잘합니다");
    }
}


class AnimalClass {
    void sound(){
        System.out.println("동물이 소리를 냅니다");
    }
}
class DogClass extends AnimalClass {
    @Override
    void sound(){
        System.out.println("개가 멍멍하고 웁니다");
    }
}
class CatClass  extends AnimalClass {
    @Override
    void sound(){
        System.out.println("고양이가 냐옹하고 웁니다");
    }
}


public class D_Overriding {
    public static void main(String[] args) {
        DogClass dog1 = new DogClass();
        dog1.sound(); //개가 멍멍하고 웁니다
        CatClass cat1 = new CatClass();
        cat1.sound(); //고양이가 냐옹하고 웁니다
        AnimalClass animal1 = new AnimalClass();
        animal1.sound(); //동물이 소리를 냅니다

    }
}
