package chapter04;

public class Object01 {
    public static void main(String[] args) {
        /*
            객체 지향 프로그래밍
            OOP(Object-Oriented Programming)
            1.객체란?
            : 데이터(속성)와 해당 데이터를 처리하는 방법(메서드)을 포함하는 프로그래밍의 기본 단위

            객체의 예시
             -커피자판기
             속성 : 커피의 종류, 가격, 현재 재고량, 물 온도
             기능 : 커피 제조, 재고 관리, 가격 설정
             -학교 관리 시스템
             학생 객체
              속성 : 학생 이름, 학번, 수강 과목
              기능 : 성적 조회, 수강 신청
             교수 객체
              속성 : 교수 이름, 연구 분야, 담당 과목
              기능 : 강의 계획서 업로드, 성적 입력
             수업 객체
              속성 : 과목명, 강의 시간, 강의실
              기능 : 강의 자료 업로드, 출석 체크
         */

        /*
            객체 지향 프로그래밍의 개념
            1.클래스(Class)
            : 객체를 생성하기 위한 템플릿, 데이터(속성)와 메소드(행동)을 정의
            ex) '자동차' 클래스
                - 속성(색상,브랜드, 모델)
                - 메소드(주행, 정지, 속도 변경)

            2.객체(Object)
            : 클래스의 인스턴스, 실제로 메모리에 할당되어 동작하는 구체적인 엔티티
            ex) '자동차' 클래스를 기반으로 만드러진 실제 자동차
                - 볼보 xc60 흰색 자동차

            3.상속(Inheritance)
            : 한 클래스(부모)의 속성과 메소드르르 다른 클래스(자식)가 받아서 사용하는 기능
            ex) '전기 자동차' 클래스
                - 일반 자동차 클래스의 모든 특성으 상속받고
                  추가적으로 배터리 관련 속성과 충전 메소드를 가짐

            4.다형성(Polymorphism)
            : 같은 메소드 호출이 다른 클래스의 객체에 대해 다른 방식으로 실행 가능
            ex) '주행'이라는 메소드(행동)는 '전기자동차' 객체에서는 전기를 사용
                                        '가솔린자동차' 객체에서는 가솔린을 사용

            5.캡슐화(Encapsulation)
            : 객체의 데이터를 외부로부터 숨기고 내부의 메소드를 통해서만 해당 데이터를 조작할 수 있게 하는것
            ex) 자동차의 엔진은 외부에서 직접 조작할 수 없다.
                엔진을 조작하기 위해서는 시동 버튼, 가속 페달 등을 사용한다.

            6.추상화(Abstraction)
            : 복잡한 세부사항을 숨기고 사용자에게 필요한 정보만을 제공한다
            ex) 자동차 운전자는 자동차의 모든 부품, 원리를 알지 않아도
                방향, 속도, 정지 등의 기본 기능만 이해하면 운전 할 수 있다.

            7.객체 지향 프로그래밍의 장점(중요성)
            - 재사용성 증가, 유지 보수성 증가, 확장성 증가

            8.자바(JAVA)에서의 객체 지향 프로그램
            - 코드의 모든 구조가 객체로 표현 가능하다.
              프로그램의 유연성과 모듈성 증가시킨다.

         */
    }
}
