package chapter05;

// 사칙연산 클래스 만들기
// 두개의 값을 매개변수로 전달 받아 사칙연산을 수행하라.
class MyMath{
    int add(int a, int b){
        return a + b;
    }
    int subtract(int a, int b){
        return a - b;
    }
    int multiply(int a, int b){
        return a * b;
    }
    int divide(int a, int b){
        return a / b;
    }
    int divide2(int a, int b){
        if(b == 0 ){
            System.out.println("정수 0으로 나눌 수 없습니다");
            return b;
        } else{
            return a / b;
        }
    }

    /*
        return문
        : 현재 실행 중인 메서드를 종료하고 호출한 메서드로 돌아간다
          반환값 유무에 상관없이 반드 시 존재한다.
          void 문이여도 생략되어 존재한다.
     */
    void noReturn(){
        System.out.println("해당 메서드는 반환값이 없습니다.");
        //return;
        //자바 컴파일러가 반환타입을 읽고 해당 메서드의 마지막에 자동으로 return;을 추가한다.
    }
    String yesReturn() {
        String name = "이승아";
        return name;
        //반환 타입이 void가 아닌 경우 반드시 해당 타입의 값이 return 뒤에 작성되어야한다.
    }

    //조건에 따른 반환값을 지정
    int max(int a, int b){
        // 정수 a와 b를 비교하여 큰 값을 반환
        if(a > b){ //괄호당 구문 하나이므로 괄호 생략 가능
            return a;
        } else{
            return b;
        }
    }
    //삼항연산자를 사용하여 최소값을 반환하기
    int min(int a, int b){
        return a > b ? b : a;  //삼항연산자 >> 조건식 ? 참일때 값 : 부정일떄 값;
    }
}

public class Method03 {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();

        System.out.println(myMath.add(10,3));
        System.out.println(myMath.subtract(10,3));
        System.out.println(myMath.multiply(10,2));
        //System.out.println(myMath.divide(10,0));
        // 복사되어 전달되기에 인자값은 오류가 없지만 계산에서 오류가 난다.
        // 자바에서는 정수형에서 0으로 나누면 오류가 난다, 실수형에서는 오류가 나지 않는다.
        System.out.println(myMath.divide2(10,0)); //오류 처리

        //인자값과 매개변수의 관계
        //- 자바는 값에 의한 호출 방식을 사용한다
        //- 메서드 호출 시 인자값이 매개변수에 복사되어 전달된다.

        //메서드의 호출 >> 객체명.메서드명(인자);
        System.out.println(myMath.max(11,14));
        System.out.println(myMath.min(11,14));

    }
}
