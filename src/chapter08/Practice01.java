package chapter08;

//추상클래스
//: 모바일 애플리케이션
abstract class MobileApp {
    //추상 메서드
    //: 실행에 대한 동작 정의
    //- 반드시 각 앱마다 고유한 실행을 정의
    abstract void execute();

    //일반(구현) 메서드
    //: 앱정보 출력
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

//게임 애플리케이션
class GameApp extends MobileApp {
    //추상메서드 정의
    void execute () {
        System.out.println("Game app executes");
    }
}
//SNS 애플리케이션
class SocialApp extends MobileApp {
    String name;

    SocialApp(String name){
        this.name = name;
    }
    //추상메서드 정의
    void execute () {
        System.out.println(name + " app executes");
    }
    //일반 메서드의 재정의, 오버라이딩
    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social app");
    }
    //socialApp 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares : " + content);
    }
}

public class Practice01 {
    public static void main(String[] args) {
        //다형성 적용
        MobileApp gameApp = new GameApp(); //업캐스팅
        MobileApp socialApp = new SocialApp("Instagram");

        //다형성에 의해 공통 메서드는 호출 가능
        gameApp.execute();
        gameApp.appInfo(); //추상(부모) 클래스의 일반메서드
        socialApp.execute();
        socialApp.appInfo(); //자식 클래스에 재정의된 메서드
        //socialApp.shareContent("images"); - 자식클래스의 고유메서드에 접근불가

        //형 변환(Type Casting)
        //MobileApp 타입을 SocialApp 타입으로 변환하여 고유 메서드 사용
        if(socialApp instanceof GameApp) {
            System.out.println("socialApp은 GameApp입니다");
            GameApp onlyGameApp = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            System.out.println("socialApp은 SocialApp입니다");

            SocialApp onlySocialApp = (SocialApp) socialApp;
            onlySocialApp.shareContent("images"); //자식클래스의 고유메서드 사용
        }

        //객체 배열과 다형성 활용
        //배열 선언 및 초기화 >> 데이터타입[] 변수명 = {요소}
        MobileApp[] apps = { //배열로 생성 및 업캐스팅 - MobileApp apps = new GameApp();
                            new GameApp(),
                            new SocialApp("Facebook"),
                            new SocialApp("Twitter")
                            };

        for(MobileApp app : apps) {
            app.execute();
            app.appInfo();
            //SocialApp인지 확인하고 고유 메서드 사용
            if(app instanceof SocialApp){
                SocialApp specificSocialApp = (SocialApp) app; //다운캐스팅
                specificSocialApp.shareContent("Files");
            }
        }
    }
}
