package main;

import java.util.Scanner;
import dao.studentDAO;
import dao.studentDaoImpl;

public class mainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        studentDAO sd = new studentDaoImpl();
        System.out.println("                                      || WELCOME TO STUDENT MANAGEMENT SYSTEM ||");
        while (true) {
            
            System.out.println("1 : ADD STUDENT");
            System.out.println("2 : DISPLAY ALL STUDENTS");
            System.out.println("3 : SEARCH STUDENT BY ID");
            System.out.println("4 : UPDATE STUDENT DETAILS");
            System.out.println("5 : DELETE STUDENT RECORD");
            System.out.println("6 : EXIT");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    sd.addStudent();
                    break;

                case 2:
                    sd.displayStudent();
                    break;

                case 3:
                    sd.searchStudent();
                    break;

                case 4:
                    sd.updateStudent();
                    break;

                case 5:
                    sd.deleteStudent();
                    break;

                case 6:
                    System.out.println("Exiting Student Management System. Bye!");
                    return; 

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
