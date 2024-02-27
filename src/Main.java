import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] students = new String[20];
        int counter = 0;

        while (true) {
            System.out.println("""
                    Select 1 operation from 4 operations:
                    1) Add student
                    2) Get all students
                    3) Update students
                    4) Delete student
                     """);
            switch (new Scanner(System.in).nextLine()) {
                case "1", "add": {

                    System.out.println("Write student name");
                    System.out.println(addStudent(students, new Scanner(System.in).nextLine(), counter++));
                    break;
                }
                case "2", "get": {
                    getAllStudents(students, counter);
                    break;
                }
                case "3", "update": {
                    System.out.println("Write students name to update: ");
                    updateStudent(students, new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine(), counter);
                    break;
                }
                case "4", "delete": {
                    System.out.println("What student do you wanna delete?");
                    String studentToDelete = new Scanner(System.in).nextLine();
                    System.out.println(deleteStudent(students, studentToDelete, counter));
                    break;
                }
            }
        }
    }

    public static String addStudent(String[] students, String studentName, int index) {
        students[index] = studentName;
        return studentName + "successfully added !!!";

    }

    public static void getAllStudents(String[] students, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println(students[i]);
        }
    }

    public static void updateStudent(String[] students, String oldName, String newName, int counter) {
        boolean isfind = false;
        for (int i = 0; i < counter; i++) {
            if (students[i].equals(oldName)) {
                students[i] = newName;
                isfind = true;
            }
        }
        if (!isfind) {
            System.out.println("Student with name: " + oldName + "is not found!");
        } else {
            System.out.println(oldName + " renamed to " + newName);
        }
    }

    public static String deleteStudent(String[] students, String studentName, int counter) {
        boolean isFound = false;
        for (int i = 0; i < counter; i++) {
            if (students[i] != null && students[i].equals(studentName)) {

                for (int j = 0; j < counter - 1; j++) {
                    students[j] = students[j + 1];

                }
                students[counter - 1] = null;
                isFound = true;
            }

        }
        if (isFound) {
            return studentName + " successfully deleted!";
        } else {
            return "Student with name: " + studentName + " is not found!";
            // CRUD
            // C - Create, add
            // R - Read, get
            // U - Update
            // D - Delete, remove
//    }
//
//    // C - Create, add
//    public static String addStudent(String[] students, String studentName, int index){
//        students[index] = studentName;
//        return studentName + " succesfully added !!!";
//    }
//    // R - Read, get
//    public void getAllStudent(){
//
//    }
//    // U - Update
//    public void update(){
//
//    }
//    // D - Delete, remove
//    public String  deleteStudent(){
//        return null;
        }
    }

}