package chapter16;

/*
    1)ENUM 메서드 오버라이딩
     : ENUM은 상수별로 다른 동작을 정의할 수 있다
     - abstraact 메서드를 선언하고 상수별로 구현이 가능하다

     2)ENUM의 특징
     - 타입 안정성을 제공한다. 상수에 허용되지 않은 값을 지정되는걸 방지한다.
     - 가독성을 향상시킨다. 상수의 집합을 하나의 열거형으로 표현한다.

     3)ENUM의 제한
     - 값의 집합이 고정된 경우에만 사용해야한다.
     - Enum은 상속 지원은 불가하지만, 인터페이스 구현은 가능하다

     cf)Enum과 데이터베이스
     : 어노테이션을 활용한 매핑이 가능하다
 */

enum Operation {
    ADD {
        public int apply(int x, int y){
            return x + y;
        }
    },
    SUBTRACT {
        public int apply(int x, int y){
            return x - y;
        }
    };
    public abstract int apply(int x, int y); //Operation의 상수가 반드시 가져야할 추상 메서드
}

enum Season {
    SPRING("봄"),
    SUMMER("여름"),
    AUTUMN("가을"),
    WINTER("겨울");

    private final String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }
    public String getSeasonName() {
        return seasonName;
    }
}


public class C_ENUM {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(5,3)); //8
        System.out.println(Operation.SUBTRACT.apply(5,3)); //2

        Season season = Season.WINTER;

        switch(season){
            case SPRING:
                System.out.println("봄봄 봄이 왔어요");
                break;
            case SUMMER:
                System.out.println("여름 여름 여름이다");
                break;
            case AUTUMN:
                System.out.println("나 가능 타나봐요");
                break;
            case WINTER:
                System.out.println("메리크리스마스"); //메리크리스마스
                break;
        }

    }
}
