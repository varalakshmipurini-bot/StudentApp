package controller;

import dao.StudentDAO;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			StudentDAO dao = new StudentDAO();

			while(true) {
			    System.out.println("\n1. Insert Student");
			    System.out.println("2. Update Student");
			    System.out.println("3. Delete Student");
			    System.out.println("4. viewAllStudents");
			    System.out.println("5. Exit");
			    System.out.print("Enter choice: ");
			    int choice = sc.nextInt();

			    switch(choice) {
			        case 1: dao.insertStudent(); break;
			        case 2: dao.updateStudent(); break;
			        case 3: dao.deleteStudent(); break;
			        case 4:dao.viewAllStudents();break;
			        case 5: System.exit(0);
			        default: System.out.println("Invalid choice!");
			    }
			}
		}
    }
}
