package chapter08;

/*
    인터페이스
    Fruit 과일 인터페이스 정의
    - color: 추상 메서드
    - describe: 디폴트 메서드
    - printType: 정적 메서드
 */

interface Fruit {
    //인터페이스 추상 메서드는 public abstract가 생략되어있다
    //추상클래스의 추상메서드와는 다르다 (abstract 생략 불가)
    String color();
    //디폴트 메서드 - 재정의(오버라이딩) 가능
    default void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 과일의 모양은 동그랗습니다");
    }
    //정적메서드
    static void printType() {
        System.out.println("과일(Fruit)의 타입입니다");
    }
}


class Apple implements Fruit {
    public String color () {
        return "red";
    }
}


class Orange implements Fruit {
    public String color() {
        return "orange";
    }
}


class Banana implements Fruit {
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 과일의 모양은 깁니다");
    }
}

//extends(상속 - 확장하다) : 클래스 간에, 인터페이스 간에 사용 가능 - 같은 구조끼리
//implements(구현 - 구현하다) : 인터페이스를 클래스로 구현 - 다른 구조끼리
//또다른 인터페이스, 인터페이스끼리의 확장
interface TropicalFruit extends Fruit {
    default void tropicalFeature() {
        System.out.println("열대과일은 후숙하면 더 맛있습니다");
    }
    //Fruit의 메서드 3개 + TropicalFruit의 메서드 1개 총 3개의 메서드가 있다
}


class Mango implements TropicalFruit {
    public String color() {
        return "golden";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 과일의 모양은 타원입니다");
    }


}


public class Practice02 {
    public static void main(String[] args) {
        //다형성 적용
        Fruit apple = new Apple(); //업캐스팅
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();


        Fruit[] fruits = { apple, orange, banana, mango}; //mango가 Fruit로 다시한번 업캐스팅
        for (Fruit fruit : fruits) {
            fruit.describe();
            //instanceof 인터페이스의 구조(메서드의 갯수 등)를 비교함.
            //망고는 Fruit의 메서드 3개 + Mango의 메서드 1개의 총 4개의 메서드 구조를 가지고 있다.
            if(fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit; //다운캐스팅하여 자식클래스의 메서드 접근
                tropicalFruit.tropicalFeature(); // 열대 과일은 후숙하면 더 맛있습니다.
            }
        }

        //망고는 Fruit의 메서드를 가지고 있으므로, 동일한 구조를 포함하고 있어서 참이다
        if (mango instanceof Fruit) {
            Fruit mangoAsFruit = (Fruit) mango;
            mangoAsFruit.describe(); // 과일의 색상은golden이며, 모양은 타원형입니다.
        }

        //바나나는 TropicalFruit에서 추가된 메서드 하나를 안 가지고 있으므로 부정이다.
        if (banana instanceof TropicalFruit) {
            TropicalFruit bananaAsTropical = (TropicalFruit) banana;
            bananaAsTropical.tropicalFeature();
        } else{
            System.out.println("바나나는 열대과일이 아닙니다");
        }

        Fruit.printType(); //과일(Fruit)의 타입입니다


        /*
            cf) A instanceof B 연산자
             : A 객체가 B 클래스(종류)와 같은지 확인하는 도구
         */
        class 동물 {}
        class 고양이 extends 동물 {}
        class 강아지 extends 동물 {}
        동물 애니멀 = new 동물();
        동물 야옹이 = new 고양이();
        동물 멍멍이 = new 강아지();
        //고양이 고양이변환 = (고양이) 애니멀;  - 형 변환이 불가능한 상황
        System.out.println(야옹이 instanceof 고양이);  //참
        System.out.println(멍멍이 instanceof 고양이);  //부정
        System.out.println(멍멍이 instanceof 동물);  //참
        System.out.println(애니멀 instanceof 고양이);  //부정

    }
}
