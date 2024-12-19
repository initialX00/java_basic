package chapter07.practiceApp;

/*
    App 클래스
    - Entitu의 객체(부모 1, 자식2)를 활용하는 시스템 구현하기

 */


public class App {
    public static void main(String[] args) {
        Weapon k2 = new Gun("K2", 10, 5);
        Weapon k1 = new Cannon("K1", 100, 5);
        Entity entity1 = new Entity(k2, 3);
        Entity entity2 = new Entity(k1, 2);
        System.out.println(entity1);
        System.out.println(entity2);


    }
}
