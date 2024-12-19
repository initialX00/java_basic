package chapter13;

/*
    === Singleton 패턴 ===
    : 소프트웨어 설계 패턴 중 하나
    >> 클래스의 인스턴스가 하나만 생성되도록 보장한다.
    >> 해당 클래스의 인스턴스에 전역적 접근을 제공하지만 일관된 상태를 유지한다.

    1. 싱글톤 패턴의 사용 목적
     1) 객체의 유일성을 보장한다
     2) 자원을 절약한다.

    2. 싱글톤 패턴의 장단점
     1)장점
        - 자원의 중복 생성을 방지하고, 메로리 사용을 최적화한다
        - 전역 상태를 공유하여 통제된 접근을 요구한다
     2)단점
        - 전역 상태를 관리하기때문에 다른 클래스에 영향을 미친다(결합의 가능성)
        - 테스트가 어렵다
 */

class Singleton {
    //클래스 타입 그 자체를 가지는 필드
    private static Singleton instance;
    //생성자를 private로 성언하여 외부에서 직접적인 인스턴스화가 불가능하다
    private Singleton() {};
    //전역 접근성을 제공하는 메서드 정의(인스턴스화 담당)
    public static Singleton getInstance() {
        if(instance == null) { //static 필드에 아무런 값이 없다면(한번도 인스턴스화를 하지 않았다면)
            instance = new Singleton(); // 인스턴스화를 진행
        }
        return instance;
    }
}

//교장 선생님 클래스
class SchoolPrincipal {
    //유일한 객체를 저장할 변수
    private static SchoolPrincipal instance;
    //1. 생성자를 private으로 만들어 다른 곳에서 객체 생성이 불가하도록 설정한다
    private SchoolPrincipal() {
        System.out.println("교장 선생님 객체 생성");
    }
    //2. getInstance() 메서드를 통해 객체를 제공
    public static SchoolPrincipal getInstance() {
        if(instance == null) { //객체를 생성하지 않았다면 객체생성
            instance = new SchoolPrincipal();
        }
        return instance; //객체를 이미 생성했다면 그대로 다시 반환
    }
    public void announce(){
        System.out.println("공부 열심히하시고 운동 열심히하시고 일찍 자고 일찍 일어나세요");
    }
}


public class D_Singleton {
    public static void main(String[] args) {
        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();
        //이미 객체가 생성되있다면 그대로 다시 반환되기에 참조 주소값이 같다.
        System.out.println(principal1);  //chapter13.SchoolPrincipal@3ac3fd8b
        System.out.println(principal2);  //chapter13.SchoolPrincipal@3ac3fd8b
        System.out.println(principal1 == principal2);  //true

    }
}
