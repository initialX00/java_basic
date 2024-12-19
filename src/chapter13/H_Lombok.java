package chapter13;

/*
    Lombok(롬복) 라이브러리
    : 보일러플레이트(순차적) 코드를 줄여주는 라이브러리이다
    - 어노테이션을 사용하여 코드를 간결하게 만들어준다.
     cf)보일러플레이트 코드 : 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화된 코드

    1. @Getter /@Setter 어노테이션
    : 필드에 대한 getter와 setter 메서드를 자동으로 생성해준다.

    2. @ToString 어노테이션
    : 클래스의 toString() 메서드를 자동으로 구현한다
    - sout(객체명)으로 작성하고 객체에 입력된 값을 출력한다.
    - sout에 객체를 출력하는 경우 다음과 같이 출력된다.
      클래스명(필드명1=필드값1, 필드명2=필드값2)

    3. 생성자 어노테이션
     cf) 매개변수 = parameter(params), 인자 - argument(args)
     1) @NoArgsConstructor : 기본 생성자 - final있으면 불가
     2) @RequiredArgsConstructor : 필수 필드 생성자 - final에 주로 사용
     3) @AllArgsConstructor : 전체 필드 생성자

    4. @Data 어노테이션
    : @Setter, @Getter, @ToString, @RequiredConstructor, @EqualsAndHashCode
      5가지 어노테이션을 한번에 적용하는 어노테이션이다.

    5. @Builder 어노테이션
    : 복잡한 객체를 생성할 때 사용하는 빌더 패턴을 자동으로 구현한다.
    - @Builder 어노테이션을 사용하는 빌더 패턴의 경우 필드 값을 모두 메서드 체이닝으로 가져온다.
    >> 클래스명.builder().build();
    - 필수값을 builder()메서드의 인자로 받지 않는다.
    - 메서드 체이닝 내에서 누락 시 오류가 난다.

    6. @NonNull
    : 필드에 필수값을 지정한다.
      null 값이 들어갈 수 없음을 의미한다

    cf) (필드) final 키워드 - 참조 데이터타입의 기본값으로 null이 포함 가능하다
 */

import lombok.*; //*는 전체를 의미하기에 라이브러리 전부를 들고왔다.
//import lombok.Getter; 등등 포함

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor - @Data에 폼함
@Data
@AllArgsConstructor
//@NoArgsConstructor - final이 있어서 불가
@Builder




class LombokClass{
    @NonNull
    private final String title; //final은 초기화 필요
    private String author;

//    public String getTitle() {return title;} 게터 어노테이션으로 대체
//    public String getAuthor() {return author;}

    // toSting() 메서드 : Object 객체 클래스 내의 메서드로 클래스 내의 데이터의 문자열을 출력한다
//    @Override
//    public String toString() {
//        return "Title : " + title + "Author : " + author;
//    }
//    LombokClass(String title) { final의 초기화 선언
//        this.title = title;
//    }
    //Builder 클래스
    //: 프로젝트 전역적인 접근이 가능하다
//    public static class Builder {
//        private final String title;
//        private String author = "작가 미상";
//        //빌더 클래스의 인자 - 필수 필드값
//        public Builder(String title) {
//            this.title = title;
//        }
//        //선택 필드값 설정을 위한 메서드
//        public Builder author(String author){
//            this.author = author;
//            return this;
//        }
//        //만들어진 Builder의 인스턴스를 LombokClass에 전달하는 build 메서드
//        public LombokClass build() {
//            return new LombokClass(this);
//        }
//    }
//    // build 메서드 내에서 호출될 생성자
//    // : Builder 패턴으로 만들어진 필드값들을 전달 받는 생성자
//    public LombokClass(Builder builder) {
//        this.title = builder.title;
//        this.author = builder.author;
//    }
}

public class H_Lombok {
    public static void main(String[] args) {
        LombokClass lombokClass1 = new LombokClass("Hello","LSA");
        //lombokClass1.setTitle("안녕"); fianl로 인해  재할당 불가
        lombokClass1.setAuthor("이승아");

        LombokClass lombokClass2 = new LombokClass("Medal", "gold");
        //lombokClass2.setTitle("메달"); fianl로 인해  재할당 불가
        lombokClass2.setAuthor("금");

        System.out.println(lombokClass1); //LombokClass(title=Hello, author=이승아)
        System.out.println(lombokClass2); //LombokClass(title=Medal, author=금)

        //정적내부 클래스 : 클래스명.내부클래스()
//        LombokClass lombokClass3 = new LombokClass.Builder("노는게 제일 좋아")
//                .build();
//        System.out.println(lombokClass3.getAuthor()); //작가미상
//        LombokClass lombokClass4 = new LombokClass.Builder("뽀로롱")
//                .author("루피").build();
//        System.out.println(lombokClass4.getAuthor());

        LombokClass lombokClass3 = LombokClass.builder()
                .title("노는게 제일 좋아").build();
        System.out.println(lombokClass3.getAuthor()); //작가미상

        // @NonNull 어노테이션 필드는 반드시 생성 시 값의 할당이 이루어져야한다.
        LombokClass lombokClass4 = LombokClass.builder()
                .title("뽀로롱").author("루피").build();
        System.out.println(lombokClass4.getTitle());
        System.out.println(lombokClass4.getAuthor());
    }

}

