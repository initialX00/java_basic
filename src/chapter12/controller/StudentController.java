package chapter12.controller;

import chapter12.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;

    public StudentController(){
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String id) {
        Student student =  findStudentById(id);
        if(student != null) {
            System.out.println("해당 id의 학생이 이미 존재합니다");
            return;
        }

        students.add(new Student(name, age, id));
    }
    //전체 조회
    public List<Student> getAllStudents() {
        return students;
    }
    //단건 조회
    public Student findStudentById(String id) {
        for(Student student : students) {
            if(student.getStudentId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String id, String newName, int newAge) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String id) {
        for(Student student : students) {
            if (student.getStudentId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return false;

//        Student student = findStudentById(id);
//        if(student != null) {
//            student.remove(student);
//            return true;
//        }
//        return false;
    }
}
