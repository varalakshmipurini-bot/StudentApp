package controller;

import java.util.Scanner;
import dao.StudentDAO;

public class StudentController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.println("🚀 Starting StudentController...");

        while (true) {
            System.out.println("\n====== Student Management ======");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume leftover newline
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine(); // clear wrong input
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        dao.insertStudent(sc); // ✅ pass Scanner
                        break;
                    case 2:
                        dao.updateStudent(sc); // ✅ pass Scanner
                        break;
                    case 3:
                        dao.deleteStudent(sc); // ✅ pass Scanner
                        break;
                    case 4:
                        dao.viewAllStudents(); // no Scanner needed
                        break;
                    case 5:
                        System.out.println("👋 Exiting application");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("❌ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("❌ An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
