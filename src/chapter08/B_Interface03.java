package chapter08;

/*
    인터페이스의 (멤버) 변수의 특성
    : 자동으로 public static final 특성을 가진다
    - 어디서든 접근 가능하다
    - 인스턴스화 없이 인터페이스명으로 접근 가능하다.(모두 같은 값 공유)
    - 값 변경이 불가능하다.
    cf) 클래스의 '멤버', 인터페이스의 '멤버'
     - 멤버란 해당 구조의 구성요소 (필드, 메서드, 생성자)

    === 다중 인터페이스 ===
    : implements 키워드에 여러 개의 인터페이스를 콤마(,)로 구분하여 나열한다.
    >> class 구현부명 implements 인터페이스명1, 인터페이스명2 {}

    cf)주의사항
    : 여러개의 인터페이스에서 같은 시그니터(선언부)를 가진 디폴트 메서드가 존재할 경우
      반드시 오버라이드하고 명시적으로 구현한다.
    - 재정의가 불가능한 추상메서드는 중복되더라도 하나로 취급하여 넘어간다
    - 재정의가 가능한 디폴트메서드는 중복될 경우 인터페이스 구현에서 오류가 난다.
      인터페이스 구현에서 오버라이딩 해줘야한다.

    cf)인터페이스의 다형성
    : 인터페이스를 구현한 클래스의 객체는 해당 인터페이스의 타입으로 동작 가능 (해당 타입이 될 수 있음)
    - 해당 인터페이스 내의 구조만 가진다
    - 재정의된 메서드는 유지된다
 */

//다중 인터페이스 구현
interface Example1 {
    int EXAMPLE_VARIABLE = 10;
    void printVar1();

    default void method(){
        System.out.println("디폴트1");
    }
}
interface Example2 {
    //추상메서드는 재정의가 불가하므로 중복되더라도 하나로 취급하여 넘어간다
    void printVar1();
    void printVar2();


    //디폴트메서드는 재정의가 가능하여 중복될 경우 인터페이스구현에서 오류가 난다.
    //인터페이스 구현에서 오버라이딩 해줘야한다.
    default void method(){
        System.out.println("디폴트2");
    }
}

class ExampleClass implements Example1, Example2 {
    public void printVar1() {
        System.out.println(EXAMPLE_VARIABLE);
    }
    public void printVar2() {
        System.out.println("다중인터페이스 구현");
    }
    //재정의가 가능한 디폴트 메소드는 오버라이딩이 필요하다
    @Override
    public void method(){
        System.out.println("중복된 디폴트 메소드");
    }
}

public class B_Interface03 {
    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.printVar1();
        exampleClass.printVar2();
        exampleClass.method();

        Example1 example1 = exampleClass; //업스캐일링
        example1.printVar1();
        //example1.printVar2();
        example1.method();

    }
}
