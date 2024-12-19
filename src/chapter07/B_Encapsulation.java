package chapter07;

/*
    === 캡슐화(Encapsulation) ===
    : 객체지향 프로그래밍에서 데이터와 해당 데이터를 처리하는 함수를 하나로 묶는다
    - 객체 내부의 구현을 숨기고, 외부에서는 제공된 메서드를 통해서만 접근할 수 있게 설정한다.
    - 데이터 보호, 유지보수성 향상, 사용자 편의성 증대
    - 데이터 보호와 유지보수성 향상을 목적으로 데이터 필드(속성)를 private으로 선언하고,
      데이터에 접근하거나 수정할 때는 getter와 setter 메서드를 사용한다.

    === getter와 setter 메서드 ===
    : 캡슐화된 데이터에 안정하게 접근하고 수정하는 기능
    : setter는 입력값의 유효성을 검사하여 데이터의 일관성을 유지할 수 있다.
    - getter : 객체의 특정 필드 값을 읽는 메서드
            >>  get필드명();
    - setter : 객체의 특정 필드 값을 설정하는 메서드
            >> set필드명();
 */


//학생정보 관리 클래스
class Student {
    //private로 보호
    private String name;
    private int age;
    private int score;

    //getter setter로 접근
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){ //setter의 유효성 검사
        if (age < 0 ){
            System.out.println("유효하지 않은 나이입니다");
        } else{
            this.age = age;
        }
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){ //setter로  유효성 검사
        if(score >= 0 && score <= 100){
            this.score = score;
        } else{
            System.out.println("유효하지 않은 점수입니다");
        }
    }

}

public class B_Encapsulation {
    public static void main(String[] args) {
        Student student = new Student();
        //student.name = "이승아"; - getter,setter로 접근하기
        student.setName("이승아");
        student.setAge(50);
        student.setScore(100);
        System.out.println(student.getName());  //이승아
        System.out.println(student.getAge());  //50
        System.out.println(student.getScore());  //100

        student.setAge(-10);  //유효하지 않은 나이입니다
        student.setScore(111);  //유효하지 않은 점수입니다
    }

}
