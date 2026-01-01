package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "tiger"; // ⚠️ use your REAL password

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE student SET name=?, marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Lakhi");
            ps.setInt(2, 90);
            ps.setInt(3, 1);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record updated successfully");
            } else {
                System.out.println("No record found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
