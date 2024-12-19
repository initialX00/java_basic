package chapter12.view;

import chapter12.controller.StudentController;
import chapter12.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final Scanner scanner;
    private final StudentController controller;

    public StudentView(){
        this.scanner = new Scanner(System.in);
        this.controller =new StudentController();
    }

    public void showMenu() {
        while(true) {
            System.out.println("===Student Management System===");
            System.out.println("1.Add a student");
            System.out.println("2.Show all students");
            System.out.println("3.Find a student");
            System.out.println("4.Update a student");
            System.out.println("5.Delete a student");
            System.out.println("6.Quit");
            System.out.print("Choose an option >> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentView();
                    break;
                case 2:
                    showAllStudentView();
                    break;
                case 3:
                    findStudentView();
                    break;
                case 4:
                    updateStudentView();
                    break;
                case 5:
                    removeStudentView();
                    break;
                case 6:
                    System.out.println("===Process Exit===");
                    return;
            }
        }
    }

    private void addStudentView() {
        System.out.println("Enter Student Name");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student StudentID");
        String id = scanner.nextLine();

        controller.addStudent(name, age, id);
        System.out.println("Student added successfully");
    }
    private void showAllStudentView() {
        List<Student> students = controller.getAllStudents();
        for (Student student : controller.getAllStudents()){
            System.out.println(student.toString());
        }
    }
    private void findStudentView(){
        System.out.println("Enter Student ID to find : ");
        String id = scanner.nextLine();
        Student student = controller.findStudentById(id);
        if(student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }
    private void updateStudentView() {
        System.out.println("Enter Student Id to update : ");
        String id = scanner.nextLine();
        System.out.println("Enter new Name : ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Age : ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        if(controller.updateStudent(id, newName, newAge)){
            System.out.println("Student updated successfuly");
        } else {
            System.out.println("Student not found");
        }
    }
    private void removeStudentView(){
        System.out.println("Enter Student Id to remove : ");
        String id = scanner.nextLine();
        if(controller.removeStudent(id)){
            System.out.println("Student remove successfuly");
        } else {
            System.out.println("Student not found");
        }
    }
}
