package chapter07;

/*
    final 키워드
    : 변수, 메서드, 클래스에서 사용 가능하다

    1)변수 : 값을 변경할 수 없는 상수를 선언한다.
          : 상수를 지정하는 키워드, 한번만 초기화 가능하다, 재할당이 불가능하다.
          : 변수명을 대문자로 작성하고, 단어 사이에는 언더스코어(_)를 사용한다.
      >> final 데이터타입 변수명(대문자)
    2)메서드 : 자식클래스에서 재정의(오버라이드)할 수없는 메서드를 선언한다
            :상속받은 final 메서드는 자식클래스에서 재정의 되지 않는다.
             생략된 형태로만 사용이 가능하다. 호출해서만 사용가능하다.
      >> (접근제어자) final 반환타입 메서드명() {}
    3)클래스 : 상속될 수 없는 클래스를 선언한다.
            : 부모클래스로 사용할 수 없다.
      >> final class 클래스명 {}

    fianl의 장단점
    1)장점 : 불변성으로 안정성을 보장한다
    2)단점 : 유연성이 없이 그 자체로만 사용 가능하다.( 상속불가, 오버라이딩 불가 )
 */

class MyFinalClass{
    //final 변수
    final int FINAL_VALIABLE = 30;
    //final 메서드
    public final void myMethod(){
        System.out.println("재정의 할 수 없는 메서드");
    }
}

class ChildClass extends MyFinalClass{
    //재정의 불가
    //public void myMethod(){
        //myMethod() in chapter07.ChildClass cannot override myMethod() in chapter07.MyFinalClass.
        //overridden method is final
    //}
    //부모클래스의 메서드 호출. 재정의하지 않고 사용한다.
    ChildClass(){
        super.myMethod();
    }
}

//final 클래스
final class Example1 {}
//class Example2 extends Example1 {} - 상속불가
//cannot inherit from final chapter07.Example1

public class C_Final {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.myMethod();

    }
}
