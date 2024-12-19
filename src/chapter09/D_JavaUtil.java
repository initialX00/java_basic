package chapter09;

/*
    === java.util 패키지 ===
    : 자바 표준 라이브러리 중 하나
    - 데이터의 구조, 시간과 날짜 처리, 무작위 숫자 생성 등의 기능을 포함한다
    - 외부에 있는 클래스를 import하여 사용한다.

    시간과 날짜 처리 클래스
    1. Date 클래스
    : 날짜와 시간을 표현
    : 현재의 밀리초 단위까지 반환한다.
    >> Date 객체를 생성하여 인스턴스 필드와 메서드를 활용한다.
    1) toString(): 날짜와 시간을 문자열로 반환한다
    2) getTime(): 1970년 1월 1일 00:00:00 (UTC)부터 현재시간까지의 밀리초(ms)를 반환한다. 날짜 계산에 사용한다
       (UTC : 시간대의 기준점, 한국은 UTC + 8:30, 근데 일본이 9:00라서 9사용)
       ex) 어제날짜 - 오늘날짜 = 하루

    2. Calendar 클래스
    : 날짜와 시간을 조작하거나 필드를 개별적으로 제어할 수 있는 도구
    - 추상 클래스이며 getInstance() 메서드를 통해 구현 객체를 반환받아 사용한다.
    1) .getInstance() : 현재 날짜와 시간으로 초기화된 Calendar 객체를 반환한다.
    2) .get(int field) : 지정된 필드 값을 반환한다.
       Calendar.YEAR
       Calendar.MONTH (MONTH는 0~11을 반환하기에 +1 해줘야 한다)
       Calendar.DAY_OF_MONTH
    3) .set(int year, int month, int day) : 날짜 설정

 */

import java.util.Calendar;
import java.util.Date;

public class D_JavaUtil {
    public static void main(String[] args) {
        //Date 클래스
        Date date = new Date();
        System.out.println("현재 날짜와 시간 : " + date.toString());  //Thu Dec 05 14:12:44 KST 2024
        System.out.println("현재까지의 밀리초 : " + date.getTime());  //1733375564329
        System.out.println("=========");

        //Calendar 클래스
        Calendar calendar = Calendar.getInstance(); //선언한 기점으로 시간 초기화
        System.out.println(calendar.get(Calendar.YEAR));  //2024
        System.out.println(calendar.get(Calendar.MONTH) + 1);  //12
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));  //5
        calendar.set(2025,3,14);
        System.out.println(calendar.get(Calendar.YEAR));  //2025
        System.out.println(calendar.get(Calendar.MONTH));  //3
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));  //14


    }
}
