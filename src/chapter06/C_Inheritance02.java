package chapter06;

/*
    상속에서의 생성자
    - 상속받은 클래스에서 생성자 호출 시 부모에서 자식 순서로 진행한다
    - 자식 클래스 객체를 생성할 때, 자식 클래스는 해당 클래스의 생성자를 통해 객체를 생성한다
      자식 클래스의 생성자 호출 시 항상 부모 클래스의 생성자가 호출된다
      자식클래스에서 부모클래스의 생성자를 사용하기 위해 별도의 호출을 필요로 하지는 않다
 */


/*
    Mammal 클래스
    1)필드 : 이름(name), 숫자(number)
    2)생성자 : 기본은 매개변수 없음, 사용자정의는 매개변수(String name) - 생성자 오버로딩
    3)메서드 : 클래스 필드 정보를 출력(displayMammal)
 */
class Mammal {
    String name = "Parent";
    int number = 10;

    Mammal() {
        System.out.println("빈 부모 생성자 - 인스턴스 생성");
    }
    Mammal(String name){
        this.name = name; //필드와 지역변수의 이름이 같을 경우 구분을위해 this. 키워드 사용
    }

    void displayMammal(){
        System.out.println(name);
    }
}
/*
    Cat클래스(Mammal클래스에게 상속받은 자식클래스)
    1) 필드 : 이름(name)
    2) 생성자 : 기본은 매개변수 없음, 사용자정의는 매개변수(String name) - 생성자 오버로딩
    3) 메서드 : 정보출력(greet)
 */
class Cat extends Mammal {
    String name = "Child";

    Cat(){
        //super(); 생략
        //: 자식클래스의 기본 생성자는 사용자 정의 생성자 호출이 없더라도
        //  super() 부모 클래스 생성자 호출 키워드가 정의되어 있다(생략)
        // >> 'super();' 대신 '부모클래스명();' 사용 가능
        System.out.println("빈자식 생성자");
    }
    Cat(String name){
        //super()는 부모클래스의 생성자를 가져오는 키워드이다.
        // : 부모 클래스 내에 정의된 생성자 형태 그대로 사용한다.
        super(name); //Mammal(String name)에 choco로 입력

        //this.name = name;
        System.out.println("자식클래스가 생성되었습니다");
    }

    //인스턴스 메서드
    void greet(){
        //해당 클래스가 가진 인스턴스 변수에 접근
        //: this(생략 가능)
        System.out.println("자식이름: " + this.name);
        System.out.println("자식이름: " + name);
        //부모 클래스가 가진 인스턴스 변수에 접근
        //: super(생략 불가)
        System.out.println("부모이름: " + super.name);
        System.out.println("부모이름: " + name);
        //super: 부모클래스로 생성된 객체 그 자체를 의미한다
        //     - 부모클래스 내의 필드와 메서드에 접근 .연산자를 사용한다.
        //     - super.필드명 / super.메서드명()
        //super(): 부모클래스 내의 생성자 호출

    }
}

public class C_Inheritance02 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        //빈 부모 생성자
        //빈 자식 생성자
        Cat cat2 = new Cat("choco"); //super() 키워드로 인해 부모클래스에 입력
        System.out.println(cat2.name); //Child

        cat2.greet();
        //자식이름: Child
        //자식이름: Child
        //부모이름: choco
        //부모이름: Child

        System.out.println(cat2.number); //10
    }
}
