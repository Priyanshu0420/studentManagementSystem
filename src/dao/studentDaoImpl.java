package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.DBconnection;

public class studentDaoImpl implements studentDAO {
    public static Scanner sc = new Scanner(System.in);
     

    @Override
    public void addStudent() {

        String query = "INSERT INTO studentinfo(student_Name, age, course, student_email) VALUES (?, ?, ?, ?)";

        try (Connection connect = DBconnection.fetchDB();
             PreparedStatement ps = connect.prepareStatement(
                     query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            System.out.println("Enter details to add a student.....");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter the student age: ");
            int age = sc.nextInt();
            sc.nextLine();

            if (age < 18) {
                System.out.println("Student not eligible for admission!");
                return;
            }

            System.out.print("Enter the course: ");
            String course = sc.nextLine();

            System.out.print("Enter the student email: ");
            String email = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);

            int affected = ps.executeUpdate();

            if (affected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    System.out.println("Student Registered Successfully!");
                    System.out.println("Student ID is: " + generatedId);
                }
            } else {
                System.out.println("Error! Try Again...");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


	@Override
	public void deleteStudent() {
		// Implementing deleteStudent......
        String query="DELETE FROM studentinfo WHERE student_ID =?";
        try {
            Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        while(true){
            System.out.print("Enter the id : ");
            int id = sc.nextInt();
            sc.nextLine();
            ps.setInt(1, id);
            System.out.print("Wanna Delete more records : ");
            String choice=sc.nextLine();
                if(choice.toLowerCase().equals("no")){
                    break;
                }
            
        }
            int rs =ps.executeUpdate();
            if(rs>0){
                System.out.println("Record Deleted Scuccessfully!!!");
            }
            else{
                System.out.println("ERROR!! Try Again....");
            }

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}

	@Override
	public void updateStudent() {
		// Implementing updateStudent
        System.out.println("1: Update student name");
        System.out.println("2: Update student age");
        System.out.println("3: Update student course");
        System.out.println("4: Update student email");
        System.out.println("Choose the Operation : ");
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                updateStudentName();
                break;
            case 2:
                updateStudentAge();
                break;
            case 3:
                updateStudentCourse();
                break;
            case 4:
                updateStudentEmail();
                break;
            default:
                System.out.println("Operation not found!!!");
                break;
        }
        
	}

	@Override
	public void searchStudent() {
		// Implementing searchStudent
        String query="SELECT * FROM studentinfo WHERE student_ID =?";
        try {
             Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        System.out.print("Enter the Student ID : ");
        int id=sc.nextInt();
        sc.nextLine();
        ps.setInt(1, id);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            int ID= rs.getInt("student_ID");
            String NAME=rs.getString("student_Name");
            int AGE = rs.getInt("age");
            String COURSE = rs.getString("course");
            String EMAIL= rs.getString("student_email");
           System.out.println("-----------------------------------------");
            System.out.println("ID: "+ ID);
            System.out.println("NAME: "+NAME);
            System.out.println("AGE: "+AGE);
            System.out.println("COURSE: "+COURSE);
            System.out.println("EMAIL: "+EMAIL);
            System.out.println("-----------------------------------------");
             System.out.println();
        }else{
            System.out.println("-----------------------------------------");
            System.out.println("Student not found!!!");
            System.out.println("-----------------------------------------");
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}

	@Override
public void displayStudent() {

    String query = "SELECT * FROM studentinfo";

    try (Connection con = new DBconnection().fetchDB();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
                int st_id=rs.getInt("student_ID") ;
                String st_name=rs.getString("student_Name") ;
                int st_age=rs.getInt("age") ;
                String st_course=rs.getString("course") ;
                String st_email=rs.getString("student_email");
                System.out.println("-----------------------------------------");
                System.out.print("\nID: "+st_id+"\nNAME: "+st_name+"\nAGE: "+st_age+"\nCOURSE: "+st_course+"\nEMAIL: "+st_email+"\n-----------------------------------------");
                System.out.println();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
@Override
public void updateStudentName(){
    String query="UPDATE studentinfo SET student_Name =? WHERE student_ID =?";
    try {
        Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        System.out.print("Enter the Student ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Name : ");
        String newName=sc.nextLine();
        ps.setString(1, newName);
        ps.setInt(2, ID);
        int rs = ps.executeUpdate();
        if(rs>0){
            System.out.println("Name Updated Successfully!!");
        }else{
            System.out.println("Error Occured!! Try Again.....");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void updateStudentAge(){
    String query="UPDATE studentinfo SET age =? WHERE student_ID =?";
    try {
        Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        System.out.print("Enter the Student ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Age : ");
        int newAge=sc.nextInt();
        sc.nextLine();
        ps.setInt(1, newAge);
        ps.setInt(2, ID);
        int rs = ps.executeUpdate();
        if(rs>0){
            System.out.println("Age Updated Successfully!!");
        }else{
            System.out.println("Error Occured!! Try Again.....");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}

@Override
public void updateStudentEmail(){
    String query="UPDATE studentinfo SET student_email =? WHERE student_ID =?";
    try {
        Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        System.out.print("Enter the Student ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Age : ");
        String newEmail=sc.nextLine();
        sc.nextLine();
        ps.setString(1, newEmail);
        ps.setInt(2, ID);
        int rs = ps.executeUpdate();
        if(rs>0){
            System.out.println("e-mail Updated Successfully!!");
        }else{
            System.out.println("Error Occured!! Try Again.....");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}

@Override
public void updateStudentCourse(){
    String query="UPDATE studentinfo SET course =? WHERE student_ID =?";
    try {
        Connection connect=DBconnection.fetchDB();
        PreparedStatement ps=connect.prepareStatement(query);
        System.out.print("Enter the Student ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Course : ");
        String newCourse=sc.nextLine();
        sc.nextLine();
        ps.setString(1, newCourse);
        ps.setInt(2, ID);
        int rs = ps.executeUpdate();
        if(rs>0){
            System.out.println("Course Updated Successfully!!");
        }else{
            System.out.println("Error Occured!! Try Again.....");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}

