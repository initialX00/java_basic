package chapter07Other;

//부모클래스
public class OtherClass {
    //protected 같은 패키지 또는 하위 클래스에서만 접근 가능
    protected String otherField = "다른 패키지의 필드";
    protected void otherMethod(){
        System.out.println("다른 패키지에 있는 부모클래스");
    }

    public static void main(String[] args) {
        //public
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();
    }

    
}
