package chapter09;

/*
    === java.lang 패키지 ===
    : 자바 프로그램의 가장 기본적인 클래스들을 포함
    - 별도의 import문 없이 사용이 가능하다

    1.Object 클래스
     : 자바에서 모든 클래스의 최상위 클래스
     - 모든 클래스는 Object 클래스를 상속받는다

     1) toString() 메서드
       : 객체의 문자열 표현을 반환한다
       - 기본 구현 : '객체의 클래스 이름 + @ + 메모리 주소' 반환
       - 오버라이딩(재정의)하여 원하는 정보를 반환하도록 바꿀 수 있다

     2) A equals(B) 메서드
      : 두 객체가 동등한지 비교한다.
      - 두 객체의 참조를 비교한다. (동일한 주소값을 가지는지 비교한다)
      - 오버라이딩(재정의)라여 객체 내용 기반의 비교를 구현할 수 있다.


    2.Math 클래스
     : 수학 연산 및 함수를 제공하는 클래스
     - 모든 필드와 메서드는 static이다. Object클래스와 달리 인스턴스화 불필요하다
     >> Math.메서드
     - 절대값 반환 .abs(데이터)
       최댓값 반환 .max(데이터1,데이터2)
       최솟값 반환 .min(데이터1,데이터2)
       제곱근 반환 .sqrt(데이터)
       제곱값 반환 .pow(데이터,차수)
       0이상 1미만의 무작위 난수 생성 .random()

    3.String 클래스
     : 문자열 조작을 위한 다양한 메서드를 제공
     >> 객체명.메서드
     - 문자열길이 반환 .length()
       문자열 비교  A.equals(B)
     - substring(start index, end index)
       : 시작 인덱스 이상 끝 인덱스 미만까지의 부분 문자열을 반환다
         인덱스 번호는 0부터 시작한다. 공백과 기호까지 인덱스 번호에 포함된다.
     - indexOf(String);
       : 문자열에서 특정 문자열의 첫 번째 위치를 반환한다.
     - charAt(index);
       : 특정 위치의 문자를 반환한다

 */

class MyClass { //extends Object 생략

    private int id;
    private String name;

    MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Object 클래스 - toString() 메서드
    //오버라이딩 안 하면 클래스이름+주소값이 반환된다. chapter09.MyClass@3ac3fd8b
    @Override
    public String toString() {
        return "MyClass(ID : " + id + " / NAME : " + name + ")";
    }
}

public class C_JavaLang {
    public static void main(String[] args) {

        //Object 클래스 - toString() 메서드
        MyClass myClass1 = new MyClass(1, "이승아");
        System.out.println(myClass1.toString());

        //Object 클래스 - equals 메서드
        MyClass myClass2 = new MyClass(2, "백진우");
        System.out.println(myClass1.equals(myClass2));

        System.out.println("=========");

        //Math 클래스
        System.out.println(Math.abs(-10));  //절대값 반환 .abs(데이터)
        System.out.println(Math.max(100,200));  //최댓값 반환 .max(데이터1,데이터2)
        System.out.println(Math.min(100,200));  //최솟값 반환 .min(데이터1,데이터2)
        System.out.println(Math.sqrt(16));  //제곱근 반환 .sqrt(데이터)
        System.out.println(Math.pow(2,3));  //제곱값 반환 .pow(데이터,차수)
        System.out.println(Math.random());  //0이상 1미만의 무작위 난수 생성 .random()

        System.out.println("==========");

        //String 클래스
        String message = "Merry Christmas!";
        System.out.println(message.length());  //길이는 문자 및 공백과 기호까지 포함한다
        boolean isEqual = message.equals("Merry Xmas");
        System.out.println(isEqual);

        //substring(int start, int end)
        System.out.println(message.substring(6,15));
        System.out.println(message);  //문자열은 불변(immutable) 데이터이다

        //indexOf(String str);
        int index = message.indexOf("Chris");
        System.out.println(index);

        //charAt(int index);
        char c = message.charAt(6);
        System.out.println(c);
    }
}
