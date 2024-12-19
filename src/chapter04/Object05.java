package chapter04;

/*
    객체 지향 프로그램의 '변수'
    필드와 지역변수
    1.필드(속성)
    : 객체의 지속적인 상태를 저장하는 클래스 내부의 변수
    - 메서드 외부에 위치한다.
    - 명시적으로 초기화하지 않으면 기본값으로 자동 초기화한다
    - 인스턴스(instance) 변수, 클래스(정적, static) 변수
     1-1)인스턴스 변수
        클래스의 각 객체(인스턴스)에 속한 변수
        클래스 내부에서 선언하고, 객체가 생성될 때 메모리에 할당된댜
        각 인스턴스마다 다른 값을 가질 수 있다.
        클래스를 인스턴스화하여 사용이 가능하다.
        >> 클래스명 변수명 = new 인스턴스변수명 (클래스의 인스턴스화)
        >> 객체명.인스턴스변수명 (인스턴스 변수 사용)
     1-2)클래스(정적, static) 변수
        클래스의 모든 인스턴스에서 공유되는 데이터 변수
        static 키워드를 사용하여 선언되는 변수이다
        해당 클래스로 생성되는 인스턴스는 모두 동일한 값을 가진다.
        프로그램이 시작될 때 생성되어 프로그램 종료 시 소멸된다.
        static 변수는 인스턴스화 없이 사용 가능
        각 인스턴스명으로도 호출 가능하지만 클래스명으로 호출하는것을 권장
        >> 클래스명.필드명

    2.지역변수
    : 메서드가 실행되는 동안에만 존재하는 일시적인 변수
    - 메서드, 생성자 또는 블록 내부에서 선언
    - 자동 초기화되지 않는다. 반드시 초기화 후 사용해야한다.
 */

class CarClass{
    //필드 - 인스턴스(instance) 변수
    //각 객체(인스턴스)마다 다른 값을 가진다
    String color;
    String brand;
    int speed;
    //필드 - 정적 변수
    //해당 클래스로 생성되는 모든 객체가 동일한 값을 가진다
    static int tireNumber = 4;
    static int doorNumber;

    //지역변수
    void accelerate(int increment){
        //increment : 지역변수 -> 메서드 내부에서만 유효
        speed += increment;
    }
}


public class Object05 {
    public static void main(String[] args) {
        //클래스(정적, static) 변수 사용방법
        //static 변수는 인스턴스화 없이 사용 가능
        //각 인스턴스명으로도 호출 가능하지만 클래스명으로 호출하는것을 권장
        //>>클래스명.필드명
        System.out.println(CarClass.tireNumber); //4
        CarClass.doorNumber = 4;
        System.out.println(CarClass.doorNumber); //4

        //CarClass 인스턴스화
        CarClass car1 = new CarClass();
        CarClass car2 = new CarClass();
        //객체의 인스턴스 변수 사용방법
        //>> 객체명.인스턴스변수명
        car1.brand = "kia";
        car1.color = "brand";
        System.out.println(car2.brand);

        //static변수는 클래스명으로 접근하는것을 권장
        //car1.doorNumber = 5;
        //System.out.println(car2.doorNumber); //static변수는 공유되기떄문에 5


    }
}