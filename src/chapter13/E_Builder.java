package chapter13;

/*
    === 빌더(Builder) 패턴 ===
    1.빌더 패턴이란
    : 객체 생성 방법 중 하나로, 복잡한 객체를 단계별로 만들 때 사용한다
    - 필드(속성)가 많거나, 필수값과 선택값이 섞여있을 때 유용하다

    2.빌더 패턴의 장단점
     1) 장점
        - 가독성이 향상된다
        - 유연성이 증가한다
        - 확장성이 용이하다
     2) 단점
        - 구현 복잡성이 증가한다
        - 작은 객체에는 부적합하다

    3.빌더 패턴의 사용처
        - 생성자가 너무 많아질 때
        - 코드가 복잡하고 읽기 어려울 때

    4.빌더 패턴의 동작원리
     1) 객체를 생성하는데 필요한 데이터를 저장하는 Builder 클래스를 생성한다(해당 객체가 있는 클래스 내에 생성)
     2) Builder 클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드를 제공한다
     3) build() 메서드를 호출하여 객체를 생성한다.

     cf)//선택값은 final 선언하지 않음
        //선택적 필드는 기본값 설정이 되어있다(추가하지 않으면 지정한다)
 */


class Pizza {
    private final String menu; //종류
    private final String size; //크기
    private final boolean cheese; //선택사항
    private final boolean mushrooms; //선택사항
    private final boolean pepperoni; //선택사항

    //선택사항때문에 각 경우의 수 별로 생성자를 따로 만들어줘야해서 생성자가 많아진다
//    public Pizza(String menu, String size, boolean cheese, boolean mushrooms, boolean pepperoni) {
//        this.menu = menu;
//        this.size = size;
//        this.cheese = cheese;
//        this.mushrooms = mushrooms;
//        this.pepperoni = pepperoni;
//    }
    public static class Builder {
        private final String menu; //필수값은 final 선언함
        private final String size;
        private boolean cheese = false;  //선택값은 final 선언하지 않음
        private boolean mushrooms = false; //선택적 필드는 기본값 설정이 되어있다
        private boolean pepperoni = false; //(추가하지 않으면 지정한다)

        //필수값 설정 - 생성자
        public Builder(String menu, String size){
            this.menu = menu;
            this.size = size;
        }
        //선택값 설정 -인스턴스 메서드
        public Builder addCheese(){
            this.cheese = true;
            return this;
        }
        public Builder addMushrooms(){
            this.mushrooms = true;
            return this;
        }
        public Builder addPepperoni(){
            this.pepperoni = true;
            return this;
        }
        //만들어진 Builder의 인스턴스를 Pizza에 전달하는 build 메서드
        public Pizza build() {
            return new Pizza(this);
        }
    }
    // build 메서드 내에서 호출될 생성자 : Builder 패턴으로 만들어진 필드값들을 전달 받는 생성자
    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.pepperoni = builder.pepperoni;
    }
}

public class E_Builder {
    public static void main(String[] args) {
        //기존에는 생성자에 맞춰 모든 값을 맞춰서 넣어야한다
        //Pizza noBuilderPizza = new Pizza("파인애플", "L", false, false, false);

        Pizza builderPizza = new Pizza.Builder("고구마 피자", "M")
                .build();
        Pizza builderPizza1 = new Pizza.Builder("포테이토 피자", "M")
                        .addCheese().build();
        Pizza builderPizza2 = new Pizza.Builder("쉬림프 피자", "M")
                .addPepperoni().addMushrooms().build(); //순서무관

    }
}
