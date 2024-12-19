package chapter08;

/*
    === 인터페이스(interface) ===
    : 상호작용에 대한 약속, 객체가 어떤 방식으로 동작해야하는지 정의하는 추상 타입
    : 추상메서드와 상수만이 포함된 특수한 클래스
    - 모든 메서드는 추상메서드로 구성
    - 상수는 public static final 특성을 가져서 재정의 불가하다.
    - 실제 구현은 인터페이스를 구현한 클래스에서 담당한다.
    생성 >> interface 인터페이스명 {}
    구현 >> class 구현부클래스명 implements 생성부클래스명 {}



    1.인터페이스의 특징
     1)메서드
      : 모든 메서드는 기본적으로 public abstract로 선언된다 - 생략 가능
      - 모든 메서드가 추상메서드여야한다.
        해당 인터페이스 활용을 위해 모든 클래스에서 접근 가능하다(public)

     2)변수(필드)
      : 모든 변수는 기본적으로 public static final로 선언된 상수이다 - 생략 가능
      - final은 변수명은 대문자로 작성하고, 상수만 선언할 수 있다.

     3)다중 구현을 지원한다
      : 한 인터페이스에서 여러 인터페이스를 동시에 구현 가능하다.

     4)객체의 행동을 정의하는 역할을 수행한다.



    2.추상클래스와 인터페이스
     1) 추상 클래스
     - 공통적인 기능을 제공하는 '부분적 구현'
     - 구성요소 : 추상메서드, 구체메서드, 필드, 생성자
     - 단일 상속 가능 (extends,확장), 기본 구현을 제공하고 확장이 가능하다.

     2) 인터페이스
     - 클래스의 행동을 정의한다.
     - 구성요소 : 추상메서드, 상수(필드), 디폴트 메서드, 정적 메서드
     - 다중 구현 가능 (implements,구현), 객체가 해야할 동작을 정의한다.

      cf) 디폴트 메서드
        : 인터페이스에 새 기능을 추가하면서 기존 구현을 포함한 메서드
        - 기본 구현을 제공하고, 오버라이딩(재정의) 가능하다
        - default는 생략할 수 없다.
        >> default void 메서드명() {구현부}

      cf) 정적 메서드
        : 인터페이스에서 직접 구현한다.
        - 인터페이스 이름으로 직접 호출하며,
          오버라이딩이 불가능하다. (객체 인스턴스 없이 사용 가능하다)
        - 인터페이스와 관련된 공통 동작(유틸리티) 메서드를 제공하기 위해 사용한다.
        >> static 반환타입 메서드명() {구현부}



    3.인터페이스의 생성과 구현
     1)생성
      >> interface 인터페이스명 {}
      - 인터페이스의 모든 메서드는 기본적으로 public 접근제어자를 가진다
        인터페이스 자체가 '어떤 동작을 외부에서 사용할 수 있음'을 보장하기때문이다

     2)구현
      >> class 구현부명 implements 인터페이스명 {}
      - 구현부에서 메서드들은 default로 변경되어 public을 다시 지정해야한다.
      cf) public 지정
         인터페이스 안의 추상 메서드를 구현한 클래스 메서드는 public 지정을 해야한다.
      cf) 디폴트 메서드 재정의
         인터페이스 내의 티폴트 메서드 재정의 시 public 설정이 필요하다
 */

interface PlayingCard {
    //1. 멤버변수 : 상수 선언
    // public static final의 특성을 가짐, 생략가능
    public static final int SPADE = 4;
    public  int DIAMOND = 3; //생략 가능
    static final int HEART = 2; //부분누락 가능
    int CLOVER = 1;

    //2. 메서드
    // public abstract 특성을 가짐, 생략가능.
    public abstract String getCardNumber();
    String getCardKind(); //생략가능

    //3. 디폴트 메서드
    //>> default void 메서드명() {구현부}
    default void defaultMethod() {
        System.out.println("디폴트 메서드입니다");
    }
    //void noDefault() {} - 인터페이스의 디폴트메서드에서는 default를 생략할 수 없다

    //4. 정적 메서드
    //>> static 반환타입 메서드명() {구현부}
    static void staticMethod() {
        System.out.println("정적 메서드입니다");
    }
}

//인터페이스 구현
//implements 키워드 사용
class Card implements PlayingCard {
    private String cardNumber;
    private String cardKind;

    Card(String cardNumber, String cardKind){
        this.cardNumber = cardNumber;
        this.cardKind = cardKind;
    }

    //인터페이스 안의 추상 메서드를 구현한 클래스 메서드는 public 지정을 해야한다.
    public String getCardNumber() {
        return cardNumber;
    }
    public String getCardKind() {
        return cardKind;
    }

    //디폴트 메서드 재정의
    //인터페이스 내의 티폴트 메서드 재정의 시 public 설정이 필요하다
    @Override
    public void defaultMethod() {
        System.out.println("Card 클래스에서 재정의된 디폴트 메서드");
    }
    //cf)인터페이스의 모든 메서드는 기본적으로 public 접근제어자를 가진다
    //  : 인터페이스 자체가 '어떤 동작을 외부에서 사용할 수 있음'을 보장하기때문이다
}


public class B_Interface01 {
    public static void main(String[] args) {
        //인터페이스의 추상메서드 사용
        Card card = new Card("7", "HEART");
        System.out.println(card.getCardNumber());
        System.out.println(card.getCardKind());

        card.defaultMethod();

        //card.staticMethod();
        PlayingCard.staticMethod();

        System.out.println(PlayingCard.CLOVER);
        System.out.println(PlayingCard.DIAMOND);
        System.out.println(PlayingCard.HEART);
        System.out.println(PlayingCard.SPADE);

    }
}
