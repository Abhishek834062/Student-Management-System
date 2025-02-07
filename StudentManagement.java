import java.util.Scanner;
class student
{
  int studentId;
  String name,gender,course,EmailId,phone;
  int age;
  
    public student(int studentId,String name,int age,String gender,String course,String EmailId,String phone)
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
     
  
  
    public static student addStudent()
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
       student s1=new student(id,name,age,gender,course,email,phone);

       return s1;
  }
  public static void viewStudent(student s1)
  {
            System.out.println(
                  "Student Id :"+s1.studentId+
                  "\n Name :"+s1.name+
                  "\n Age :"+s1.age+
                  "\n Gender :"+s1.gender+
                  "\n course :"+s1.course+
                  "\n Email id :"+s1.EmailId+
                  "phone :"+s1.phone

            );
  }

  public static void main(String[] args)
  {
   student s1= addStudent();
    viewStudent(s1);
    
  }
}
