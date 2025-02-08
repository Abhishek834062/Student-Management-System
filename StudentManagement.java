import java.util.ArrayList;
import java.util.Scanner;
class Student
{
  int studentId;
  String name,gender,course,EmailId,phone;
  int age;
  
    public Student(int studentId,String name,int age,String gender,String course,String EmailId,String phone)
    {
      this.studentId=studentId;
      this.name=name;
      this.age=age;
      this.course=course;
      this.gender=gender;
      this.EmailId=EmailId;
      this.phone=phone;
  
    }
  
  }
  public class StudentManagement{
    static Scanner sc=new Scanner(System.in);
     
  
  
    public static Student addStudent()
    {
      int id,age;
      String name,gender,course,email,phone;
  
       System.out.println("Enter the Student ID");
       id=sc.nextInt();
       System.out.println("Enter the name of Student");
       sc.nextLine();
       name=sc.nextLine();
       System.out.println("Enter the age of Student");
       age=sc.nextInt();
       System.out.println("Enter the gender of Student");
       gender=sc.next();
       System.out.println("Enter the course of Studetn");
       course=sc.next();
       System.out.println("Enter the email Id of Studetn");
       email=sc.next();
       System.out.println("Enter the phone number of Student");
       phone=sc.next();
       Student s1=new Student(id,name,age,gender,course,email,phone);

       return s1;
  }
  public static void viewStudent(ArrayList<Student> studentList)
  {

        for(Student s1:studentList)
        {
            System.out.println(
                  "Student Id :"+s1.studentId+
                  "\n Name :"+s1.name+
                  "\n Age :"+s1.age+
                  "\n Gender :"+s1.gender+
                  "\n course :"+s1.course+
                  "\n Email id :"+s1.EmailId+
                  "\n phone :"+s1.phone+"\n"

            );
  }
  }
  public static void main(String[] args)
  {
    ArrayList<Student> studentList=new ArrayList<Student>();
    

      stop:
     while(true)
     {

      System.out.println("""
      1 AddStudent in studentList 
      2 view student List 
      3 exist """);
      System.out.print("Type input :");
     int n=sc.nextInt();

    switch (n) {
      case 1:
         studentList.add(addStudent());
        break;
     case 2:
        viewStudent(studentList);
        break;
        case 3:
            break stop;
      
      default:
      System.out.println("Wrong input");
        break;
     }
     }
    
  }
}
