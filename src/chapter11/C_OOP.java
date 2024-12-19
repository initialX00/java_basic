package chapter11;

/*
    === SOLID원칙 ===
    1. SRP(단일 책임 원칙)
     - 클래스는 하나의 책임만 가져야 한다.
    2. OCP(개방-폐쇄 원칙)
     - 클래스는 확장에 열려있고, 수정에는 닫혀있어야한다.
    3. LSP(리스코프 치환 원칙)
     - 자식 클래스는 부모 클래스를 대체할 수 있어야한다.
    4. ISP(인터페이스 분리 원칙)
     - 클라이언트는 자신이 사용하지 않는 메서드에 의존하지 않아야한다.
    5. DIP(의존 역전 원칙)
     - 고수준 모듈이 저수준 모듈에 의존하지 않고, 추상화에 의존해야 한다.
 */

/// 주문관리 시스템 ///
//SRP : 각 클래스는 하나의 책임만 가진다
class Order {
    private String orderId;
    private int amount;

    public Order(String orderId, int amount){
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId(){return orderId;}
    public int getAmount(){return amount;}
}

//OCP, DIP : 확장 가능하도록 PaymentProcessor를 추상화
interface PaymentProcessor{
    void processPayment(Order order);
}

class CreditCardPaymentProcessor implements PaymentProcessor  {
    @Override
    public void processPayment(Order order){
        System.out.println("신용카드로 결제합니다 : " + order.getOrderId());
    }
}

class PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(Order order){
        System.out.println("페이팔로 결제합니다 : " + order.getOrderId());
    }
}


//ISP : 클라이언트가 불필요한 메서드에 의존하지 않도록한다.
interface GenerateReport {
    void generateReport(Order order);
}

class PdfReportGenerator implements GenerateReport {
    @Override
    public void generateReport(Order order) {
        System.out.println("주문 정보 보고서를 PDF 파일로 생성 : " + order.getOrderId());
    }
}


//DIP : 고수준 모듈이 저수준 모듈에 의존하지 않고, 추상화에 의존해야 한다
//고수쥰 모듈 : OrderService
class OrderService { //결제 방식과 보고서 생성의 인터페이스에 의존
    private final PaymentProcessor paymentProcessor; //저수준 모듈 : creditCardPaymentProcessor, PaypalPaymentProcessor
    private final GenerateReport generateReport;  //추상화 : PaymentProcessor, GenerateReport

    //OrderService생성자 : 결제 처리기와 보고서 생성기를 주입받는다
    public OrderService (PaymentProcessor paymentProcessor, GenerateReport generateReport){
        this.paymentProcessor = paymentProcessor; //결제처리기 초기화
        this.generateReport = generateReport; //보고서생성기 초기화
    }
    void placeOrder(Order order) {
        paymentProcessor.processPayment(order); //결제처리기에 결제로직 호출
        generateReport. generateReport(order); //보고서생성기의 생성로직 호출
        System.out.println("Order processed successfully"); //주문 처리 완료 메세지 출력
    }
}


public class C_OOP {
    public static void main(String[] args) {
        //CreditCardPaymentProcessor를 결제 처리기로 선택
        PaymentProcessor paymentProcessor = new CreditCardPaymentProcessor();
        //PdfReportGenerator를 보고서 생성기로 선택
        GenerateReport generateReport = new PdfReportGenerator();
        //DIP : 추상화 의존
        OrderService orderService = new OrderService(paymentProcessor, generateReport);

        Order order1  = new Order("1", 18000);
        Order order2  = new Order("2", 15000);
        Order order3  = new Order("3", 12000);
        orderService.placeOrder(order1);
        orderService.placeOrder(order2);
        orderService.placeOrder(order3);
    }
}
