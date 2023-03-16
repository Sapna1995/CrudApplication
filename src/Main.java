import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        insertStudent1();
        selectStudent1();
        updateStudent1();
        deleteStudent1();
    }

    static void deleteStudent1()
    {
        int rollNo = sc.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement stmt = con.createStatement();
           int count = stmt.executeUpdate("delete from Student1 where rollNo='"+rollNo+"'");
           if(count>0){
               System.out.println("student is deleted from DB");
           }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void updateStudent1()
    {
        Student1 stud1 = new Student1();
        stud1.setRollNo(sc.nextInt());
        stud1.setName(sc.next());
        stud1.setEmail(sc.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement stmt = con.createStatement();
           stmt.executeUpdate("update Student1 set name='"+stud1.getName()+"', email='"+stud1.getEmail()+"' where rollNo='"+stud1.getRollNo()+"'");
           selectStudent1(stud1.getRollNo());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void selectStudent1(int rollNo)
    {
        Student1 stud1 = new Student1();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Student1 where rollNo = '"+rollNo+"'");
            while (rs.next()){
                stud1.setRollNo(rs.getInt(1));
                stud1.setName(rs.getString(2));
                stud1.setEmail(rs.getString(3));
            }
            System.out.println(stud1.getRollNo());
            System.out.println(stud1.getName());
            System.out.println(stud1.getEmail());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void insertStudent1()
    {

        Student1 stud1 = new Student1();
        stud1.setRollNo(sc.nextInt());
        stud1.setName(sc.next());
        stud1.setEmail(sc.next());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into Student1 values('"+stud1.getRollNo()+"','"+stud1.getName()+"','"+stud1.getEmail()+"')");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}