package chapter09;

/*
    API (Application Programming Interface)
    : 소프트웨어 또는 시스템 간 상호작용을 가능하게하는 정의된 메서드의 집합을 말한다.
    : 소프트웨어나 하드웨어와 상호작용할 수 있는 인터페이스를 제공한다.

    자바의 API 클래스
    : 자바 프로그래밍 내에서 미리 정의된 클래스와 메서드의 집합
    - 자바 API는 표준 자바 라이브러리로 제공한다
    - 다양한 패키즈로 나뉘며, 가가 패키지는 특정 기능을 담당한다

    1. java.lang 패키지
     : 기본 클래스(String, Math,System 등)를 포함
     - 자동으로 포함하여 import 없이 사용 가능하다

     2. java.io 패키지
     : 입출력과 관련되 클래스
     - File, InputStream 등과 같이 외부의 입출력과 관련되어있다.

     3. java.util
     : 유틸리티 클래스( List, Map, Date 등)를 포함한다


     cf)자바 API 공식 문서 : 자바API 오라클
        https://docs.oracle.com/en/java/javase/17/docs/api/index.html


 */

public class B_JavaApi {
    public static void main(String[] args) {

        //System 클래스의 API를 호출하여 콘솔에 메시지를 출력
        System.out.println();

        //java.lang
        String message = "Hello, Hava";
        System.out.println(message.length()); //ctrl + 좌클릭으로 기본 클래스를 볼 수 있다

        double result = Math.sqrt(25); //square root 제곱근
        System.out.println(result);

    }
}
