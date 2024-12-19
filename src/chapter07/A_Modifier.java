package chapter07;

/*
    === 접근 제어자(제한자) ===
    : 클래스, 메서드, 변수의 접근 범위를 제어하여
      외부로부터 데이터를 보호하고 객체 간의 의존성을 최소하하는 역할을 한다.
    - 캡슐화를 구현하여 코드의 보안성을 향상시킨다.

    1. 접근 제어자 종류
    : private, default, protected, public
    - 접근 제어자가 지정되지 않은경우 default(기본값)으로 지정된다.
    - 클래스의 경우 클래스 자체에는 접근 제한자를 사용하지 않는다.
    - 클래스의 경우 중첩 클래스의 경우에 사용한다(클래스 내부에 클래스가 있는 경우 파일명 클래스에서 사용)

    2. 접근 제어자 범위
    : public > protected > default > private
     1)private
       : 같은 클래스 내에서만 접근이 가능하다
       : private 성정 된 속성과 메서드는 해당 클래스 내부에서만 읽을 수 있다.
     2)default
       : 같은 패키지 내라면 접근이 가능하다
       : 패키지 외부에서는 접근이 불가능하다
     3)protected
       : 동일한 패키지 내에서는 모든 클래스 내에서 접근 가능
       : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근이 가능하다.
     4)public
       : 다른 패키지에서도 제한없이 접근가능
 */




import chapter07Other.OtherClass;
import chapter07Other.PublicClass;

/*
    === 자바 패키지 또는 클래스 파일 간의 코드 연결 ===
    : import문을 사용
    1)같은 패키지 내 >> import 클래스파일명;
    2)다른 패키지 내 >> import 패키지명.클래스파일명;
 */


//public class modifier {} //파일 클래스 내부가 아니여서 Error

class PrivateClass {
    private int myField;
    private void myMethod(){}
}
class DefaultClass {
    int myField;
    void myMethod(){}
}
class ProtectedClass extends OtherClass { //자식클래스, 임포트 필요
    //같은 패키지 내에서는 모든 클래스에서 접근 가능
    protected int myField;
    protected void myMethod(){}
    //다른 패키지의 경우 상속받은 하위 클래스에서만 접근 가능
    ProtectedClass(){
        System.out.println(super.otherField); //상속받은 부모클래스의 필드, 자식과 이름이 같으므로 super
        otherMethod(); //상속받은 부모클래스의 메서드
    }
}
class NotProtectedClass{
    NotProtectedClass(){
        //System.out.println(OtherClass.otherField);
        //otherField has protected access in chapter07Other.OtherClass
    }
}


public class A_Modifier {
    public class modifier {} //중접 클래스에서만 접근 제한자 사용 가능.
    public static void main(String[] args) {
        //private 같은 클래스 내에서만 접근가능
        PrivateClass privateClass = new PrivateClass();
        //privateClass.myField;
        //privateClass.myMethod();

        //default 같은 패키지 내에서만 접근가능
        DefaultClass defaultClass = new DefaultClass();
        defaultClass.myField = 10;
        defaultClass.myMethod();

        //protected 같은 패키지 자유, 다른 패키지는 상속필요.
        ProtectedClass protectedClass = new ProtectedClass(); //다른 패키지
        protectedClass.myField = 20; //같은 패키지
        protectedClass.myMethod(); //같은 패키지

        //public 다른 패키지여도 자유롭게 접근가능
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();



    }
}
