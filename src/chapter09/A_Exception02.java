package chapter09;

/*
    Throwable : 예외(Exception) + 오류(Error)

    === 사용자 정의 예외 클래스  ====
    : 자바의 Exception 클래스를 상속받는 자식 클래스
    호출부 >> throw new 사용자정의예외생성자명("예외 처리 문구");
    사용자 정의 예외를 발생시키는 throw 키워드의 경우 예외 처리 구문 내에 사용되지 않으면 (컴파일)예외가 발생한다

     cf) catch 블럭의 예외객체 'e'
       : 주로 객체변수는 Exception의 철자를 사용하여 'e'로 명시한다

    === throws 키워드 ===
    - 메서드 선언부에 위치해있다
    - 호출자에게 예외 처리를 위임한다.
    - 해당 메서드에서 발생할 수 있는 예외 가능성을 처리하는 키워드이다.
    - 체크(컴파일) 예외 : 필수 / 언체크(런타임) 예외 : 선택
    - (접근제어자) 반환타입 메서드명() throws Exception Type {}

    cf) throw 키워드
       - 메서드 내부에 위치해있다
       - 예외를 발생시킨다
       - throw new ExceptionType("에러메세지");

 */

import java.util.InputMismatchException;
import java.util.Scanner;


//사용자 정의 예외 클래스
class CustomException2 extends Exception {
    CustomException2(String message){ //생성자
        super(message); //부모클래스의 생성자 호출
    }
}

//throws
class InvalidUserException extends Exception {
    InvalidUserException(String message) {
        super(message);
    }
}


public class A_Exception02 {
    //throws
    //1) 단일예외 던지기
    static void login(String username, String password) throws InvalidUserException {
        if(!"admin".equals(username)){
            throw new InvalidUserException("사용자 이름이 잘못되었습니다");
        }
    }
    //2) 여러예외 던지기
    static void exceptions(int num) throws ArithmeticException, ArrayIndexOutOfBoundsException{
        if(num == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        } else if (num == 2) {
            throw new ArrayIndexOutOfBoundsException("배열 인덱스를 초과하였습니다");
        }
    }

    public static void main(String[] args) {
        //=== 사용자 정의 예외 클래스 사용===
        //throw new CustomException2("예외 처리되지 않는 예외");
        //: 사용자 정의 예외를 발생시키는 throw 키워드의 경우 예외 처리 구문 내에 사용되지 않으면 (컴파일)예외가 발생한다
        try {
            throw new CustomException2("사용자 정의 예외가 발생"); //사용자 정의 예외가 발생 - 런타임 예외
        } catch (CustomException2 e) {
            System.out.println(e.getMessage()); //발생된 예외를 catch블록에서 처리
        }
        System.out.println("========");

        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("정수를 입력하세요");
            int number = scanner.nextInt();
            System.out.println("입력하신 숫자는 " + number + "입니다");
        } catch (InputMismatchException e){ //예외객체 'e' : Exception의 철자를 사용하여 'e'로 명시한다
            System.out.println("정수가 아닌 다른 타입의 입력이 작성됨.");
        } finally {
            scanner.close();
        }


        //throws
        try{
            login("abcde", "password");
        } catch(InvalidUserException e){
            System.out.println("단일 던지기 테스트");
            System.out.println(e.getMessage());
        }
        System.out.println("======");

        try{
            System.out.println("여러예외 던지기 테스트");
            exceptions(1);
        } catch (ArithmeticException e){
            System.out.println("예외처리1 : " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("예외처리2 : " + e.getMessage());
        }
        System.out.println("정상적인 코드");

    }
}
