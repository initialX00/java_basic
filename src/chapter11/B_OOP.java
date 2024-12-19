package chapter11;

/*
    === SOLID 원칙 === (중요)


    4. 인터페이스 분리 원칙 (ISP, Interface Segregation Principle)
    : 하나의 큰 인터페이스보다 여러개의 작은 인터페이스를 사용하는것을 권장한다.
    - 인터페이스의 단일 책임을 강조한다
    - 클래스는 자신이 사용하지 않는 메서드에 의존하지 않아야 한다.
    - SRP 인터페이스 버전 (상속 - 다중상속 불가, 인터페이스 - 다중구현 가능)
    - 다중구현을 통해 필요한 메서드만 상속

    5. 의존 역전 원칙 (DIP, Dependency Inversion Principle)
    : 고수준 모듈은 저수준 모듈에 의존해서는 안 되며, 둘 다 추상화에 의존해야한다.
    : 세부 구현이 아닌, 추상화된 인터페이스에 의존하도록 설계가 되어야한다.
    - 의존역전 원칙은 각 클래스간의 결합도(coupling)을 낮춘다


    cf) 모듈이란
        : 소프트웨어를 각 기능별로 나눈 소스코드의 단위이다
       모듈화란
        : 하나의 큰 소프트웨어를 분리시키는 과정을 말한다.
       >> 좋은 소프트웨어일수록 모듈의 목립성이 높다고 평가한다.
       >> 모듈의 독립성을 결합도(Coupling)와 응집도(Cohesion)의 기준 단계로 측정한다



 */

/// ISP ///
//잘못된 예시
interface Worker {
    void work();
    void eat();
}
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("로봇은 일을 할 수 있습니다");
    }
    public void eat() { //로봇은 먹는행위를 필요로하지 않지만 오류가 나지 않을려면 강제로 구현을 해야한다
        System.out.println("로봇은 음식을 필요로하지 않습니다");
    }
}
//올바른 예시
interface Workable{
    void work();
}
interface Eatable {
    void eat();
}
class WorkRobot implements Workable {
    @Override
    public void work(){ //사용하지 않는 eat 메서드를 구현하지 않아도 된다
        System.out.println("로봇은 일을 할 수 있습니다");
    }
}


/// DIP ///
//잘못된 예시
class Keyboard{
}
class Computer { //Computer가 Keyboard라는 구체적인 구현 클래스에 의존한다
    private Keyboard keyboard;
    public Computer(){
        this.keyboard = keyboard;
    }
}
//올바른 예시
interface InputDevice{
}
class Mouse implements InputDevice{
}
class Speaker implements InputDevice{
}
//DipComputer는 InputDevice라는 추상화에 의존하여
// 새로운 입력 장치가 추가되더라도 코드 수정 없이 확장이 가능하다
class DipComputer {
    private InputDevice inputDevice;
    public DipComputer(InputDevice inputDevice){
        this.inputDevice = inputDevice;
    }
}





public class B_OOP {
    public static void main(String[] args) {

    }
}
