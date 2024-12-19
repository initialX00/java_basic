package chapter01;

import java.util.Scanner;

public class D_IO {
    // class 내부의 실행을 담당하는 메인 메서드 : ma + 자동완성(ctrl + space)
    public static void main(String[] args) {
        //  자바 기본 입출력 IO(Input, Output)
        //입력: 콘솔창을 통해 개발자로부터 입력을 받는 것
        //출력: 콘솔창으로 데이터를 출력하는 것

        //  1.출력
//        sout으로 자동완성
//        System.out.println(출력하고자하는 변수 또는 상수 또는 데이터 값);
        System.out.print("안녕하세요");
        System.out.println("반갑습니다 :)");
        System.out.println("해당 줄은?");
        System.out.print("안녕");
        System.out.println("하세요");


        //  2.입력
        //: 자바 내장 Scanner 객체를 사용한다
        //: 다양한 입력 소스로부터 데이터를 읽어올 수 있는 형태
        //: System.in(콘솔 창에서 표준 입력 스트림을 사용)

        //import java.util.Scanner;

        //1)스캐너 생성
        //Scanner(스캐너타입) 변수명 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        //2)스캐너 실행
        //스캐너명.next();  입력 내용을 문자열로 반환
        //스캐너명.nextLine(); 엔터까지의 전체 라인을 문자열로 반환
        //스캐너명.nextInt();
        //스캐너명.next데이터타입();

        System.out.println("정수를 입력해주세요 >> ");
        int age = sc.nextInt();

        System.out.println("키를 입력해주세요 >> ");
        int height = sc.nextInt();

        //버퍼에 남아있는 개행(Enter) 처리
        sc.nextLine();

        System.out.println("이름을 입력해주세요 >> ");
        String name = sc.nextLine();

        System.out.println("입력한 나이: " + age);
        System.out.println("입력한 키: " + height);
        System.out.println("입력한 이름: " + name);


        //  개행 문자(Enter) + 버퍼
        //: nextInt()나 nextDouble()의 경우
        //  버퍼에 개행 문자가 입력으로 처리되는 문제가 발생한다
        //> 처리방법 : nextLine()의 입력 메서드 호출로 버퍼의 데이터를 사용한다

        //  스캐너 종료 방법
        //: 스캐너 사용 후 메모리 체적화를 위해 스캐너 종료
        // 스캐너명.close();

        sc.close();
//      sc.next(); -Error(Scanner closed) 종료했기에 실행 안됨.
    }
}
