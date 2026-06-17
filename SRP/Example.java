import java.util.ArrayList;

class Student {
    int id;
    String name;
    int marks;
    char grade;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

class AddStudentData {
    ArrayList<Student> list = new ArrayList<>();

    // Add Student details
    public void addStudent(Student student) {
        list.add(student);
    }
}

class CalculateGrade {
    public void gradeCalc(Student student) {
        int marks = student.marks;
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        student.grade = grade;
        System.out.println(marks + " --> " + grade);
    }
}

class ReportPrinter {
    public void printReport(Student student) {
        System.out.println("----- Student Report -----");
        System.out.println("ID : " + student.id);
        System.out.println("Name : " + student.name);
        System.out.println("Marks : " + student.marks);
        System.out.println("Grade : " + student.grade);
    }
}

public class Example {
    public static void main(String args[]) {
        AddStudentData obj = new AddStudentData();

        Student std1 = new Student(1, "Venkat", 97);
        Student std2 = new Student(2, "Pawan", 78);
        Student std3 = new Student(3, "Kalyan", 55);
        Student std4 = new Student(4, "Veera", 46);
        // Adding Students
        obj.addStudent(std1);
        obj.addStudent(std2);
        obj.addStudent(std3);
        obj.addStudent(std4);
        // Calculating Grade

        CalculateGrade calc = new CalculateGrade();
        calc.gradeCalc(std1);
        calc.gradeCalc(std2);
        calc.gradeCalc(std3);
        calc.gradeCalc(std4);

        // Printing Grade Report

        ReportPrinter printer = new ReportPrinter();
        printer.printReport(std1);
        printer.printReport(std2);
        printer.printReport(std3);
        printer.printReport(std4);

    }
}