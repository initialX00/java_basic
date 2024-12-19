package chapter01;

public class A_Variable {
    public static void main(String[] args) {
        //변수(Variable)
        //데이터를 저장할 수 있는 메모리 '공간'을 의미한다.

        // 1.변수 선언: 메모리 공간 생성
        //- 변수 선언 방법(그릇 생성 방법)
        //: 데이터타입 변수명;
        int num; // 정수선언
        char chr; // 문자선언
        boolean bool; // 논리선언 (true, false)

        // 2.변수 초기화(할당): 그릇에 데이터 넣기
        //- 처음 데이터를 넣는 과정: 초기화
        //- 데이터를 바꾸는 과정: (재)할당
        //: 변수명 = 데이터값; (이퀄이 아닌 대입,우에서 좌)

        num = 10;
        chr = '가';
        bool = true;

        // 3.변수 선언과 초기화는 동시에 가능하다
        //: 데이터타입 변수명 = 데이터값;

        int number = 10;
        char character = '가';
        boolean boolValue = false;

        // 변수 명명 규칙 //
        //- 문자, 숫자, 기호를 사용
        //- 대문자를 구분한다, 길이제한이 없다 (Name과 name이 다르다)
        //- 숫자로 시작할 수 없다
        //- 기호는 _(언더스코어)와 $(달러)만 사용가능하다
        //- 자바의 예약어, 키워드는 변수명으로 사용이 불가하다
        //- lowerCamelCase를 권장한다(첫단어는 소문자, 다음부터 첫글자는 대문자)
        //  전체 대문자 사용하지 않는다(상수와의 구분)

        //int 24num = 24; 오류
        int num24 = 24;
        int $24num = 24;
        //int *24num = 24; 오류

        num24 = 48; //변수는 재할당이 가능하다
        //char num24 = '가'  //변수는 재선언이 불가능하다


        //상수(Constant)
        //: 프로그램 실행동안 그 값이 변경되지 않는 변수
        //  선언과 동시에 반드시 초기화가 이루어져야한다.

        // 1. 상수 선언방법
        //- final 키워드를 사용하여 상수를 선언한다
        //: final 데이터타입 = 데이터값;

        // 2. 상수 명명 규칙
        //- UPPER_SNAKE_CASE 사용
        //- 모든 문자를 대문자 + 연결은 _(언더스코어)를 사용한다

        final int RESIDENT_NUMBER = 1234567;
        final double PI = 3.14159;



    }
}
