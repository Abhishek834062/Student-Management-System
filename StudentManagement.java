import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Student class with required attributes and constructor
class Student {
    private int studentId;
    private String name;
    private int age;
    private String gender;
    private String course;
    private String emailId;
    private String phone;

    public Student(int studentId, String name, int age, String gender, String course, String emailId, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.emailId = emailId;
        this.phone = phone;
    }

    // Getter methods for accessing private attributes
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhone() {
        return phone;
    }

    // Method to print the details of the student
    public void printDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Course: " + course);
        System.out.println("Email: " + emailId);
        System.out.println("Phone: " + phone);
    }
}

public class StudentManagement {
    private static Scanner sc = new Scanner(System.in);

    // Method to handle input of student data with validation
    private static Student addStudent() {
        int id = getValidStudentId();
        String name = getValidStudentName();
        int age = getValidAge();
        String gender = getValidGender();
        String course = getValidCourse();
        String email = getValidEmail();
        String phone = getValidPhone();

        return new Student(id, name, age, gender, course, email, phone);
    }

    // Method to get a valid student ID with exception handling
    private static int getValidStudentId() {
        int id = 0;
        while (true) {
            try {
                System.out.print("Enter the Student ID: ");
                id = sc.nextInt();
                sc.nextLine(); // Clear buffer
                if (id <= 0) throw new IllegalArgumentException("Student ID must be a positive number.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid Student ID (only numbers).");
                sc.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    // Method to get a valid student name with exception handling
    private static String getValidStudentName() {
        String name = "";
        while (true) {
            try {
                System.out.print("Enter the name of the Student: ");
                name = sc.nextLine();
                if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    // Method to get a valid age with exception handling
    private static int getValidAge() {
        int age = 0;
        while (true) {
            try {
                System.out.print("Enter the age of the Student: ");
                age = sc.nextInt();
                sc.nextLine(); // Clear buffer
                if (age <= 0) throw new IllegalArgumentException("Age must be a positive number.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid age.");
                sc.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return age;
    }

    // Method to get a valid gender with exception handling
    private static String getValidGender() {
        String gender = "";
        while (true) {
            try {
                System.out.print("Enter the gender of the Student (Male/Female/Other): ");
                gender = sc.nextLine().trim();
                if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
                    throw new IllegalArgumentException("Invalid gender! Please enter Male, Female or Other.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return gender;
    }

    // Method to get a valid course name
    private static String getValidCourse() {
        System.out.print("Enter the course of the Student: ");
        return sc.nextLine();
    }

    // Method to get a valid email with exception handling
    private static String getValidEmail() {
        String email = "";
        while (true) {
            try {
                System.out.print("Enter the email ID of the Student: ");
                email = sc.nextLine();
                if (!email.contains("@") || !email.contains(".")) {
                    throw new IllegalArgumentException("Invalid email format! Must contain '@' and a domain.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return email;
    }

    // Method to get a valid phone number with exception handling
    private static String getValidPhone() {
        String phone = "";
        while (true) {
            try {
                System.out.print("Enter the phone number of the Student: ");
                phone = sc.nextLine();
                if (!phone.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Invalid phone number! Must be exactly 10 digits.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }

    // Method to display all students in the list
    private static void viewStudents(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : studentList) {
            student.printDetails();
            System.out.println("-----------------------------");
        }
    }

    // Main method to handle program flow
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        while (true) {
            try {
                System.out.println("""
                        1. Add Student
                        2. View Student List
                        3. Exit
                        """);
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        studentList.add(addStudent());
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        viewStudents(studentList);
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option! Please choose 1, 2 or 3.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                sc.nextLine(); // Clear buffer
            }
        }
    }
}
