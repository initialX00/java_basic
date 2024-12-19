package chapter09;

/*
    === 자바 예외 처리 ===
    1.예외(Exception)란 프로그램 실행 중에 발행할 수 있는 예기치 못한 문제나 조건을 말한다
      예외 처리 기법이란 예외가 발생할 경우 프로그램이 중단되지 않고 대응하여 정상적인 흐름을 유지하는 방법을 말한다.



    2.자바 예외 클래스 구조
    Throwable: 모든 예외와 오류의 최상위 클래스
    - 모든 예외 클래스는 해당 클래스를 상속받는다
    - 예외와 관련된 메시지, 처리 방법에 대한 예시 정보를 포함한다.

     1) Exception 클래스(예외)
     : 프로그램이 처리할 수 있는 예외들을 정의한다
     - 예외 처리를 통해 개발자가 처리할 수 있는 문제들을 정의한다.
       1-1) Checked Exception
        : 컴파일 시점에 체크되는 예외
        - 개발자가 직접 반드시 처리
        - 컴파일러는 해당 예외가 처리되어있지 않을 경우 오류를 발생시킨다
       1-2) Runtime(Unchecked) Exception
        : 런타임 시점에 발생되는 예외
        - 개발자의 실수로 발생하는 예외
        - 컴파일러가 강제하지 않는다(체크하지 않음)
       cf) 컴파일 시점과 런타임 시점
        - 컴파일 시점 : 소스 코드를 기ㅖ어로 번역하는 단계, 실행되지 않고 코드를 분석하고 변환하는 과정에만 국한된다
                     자바에서는 .java 파일이 컴파일되어 .class파일(바이트코드)로 생성된다.
        - 런타임 시점 : 컴파일된 프로그램이 실행되는 단계, 프로그램이 실제로 메모리에 로드되고 CPU에서 실행된다.
                     컴파일 시점에서 잡히지 않은 놀리적 오류나 런타임 예외 발생 가능성이 존재한다

     2) Error(오류)
     : 프로그램 외부에서 발생하는 시스템 수준의 문제이다.
     - 개발자가 직접 처리할 수 없다
     - 메모리 부족, 네트워크 연결 등



    3.자바 예외 처리 방법
    : try-catch 블록, throw 키워드, throws 키워드, 사용자 정의 예외

     1)try-catch 블록
      - catch 블록 : 특정 예외타입이 발생했을 때 실행될 코드를 정의한다.
        다중 catch 블록으로 여러개를 예외처리할 수 있다.
        catch 블록은 동시다발적으로 처리되지 않고 하나만 처리된다.
      - finally 블록 : 예외 발생 상관없이 실행되는 코드 블럭.
        생략할 수 있다.
     >>
     try {
        예외가 발생할 수 있는 코드
    } catch (ExceptionType1 e) {
        예외 발생 시 실행할 코드
    } catch (ExceptionType2 e) {
        예외 발생 시 실행할 코드
    } finally {
        예외 발생 상관없이 실행되는 코드 블럭
    }
     cf) e.getMessage() : 오류 메세지 출력


     2) throw 키워드
      : 프로그램 실행 중에 특정 조건에서 예외를 직접 발생시킬 때 사용한다.
      - 주로 조건문과 함께 사용한다
      - 인자로 전달되는 문자열 예외 메시지는 getMessage() 메서드를 통해 출력 가능하다.
      >>
      throw new ExceptionType("에외 메시지");


 */

class CustomExeption extends Throwable {

}

public class A_Exception01 {
    public static void main(String[] args) {
        //try-catch 블럭

        //char c1 = 'abc'; - 컴파일 예외, 실행 전에 발생하는 오류
        String s1 = "string";

        //System.out.println(c1);
        System.out.println(s1);

        //int division = 10 / 0; // 런타임 예외, 실행 후에 발생하는 오류
        //System.out.println(division); //Exception in thread "main" java.lang.ArithmeticException

        try {
            //에외가 발생하는 코드
            int division = 10 / 0; //정수는 0으로 나눌 수 없다
        } catch (Exception e) {
            //try블록 내에서 방생하는 에외를 소괄호() 내에서 매개변수로 전달받아 중괄호 {} 실행문에서 처리한다.
            System.out.println(e.getMessage());
            System.out.println("0으로 나눌 수 없습니다");
        }


        try{
            System.out.println("예외 처리됐으면 출력 안됨");

            int division = 10 / 0; //ArithmeticException 발생

            int[] numbers = new int[5];
            numbers[10] = 50; //ArrayIndexOutOfBoundsException 발생

            String text = null;
            System.out.println(text.length()); //NullPointerException 발생

            //에러에 대한 예외 하나에만 전달된다.
        } catch (ArithmeticException e) {
            System.out.println("수학적 공식의 에러 발생 " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 초과 오류 발생 " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("null 계산할 경우 오류 발생 " + e.getMessage());
        } catch (Exception e) {
            System.out.println("초과 오류 발생 " + e.getMessage());
        } finally {
            System.out.println("finally 블록 실행");
        }



        //throw 키워드
        int age = -10;

        try{
            if(age<0){
                throw new Exception("나이는 음수가 될 수 없습니다");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
