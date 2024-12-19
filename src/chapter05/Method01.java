package chapter05;

/*
            === 자바 지향 프로그래밍 ===
            - '클래스(class)': 객체를 생성하기 위한 템플릿
            - '클래스'의 구조: 필드, 메서드, 생성자

            클래스의 필드
             : 클래스의 특성이 담긴 속성

             클래스의 메서드
             : 클래스 내부에서 필드를 사용하거나 특정 작업을 수행하는 코드 블럭이다.
             - 클래스 내부에서 정의된 함수이다.
             - 객체가 수행할 수 있는 동작을 정의한다.
             - 프로그램의 재사용성과 가독성을 높이는 역할을 한다.

             클래스의 생성자
             :

             === 메서드의 구조 ===
             ReturnType methodName(parameter List){
                메서드의 기능, 동작 정의;
             }
             1.ReturnType(반환 유형)
             : 메서드가 작업을 수행한 후 반환하는 데이터의 유형을 지정
               반환 유형이 없는 경우 void로 지정한다.

             2.methodName(메서드 이름)
             : 메서드를 식별하는 이름
               (권장) 동사를 사용하여 메서드의 작업을 설명한다.
               명명 규칙 - lowerCamelCase
               ex) "먹다" - eat(동사 ㅇ), eating(명사 X)

             3.Parameter List(매개변수 목록)
             : 메서드에 전달되는 입력 값들의 목록
               0개 이상으로 지정한다. (지정하지 않을 수 있음)
               각 매개변수는 자료형과 함께 선언하여, 메서드 내부에서 지역변수로 사용된다.
               일반 변수 정의처럼 동일한 데이터타입이더라도 생략이 불가능하다.
*/

/*
    === 함수(Function)와 메서드(Method) ===
    1.함수
    : 특정 작업을 수행하는 코드 블럭
    - 독립적인 존재, 클래스 소속이 아니다
    - '함수명();'으로 직접 호출이 가능하다
    - Python, JavaScript에서 사용된다

    2.메서드
    : 객체의 동작을 정의한 코드 블럭, 함수의 체계를 가졌다.
    - 클래스 내부에 포함되어 객체와 관련되어있다.
    - 객체 생성 후 '.연산자'를 통해 호출한다.
    - Java, C# 등 클래스 기반 언어에서 사용된다.

    cf)자바에서의 함수
    - 자바는 객체 지향 프로그래밍 언어로, 모든 함수는 '클래스'에 속해 있어야한다.

 */

class Calculator{
    int a, b; //데이터타입이 같다면 생략하여 선언 가능하다.
    int addNumbers(int a, int b){ // 지역변수는 생략하여 선언 불가능
        // 메서드의 반환값
        //: return 지정된 타입의 데이터를 반환
        int sum = a + b;
        return sum; // a + b도 가능
    }
    void voidMethod(){
        //메서드의 void 반환 타입
        //: return 키워드가 없거나 키워드 뒤의 값이 없는 경우 반드시 지정해야한다.
    }
}

public class Method01 {
    public static void main(String[] args) {


        //메서드 사용
        //1) 해당 메서드가 정의된 클래스의 객체를 생성해야한다
        //2) 생성된 객체를 사용하여 메서드 호춯(. 연산자 사용)

        Calculator calculator = new Calculator(); //객체 생성

        //메서드 호출과 출력
        System.out.println(calculator.addNumbers(10,20));

        int result = calculator.addNumbers(50,30);
        System.out.println(result);
    }
}
