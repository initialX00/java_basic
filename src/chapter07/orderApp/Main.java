package chapter07.orderApp;

//Main 클래스
//- 제품 생성, 주문 생성, 주문 결과 출력 등

public class Main {
    public static void main(String[] args) {
        //제품 생성
        Product laptop = new Electronics("Laptap",5000);
        Product apple = new Food("Apple", 6000);
        //주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);

        System.out.println(order1); //기기는 세금 15%이므로 5750
        System.out.println(order2); //음식은 세금 0%이므로 60000
    }
}
