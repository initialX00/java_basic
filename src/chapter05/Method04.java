package chapter05;

/*
    cf)클래스의 "필드"
      : 인스턴스 필드와 정적(클래스,static) 필드로 나뉜다.
      
    === 정적 메서드 ===
    : 클래스의 "메서드" 또한 인스턴스 메서드와 정적 메서드로 나뉜다.
    - 인스턴스 메서드 : 객체(인스턴스)를 생성한 후 호출할 수 있는 메서드
    - 정적(static) 메서드 : 객체 생성 없이 호출 가능한 메서드
    
    1.정적 메서드란
    : static 키워드를 메서드 앞에 붙여 정의된 메서드
      클래스의 이름으로 직접 호출이 가능하다.
    
    2.정적 메서드의 사용법
    선언시 >> static 반환타입 메서드명() {}
    호출시 >> 클래스명.메서드명();
    
    3.정적 메서드의 특징
    - 인스턴스 변수에 의존하지 않는다
    - 클래스 수준에서 공유되는 데이터를 다룰 때 적합하다. (정적 필드 활용 등)
    
    4.정적 메서드 사용 권장 사항
    - 공통 데이터 사용 : 모든 인스턴스에서 공유되는 데이터를 다룰 때
    - 독립적인 사용 : 인스턴스 변수와 관계없이 매개변수만으로 작업을 처리할 때
    
 */

class Operator {
    //(인스턴스) 변수(필드)
    int a, b; 
    
    //(인스턴스) 메서드
    //: 인스턴스 변수 a,b가 필요한 작업에 사용
    //: 매개변수를 사용하지 않을 수도 있음
    int add() {
        return a + b;
    }
    int subtract() {
        return a - b;
    }
    
    //정적 메서드
    //: 인스턴스 변수와 관계없이 매개변수만으로 작업한다
    static int multiplay(int a, int b) {
        return a * b;
    }
    static int divide(int a, int b) {
        return b != 0 ? a / b : b; //나누기 0 처리
    }
}

public class Method04 {
    public static void main(String[] args) {
        System.out.println("===인스턴스 메서드===");
        Operator operator = new Operator();
        //인스턴스 필드(변수) 값 부여
        operator.a = 10;
        operator.b = 20;
        //인스턴스 메서드 호출
        System.out.println(operator.add());
        System.out.println(operator.subtract());

        System.out.println("===정적 메서드===");
        //정적(클래스, static)메서드 호출
        //>> 클래스명.메서드명(인자);
        int result1 = Operator.multiplay(10, 20);
        int result2 = Operator.divide(20, 10);
        int result3 = Operator.divide(20, 0);
    }
}
