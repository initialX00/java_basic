package chapter12.model;

public class Student{
    private String name;
    private int age;
    private String studentId;

    public Student (String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public String getName(){ return name;}
    public int getAge() {return age;}
    public String getStudentId() {return studentId;}

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setStudentId(String StudentId) {this.studentId = studentId;}

    @Override
    public String toString() {
        return "이름 : " + name + ", 나이 : " + age + ", 아이디 : " + studentId;
    }
}