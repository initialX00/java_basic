package chapter08;

/*
    === 추상화(Abstract) ===
    1.추상 클래스
     1)추상클래스의 정의
     : 미완성 설계도, 완전하지 않은 클래스를 말한다.
     - 자체적으로 인스턴스를 생성할 수 없다.
     - 다른 클래스가 상속받아 완성해야만 사용가능하다.

     2)추상클래스의 특징
      -클래스 자체로 인스턴스 생성이 불가하다
      -하나 이상의 추상메서드를 포함해야한다. 일반메서드도 함께 존재 가능하다.
      -확장성 제공을 위해 사용된다.
        자식 클래스들이 공통된 기능을 공유하며 고유 기능을 고현하도록 강제한다.
      -다중 상속이 불가하다. (extends 한번만, 중첩은 불가)

     3) 추상클래스의 구현방법
     >> abstract class 클래스명

    2.추상메서드
     : 메서드의 선언부만 존재하고, 구현부가 없는 메서드를 말한다.
     - 자식클래스에서 해당 메서드를 반드시 구현하도록 강제하는 역할을 한다.
       추상메서드는 자식클래스에서 반드시 오버라이딩해야한다. 일반메서드는 필요에 따라 선택.
     - 구현부 {} 대신 세미콜론(;)을 사용하여 선언을 마친다.
     >> abstract (접근제어자) 반환타입 메서드명 (매개변수);

     cf)메서드의 구성 : 선언부 + 구현부
     (접근제어자) 반환타입 메서드명 (매개변수) {메서드의 기능}

 */

//추상클래스의 다중상속
abstract class lion {
    abstract void mane(); //갈퀴
}
abstract class tiger {
    abstract void stripe(); //줄무늬
}
//class Liger extends Lion extends Tiger{ - 다중상속 불가
//    void mane() {}
//    void stripe() {} - 매당 메서드를 상속 받을 수 없다
//}


//예제1 - 상속만
abstract class Human { //추상클래스
    abstract void work(); //추상메서드 - 구현부{} 없음
}

//Error - Class 'Police' must either be declared abstract or implement abstract method 'work()' in 'Human'
class Police extends Human { //자식클래스에서 정의를 명확히하거나 추상메서드 제거 필요
    void work() { //추상메서드 구현, 오버라이딩
        System.out.println("경찰은 치안을 유지합니다");
    }
}
class Student extends Human {
    void work() { //추상메서드 구현
        System.out.println("학생은 공부를 합니다");
    }
}

//예제2 - 상속과 객체화
abstract class Animal { //추상클래스
    abstract void makeSound(); //추상메서드
    void eat() {
        System.out.println("동물이 먹이를 먹습니다");
    }
}
class Dog extends Animal{
    void makeSound(){ //추상메서드 구현, 오버라이딩
        System.out.println("멍멍");
    }
    @Override
    void eat() {
        System.out.println("강아지는 개껌을 먹습니다");
    }
}
class Cat extends Animal{
    void makeSound(){ //추상메서드 구현
        System.out.println("야옹");
    }
}


public class A_Abstract {
    public static void main(String[] args) {
        //추상클래스는 인스턴스화 불가능
        //Animal animal = new Animal();

        Dog dog = new Dog();
        Cat cat = new Cat();

        cat.makeSound(); //자식클래스에서 정의된 기능
        cat.eat(); //부모클래스에서 정의된 기능

        dog.makeSound(); //자식클래스에서 정의된 기능
        dog.eat(); //자식클래스에서 오버라이딩된 기능

    }
}
