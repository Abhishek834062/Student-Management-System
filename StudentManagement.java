import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int studentId;
    String name, gender, course, EmailId, phone;
    int age;

    public Student(int studentId, String name, int age, String gender, String course, String EmailId, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gender = gender;
        this.EmailId = EmailId;
        this.phone = phone;
    }
}

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);

    public static Student addStudent() {
        int id = 0, age = 0;
        String name = "", gender = "", course = "", email = "", phone = "";

        
        do {
            try {
                System.out.print("Enter the Student ID: ");
                id = sc.nextInt();
                sc.nextLine(); 
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid Student ID (only numbers).");
                sc.nextLine();
            }
        } while (true);

    
        do {
            try {
                System.out.print("Enter the name of Student: ");
                name = sc.nextLine();
                if (name.matches(".*\\d.*")) {
                    throw new Exception("Name cannot contain numbers.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

      
        do {
            try {
                System.out.print("Enter the age of Student: ");
                age = sc.nextInt();
                sc.nextLine();
                if (age <= 0) {
                    throw new Exception("Age must be a positive number.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid age.");
                sc.nextLine();
            }
        } while (true);

        
        do {
            try {
                System.out.print("Enter the gender of Student (Male/Female/Other): ");
                gender = sc.next();
                if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))) {
                    throw new Exception("Invalid gender! Enter Male, Female, or Other.");
                }
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        
        System.out.print("Enter the course of Student: ");
        course = sc.nextLine();

        
        do {
            try {
                System.out.print("Enter the email ID of Student: ");
                email = sc.next();
                if (!email.contains("@")) {
                    throw new Exception("Invalid email format! Must contain '@'.");
                }
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        
        do {
            try {
                System.out.print("Enter the phone number of Student (10 digits): ");
                phone = sc.next();
                if (!phone.matches("\\d{10}")) {
                    throw new Exception("Invalid phone number! Enter exactly 10 digits.");
                }
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new Student(id, name, age, gender, course, email, phone);
    }

    public static void viewStudent(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s1 : studentList) {
            System.out.println(
                    "Student ID : " + s1.studentId +
                            "\nName : " + s1.name +
                            "\nAge : " + s1.age +
                            "\nGender : " + s1.gender +
                            "\nCourse : " + s1.course +
                            "\nEmail ID : " + s1.EmailId +
                            "\nPhone : " + s1.phone + "\n"
            );
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            try {
                System.out.println("""
                        1. Add Student
                        2. View Student List
                        3. Exit
                        """);
                System.out.print("Type input: ");
                int n = sc.nextInt();
                sc.nextLine(); 

                switch (n) {
                    case 1:
                        Student newStudent = addStudent();
                        if (newStudent != null) {
                            studentList.add(newStudent);
                            System.out.println("Student added successfully!");
                        }
                        break;
                    case 2:
                        viewStudent(studentList);
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please select 1, 2, or 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                sc.nextLine();
            }
        }
    }
}
