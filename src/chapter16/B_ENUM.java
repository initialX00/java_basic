package chapter16;

/*
    === ENUM (열거형) ===
    : 서로 관련된 상수들의 집합을 표현하는데 사용하는 자료형이다.
      서로 유기적인 관계성을 띄며, 자바의 클래스처럼 취급할 수 있다.
    - 일반적으로 상수 선언에 사용되는 static final보다 더 간결하고 안전한 방식으로 정의할 수 있다.
    - 특정 값들만 가질 수 있도록 제한하는데 사용할 수 있다.

    1.Enum의 기본 사용법
    >> enum Enum명 {}
    - Enum의 명명은 대문자로 시작하여 UpperCamelCase를 사용한다
      중괄호 내에 열거할 데이터를 쉽표(,)로 구분하여 나열한다
    cf) class 사용법 >> class Clss명 {}

    enum 내의 데이터는 final 특징을 살려 UPPER_SNAKE_CASE를 따른다
    클래스의 statci final 필드처럼 쓰인다, 각 상수는 정의된 Enum 타입으로 간주된다.

    2.Enum의 주요 메서드
    values() : 열거형의 모든 값을 배열로 반환한다.
    name() : Enum 상수의 이름을 문자열로 반환한다.
    ordinal() : Enum 상수의 순서를 반환(0부터 시작)
    valueOf(String name) : 문자열로 Enum 상수를 반환한다
                        - 잘못된 문자열 전달 시 IllegalArgumentException 발생

 */

//1.Enum 선언
enum Fruits {
    APPLE, BANANA, ORANGE //enum 내의 데이터는 final 특징을 살려 UPPER_SNAKE_CASE를 따른다
}

enum CoffeeSize {
    SMALL(200), MEDIUM(300), LARGE(400); //생성자 호출

    private final int ml;

    CoffeeSize(int ml) { //생성자
        this.ml = ml;
    }

    public int getMl() {return ml;}
}


public class B_ENUM {
    public static void main(String[] args) {
        //1. Enum 호출
        //클래스의 statci final 필드처럼 쓰인다
        //각 상수는 정의된 Enum 타입으로 간주된다.
        Fruits apple = Fruits.APPLE;
        System.out.println(apple);


        //2. Enum의 주요메서드
        //vlaues()
        System.out.println(Fruits.values()); //[Lchapter16.Fruits;@73a28541

        //name()
        System.out.println(Fruits.APPLE.name()); //APPLE

        //Enum 순환
        for(Fruits fuits : Fruits.values()){
            System.out.println(fuits); //APPLE  BANANA  ORANGE
        }

        //valueOf(String name)
        //Fruits orangeFruit = Fruits.valueOf("Orange"); - IllegalArgumentException 발생
        Fruits orangeFruits = Fruits.valueOf("ORANGE");

        //ordinal()
        System.out.println(orangeFruits.ordinal());  //2


        //1.Enum 생성자 호출
        CoffeeSize size = CoffeeSize.MEDIUM;
        System.out.println("Selected size : " + size + ", Volume : " + size.getMl() + "ml");
        //Selected size : MEDIUM, Volume : 300ml

    }
}
