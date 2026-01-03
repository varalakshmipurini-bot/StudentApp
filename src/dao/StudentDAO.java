package dao;

import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentDAO {

    // Pass Scanner from Controller
    public void insertStudent(Scanner sc) {
        try (Connection con = DBUtil.getConnection()) {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            String sql = "INSERT INTO student(id, name, marks) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);

            int i = ps.executeUpdate();
            if (i > 0) System.out.println("✅ Student inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Scanner sc) {
        try (Connection con = DBUtil.getConnection()) {

            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter new Name: ");
            String name = sc.nextLine();

            System.out.print("Enter new Marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            String sql = "UPDATE student SET name=?, marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, marks);
            ps.setInt(3, id);

            int i = ps.executeUpdate();
            if (i > 0) System.out.println("✅ Student updated successfully!");
            else System.out.println("❌ Student ID not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Scanner sc) {
        try (Connection con = DBUtil.getConnection()) {

            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i > 0) System.out.println("✅ Student deleted successfully!");
            else System.out.println("❌ Student ID not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudents() {
        try (Connection con = DBUtil.getConnection()) {

            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID\tNAME\t\tMARKS");
            System.out.println("--------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(id + "\t" + name + "\t\t" + marks);
            }

            if (!found) {
                System.out.println("❌ No records found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
