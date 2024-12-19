package chapter09;

/*
    === java.time 패키지 ===
    : 날짜와 시간을 다루는 도구 (명확성과 유연성을 제공한다)
    - java.util의 Date와 Calendar의 문제점을 보완하엿다.
    : ISO-8601 표준을 기반으로 설계됐다
    : YYYY-MM-DDThh:mm:ss.sssZ

    1.LocalDate - 날짜
     : 날짜(연도, 월, 일)
       .now() - 현재 날짜 반환
       .of(연도, 월, 일) - 특정 날짜 반환
       .plusDays(일), .plusMonths(월), .plusYears(년) - 입력값만큼 해당 값 증가
       .minusDays(일), .minusMonths(월), .minusYears(년) - 입력값만큼 해당 값 감소

    2.LocalTime - 시간
     : 시간(시, 분, 초, 나노초)를 다룬다
     - 날짜와 시간대 정보는 포함하지 않는다
       .now() = 현재 시간 반환
       .of(시, 분, 초) = 특정시간 반환
       .plusSeconds(초), .plusMinutes(분), .plusHours(시간) - 입력값만큼 해당 값 증가
       .minusSeconds(초), .minusMinutes(분), .minusHours(시간) - 입력값만큼 해당 값 감소

    3.LocalDateTime 클래스
      : 날짜와 시간을 함께 다루는 클래스
      : .now(), .of(), .plus~(), .minus~() 사용가능

       cf) get 메서드
          : getYear(), getMonth(), getDayOfMonth() : 날짜 정보 반환
            getHour(), getMinute(), getSecond() : 시간 정보 반환

        cf) 날짜와 시간 포맷팅(formatting)
          >> .ofPattern("yyyy-MM-dd HH:mm:ss");
           - M은 달, m은 분
           - 원하는 시간단위만 선택가능하다

 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class E_JavaTime {
    public static void main(String[] args) {
        //LocalDate - 날짜
        //: 날짜(연도, 월, 일)
        LocalDate today = LocalDate.now();
        System.out.println(today);  //2024-12-05

        LocalDate specificDate = LocalDate.of(2025,3,14);
        System.out.println(specificDate);  //2025-03-14
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);  //2024-12-06
        LocalDate oneMonthAgo = today.minusMonths(1);
        System.out.println(oneMonthAgo);  //2024-11-05
        System.out.println("=====");

        //LocalTime - 시간
        //: 시간(시, 분, 초, 나노초)를 다룬다
        LocalTime now = LocalTime.now();
        System.out.println(now);  //14:14:19.021782
        LocalTime specificTime = LocalTime.of(14,30);
        System.out.println(specificTime);  //14:30
        LocalTime Later = now.plusMinutes(33);
        System.out.println(Later);  //14:47:19.021782
        LocalTime Ago = now.minusHours(1);
        System.out.println(Ago);  //13:14:19.021782
        System.out.println("=====");

         //get 메서드
        System.out.println(today.getMonth());  //DECEMBER
        System.out.println(now.getHour());  //14

        //LocalDateTime 클래스
        // : 날짜와 시간을 함께 다루는 클래스
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);  //2024-12-05T14:14:19.021782
        System.out.println(nowDateTime.toLocalDate());  //2024-12-05
        System.out.println(nowDateTime.toLocalTime());  //14:14:19.021782

        //cf) 날짜와 시간 포맷팅(formatting)
        //    .ofPattern("yyyy-MM-dd HH:mm:ss");
        //    원하는 시간단위만 선택가능
        LocalDateTime example = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  //M은 달, m은 분
        System.out.println(example.format(formatter));  //2024-12-05 14:14:19
    }
}
