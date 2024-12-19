package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

//학교 클래스
@AllArgsConstructor
@Getter
class School {
    private String schoolName;
    //내부클래스
    @AllArgsConstructor
    class Student {
        private String studentName;
        private int studentId;

        public void displayInfo() {
            System.out.println("학교명 " + schoolName + ", 학생이름 " + studentName + ", 학생ID " + studentId);
        }
    }
    //내부 클래스 - 싱글톤
    static class Principal {
        private static Principal instance;
        private Principal() {}
        public static Principal getInstance(){
            if(instance == null) {
                instance = new Principal();
            }
            return instance;
        }
        public void displayInfo() {
            System.out.println("훈화말씀 : 주저리주저리주러리주러지주저리주저리루젖지줄저");
        }
    }
}
public class B_Inner {
    public static void main(String[] args) {
        School school = new School("감천초등학교");
        School.Student student1 = school.new Student("백진우", 3);
        student1.displayInfo(); //학교명 감천초등학교, 학생이름 백진우, 학생ID 3

        //Principal : 정적 내부클래스로 외부클래스의 인스턴스 없이 내부 static 메서드 호출이 가능하다
        //getInstance() 내부에 new 연산자가 있으므로 new 키워드는 생략한다.
        School.Principal principal = School.Principal.getInstance();
        principal.displayInfo(); //훈화말씀 : 주저리주저리주러리주러지주저리주저리루젖지줄저

    }
}
