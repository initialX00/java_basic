package chapter06;

/*
    클래스의 구조 : 필드, 메서드, 생성자

    === 생성자 ===
    : 객체(인스턴스)가 생성될 때 호출되는 '인스턴스 초기화 메서드'

    1. 생성자 조건
    - 생성자 이름은 클래스 이름과 동일하다
    - 리턴값이 없는 메서드 형식이며 void타입 또한 입력하지 않는다.

    cf)'컴파일러가 제공하는 기본 생성자'
    : 클래스에 생성자가 없으면 컴파일러가 자동으로 생성해 준다
      매개변수가 없고, 아무 작업도 하지 않는 생성자이다

    cf) 인스턴스 생성
      : 생성자가 인스턴스를 생성하지 않는다
      : new 연산자 키워드가 인스턴스를 생성한다.
 */

class Example1 {
    int value;
    //컴파일러가 제공하는 기본 생성자가 생략되어 있다.
    //(매개변수가 없고, 아무런 실행코드가 구현되있지 않다)
    //Example1 () {}
}
class Example2 {
    int value;
    //사용자 정의 생성자
    //컴파일러가 자동으로 기본 생성자를 제거한다
    Example2(int value) {
        this.value = value;
    }
    //사용자 정의 생성자가 1개라도 있는 경우
    //빈 생성자를 직접 명시해야만 사용가능하다.
    //Example2() {}
}

class Car {
    String color;
    String gearType; //auto, menual)
    int door;

    // 기본생성자 - 차를 생성한 후 필드값을 할당
    Car(){}
    //사용자 정의 생성자
    Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    Car(String color){ //생성자의 오버로딩 (생성자 또한 메서드의 일종)
        //사용자 정의 생성자에서 다른 생성자 호출 시 this()를 사용한다
        //: 생성자 이름으로 클래스 이름 대신 this를 사용
        //: 사용자 정의 생성자에서 다른 생성자 호출 시 반드시 첫줄에서만 호출이 가능하다
        //- 호출된 생성자가 변수값을 초기화하는 경우
        //  해당 생성자가 수행하는 작업을 유지하기 위함(무의미함 방지)
        this(color, "auto", 4); //오버로딩을 통해 기어타입과 문갯수 고정.
        door = 5; //객체 생성 시 색성만 작성하는 경우 - 색상 + auto + 문5개
        //this(color, "auto", 4); //오버로딩은 인자의 갯수나 데이터타입이 달라야한다.
    }

    void displayInfo(){
        System.out.println(color + " " + gearType + " " + door);
    }
}

/*
    this 키워드
    1. this
     : 인스턴스 자신을 참조한다
     : 모든 인스턴스 메서드와 생성자에서 사용가능하다.

    2. this()
     : 같은 클래스 내의 다른 생성자를 호출할 때 사용한다
     : 중복 코드 제거와 유지보수성 향상에 기여한다
 */

public class A_Constructor {
    public static void main(String[] args) {
        Example1 example1 = new Example1();
        example1.value = 10;
        System.out.println(example1.value);

        //사용자 정의 생성자는 인스턴스 생성 시 반드시 인자값이 필요하다(초기화값)
        //Example2 example2 = new Example2();
        Example2 example2 = new Example2(10);
        System.out.println(example2.value);

        System.out.println("=======");

        //기본생성자
        Car car1 = new Car();
        car1.color = "red";
        car1.door = 2;
        car1.gearType = "manual";
        car1.displayInfo();

        //사용자 정의 생성자
        Car car2 = new Car("white", "auto", 4);
        car2.displayInfo();

        //오버로딩
        Car car3 = new Car("blue");
        car3.displayInfo();
    }
}
