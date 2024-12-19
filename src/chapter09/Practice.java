package chapter09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        /*
            === 생일까지 남은 일수 계산 프로그램 만들기 ===
            사용자로부터 생년월일을 입력받고 다가오는 생일까지 남은 일수를 반환하시오

            1.사용자로부터 생년월일 입력받기 (YYYY-MM-DD)
            2.사용자 입력을 LocalDate로 변환 (formatter)
            3.현재날짜 구하기
            4.올해의 생일 계산
            5.생일이 지났다면 내년으로 설정
            6.남은 일수 계산
            7.결과 출력
         */

        Scanner sc = new Scanner(System.in);
        //생일 입력 받기
        //nextLine()으로 String(문자열) 받음
        System.out.print("생일을 입력하세요 : YYYY-MM-DD : ");
        String inputDate = sc.nextLine();  //2000-12-04 (-)하이폰 넣어주기

        //LocalDate 변환
        //parse : 분석하다  - parse(a,b) : a를 b의 형태로 재구성하다
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //M은 달, m은 분
        LocalDate birthDate = LocalDate.parse(inputDate, formatter); //문자열을 날짜로 변환 2000-12-04

        //현재날짜 구하기
        LocalDate today = LocalDate.now(); //2024-12-05
        //올해 생일 계산
        // .withYear() : 년도를 조작하는 메서드
        LocalDate nextBirthday = birthDate.withYear(today.getYear()); //2000-12-04 >> 2024-12-04
        //지난 생일 내년으로 처리
        if(nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1); //2025-12-04
        }
        //남은 일수 계산
        //ChronoUnit.DAYS. : java.time 패키지에서 날짜와 시간 간의 차이를 계산하는 함수
        long dayUntilBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        //결과 출력
        System.out.println("남은 생일까지 " + dayUntilBirthday + "일 남았습니다");




    }
}
