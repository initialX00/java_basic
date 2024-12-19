package chapter08;

interface Flyable {
    int AVERAGE_SPEED = 100;
    //추상 메서드
    void fly(); //public abstract 생략

    //디폴트 메서드
    default void land() {
        System.out.println("Landing");
    }

    static int getWingCount(){
        return 2;
    }
}
class 종달새 implements Flyable {
    public void fly() {
        System.out.println("종달새의 속력은 새의 평균인 " + AVERAGE_SPEED + "km보다 느립니다");
    }
    @Override
    public void land() {
        System.out.println("사뿐");
    }
}
class 매 implements Flyable {
    public void fly() {
        System.out.println("매의 속력은 새의 평균인 " + AVERAGE_SPEED + "km보다 빠릅니다");
    }
    @Override
    public void land() {
        System.out.println("쿠웅");
    }
}



public class B_Interface02 {
    public static void main(String[] args) {
        매 bird1 = new 매();
        bird1.fly();
        bird1.land();

        종달새 bird2 = new 종달새();
        bird2.fly();
        bird2.land();

        System.out.println(Flyable.getWingCount());
    }
}
