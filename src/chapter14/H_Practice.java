package chapter14;

//컬렉션 프레임워크 & 스트림 API & 람다 표현식 & 메서드 참조

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//1.학생 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;
}

public class H_Practice {
    public static void main(String[] args) {
        //1. 학생 목록 필터링 & 정렬
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("이씨", 29, 4.0),
                new StudentClass("지씨", 24, 3.9),
                new StudentClass("정씨", 30, 2.6),
                new StudentClass("황씨", 31, 4.4)
        );
        //1-1.학점이 4.0이상인 학생 필터링
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());

        System.out.println("학점이 3.0이상인 학생 : ");
        filteredStudents.forEach(System.out::println);
        //StudentClass(name=이씨, age=29, grade=4.0)   StudentClass(name=황씨, age=31, grade=4.4)

        //1-2. 학생 이름 목록만 추출
        List<String> studentsNames = studentClasses.stream()
                //.map(studentClass -> studentClass.getName()) - 아래와 동일
                .map(StudentClass::getName)
                .collect(Collectors.toList());
        System.out.println("학생 이름 목록");
        System.out.println(studentsNames);  //[이씨, 지씨, 정씨, 황씨]

        //1-3. 학생들을 점수순으로 정렬
        List<StudentClass> sortedStudents = studentClasses.stream()
                //컬렉션 프레임워크의 중간 연산  .sorted(정렬)
                //Comparator클래스의  .comparingDouble 정적 메서드 활용 : 실수값들에 대한 비교
                .sorted(Comparator.comparingDouble(StudentClass::getGrade))
                //내림차순  .reversed()
                //.sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed())
                .collect(Collectors.toList());
        System.out.println("점수 순으로 정렬된 학생들");
        sortedStudents.forEach(System.out::println);
        //StudentClass(name=정씨, age=30, grade=2.6)
        //StudentClass(name=김씨, age=24, grade=3.9)
        //StudentClass(name=이씨, age=29, grade=4.0)
        //StudentClass(name=황씨, age=31, grade=4.4)


        //1-4. 학생들 중 '지' 단어가 포함된 학생 필터링
        List<StudentClass> studentsWithJi = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("지"))
                .collect(Collectors.toList());
        System.out.println("이름에 '지'가 포함된 학생 : ");
        studentsWithJi.forEach(System.out::println); //StudentClass(name=지씨, age=24, grade=3.9)



    }
}
