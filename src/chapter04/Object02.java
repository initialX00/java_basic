package chapter04;

public class Object02 {
    public static void main(String[] args) {
        /*
            객체 지향 프로그래밍 - 클래스와 객체

            1.클래스(Class) 정의
            : 객체를 만들기 위한 템플릿
              객체의 상태(속성)와 행동(메서드)을 정의한다.
            - 데이터와 기능의 구조를 정의하는 하나의 개념적인 틀이다
              메모리를 사용하는 실제 데이터가 아니다, 구조 정의이다
            - class 키워드를 사용하여 정의한다
              클래스 명은 UpperCamelCase를 사용한다.
             >> class 클래스명 {
                }

            2.객체(Object) 정의
            : 클래스에 정의된 속성과 메서드를 가지고 있는 '실체'이다.
              클래스를 기반으로 생성한다.
            - 클래스의 '인스턴스'라고 불리며 메모리에 할당된다.
            - 각 객체는 독립적인 상태와 행동을 가진다.
              다른 객체와 상호작용이 가능하다.

            cf) 인스턴스화 (객체 = 인스턴스)
                : 클래스라는 템플릿을 기반으로 객체를 만드는 과정
                : 이떄 만들어진 객체를 인스턴스(Instance)라고 부른다

         */

        /*
            3.클래스 선언 방법
            >> 접근제한자 class 클래스명 {
                    클래스가 가지는 속성과 행동을 정의
                    - 속성(필드)은 변수 선언
                    - 행동은 함수(메서드) 선언
                }

            4.접근 제한자(제어자)
            - 생략 가능하다
            - 클래스의 가시성을 정의한다(접근에 대한 권한을 부여)
              public, private, protected, default

              public: 모든 클래스에서 접근 가능
              private: 해당 클래스 내부에서만 접근 가능
              protected: 같은 패키지(폴더) 내부 또는 상속 관계에 잇는 클래스에서만 접근 가능
              default:  같은 패키지 내에서만 접근 가능 (기본값으로 생략할 때 지정된다)
         */

        class Car{
            //속성(필드) - 변수 선언 방식
            String title;
            String author;
            int[] pageNumber;
        }
        class Person{
            String name;
            int age;
            double height;
            boolean isStudent;
        }
    }
}
