package chapter11;

/*
    === 결합도와 응집도 === (중요)
    1. 결합도 (낮은 결합도가 목표)
    : 두개의 클래스나 모듈이 얼마나 강하게 연결되어 있는지를 나타낸다.
    : 모듈과 모듈 간의 의존정도를 말한다.
    - 낮은 결합도란 두 모듈이 서로 독립적으로 동작하여 한쪽 모듈이 수정되어도 다른 한쪽에 영향을 안 미친다
    - 낮은 결합도는 프로그램을 유지보수하기 쉽게 만들고 새로운 기능을 추가하거나 기존 코드를 수정할 때 오류 발생 가능성을 낮춘다.

    2. 응집도 (높은 응집도가 목표)
    : 하나의 클래스나 모듈 안에서 관련된 작업들끼리 얼마나 잘 모여 있는지를 나타낸다.
    : 한 모듈 내의 구성요소들 간의 연관정도를 말하낟.
    - 높은 응집도란 하나의 클래스가 관련된 일만 하고 해당 일이 잘 명시되있는것을 말한다. (많은 일, 관련 없는 일을 하지 않는다)
    - 높은 응집도는 프로그램에 대한 이해를 높이고, 유지보수를 용이하게 한다.

    3. 결합도와 응집도의 관계
    : 낮은 결합도 + 높은 응집도
    : 각 클래스나 모듈이 독립적으로 동작하면서도 본인의 역할에 충실해야한다.
    : 유지보수가 쉽고 확장성이 좋다.

    4. 낮은 결합도와 높은 응집도 구현
    : 클래스 간의 의존성을 줄이고, 변경에 강한 구조를 작성해야한다
     1) 인터페이스와 다형성을 활용해야한다 (낮은 결합도)
      : 구현 클래스에 의존하지 않고, 인터페이스를 통해 서로 의존하게 구현한다 (DIP)
      - 구현이 변경되거나 확장되어도 인터페이스 규격에만 맞추면 동작한다.
     2) 의존성 주입 (Dependency Injection) (낮은 결합도)
      : 클래스가 직접 객체를 생성하지 않고, 외부에서 객체를 주입받도록 설계한다.
      - 객체 간의 강한 결합을 줄이고 변경에 유연성이 생긴다
     3) 단일 책임 원칙 (SRP) (높은 응집도)
      : 클래스는 단 하나의 책임만 가져야 한다.
     4) 캡슐화 (높은 응집도)
      : 필드를 private 설정하여, getter와 setter를 통해 접근한다.
      : 클래스의 내부 동작을 숨기고, 외부와의 상호작용을 최소화한다.

     복습)
     낮은 결합도 : 인터페이스와 다형성, 의존성 주입 등
     높은 응집도 : 단일 책임 원칙을 준수, 캡슐화, 모듈화(메서드 분리) 등

 */

/// 낮은 결합도 ///
//인터페이스 정의
interface Payment{
    void processPayment();
}
//구현클래스
class CreditCardPayment implements Payment {
    @Override
    public void processPayment(){
        System.out.println("신용카드로 결제합니다");
    }
}

class OrderClass {
    //의존성 주입 (Dependency Injection)
    //CreditCardPayment를 객체 생성하지 않고, Payment 추상객체를 사용한다
    private Payment payment;
    public OrderClass(Payment payment){
        this.payment = payment;
    }
    void checkout() {
        payment.processPayment();
    }
}

/// 높은 응집도 ///
class User{
    //캡슐화
    private String name;
    private String email;
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
    String getName(){return name;}
}

class UserRepository {
    public void save(User user) { //저장 로직 구현
        System.out.println("사용자 정보가 데이터베이스에 저장되었습니다");
    }
}
class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository repository){
        this.userRepository = repository;
    }
    public void registerUser(User user){ //회원가입 로직
        if(user.getName().isEmpty()){
            System.out.println("이름을 반드시 기입해주세요");
            return;
        }
        userRepository.save(user);
    }
}

public class D_Coupling_Cohesion {
    public static void main(String[] args) {
        /// 낮은 결합도 ///
        Payment payment = new CreditCardPayment(); //의존성 주입
        OrderClass order = new OrderClass(payment);
        order.checkout(); //신용카드로 결제합니다

    }
}
