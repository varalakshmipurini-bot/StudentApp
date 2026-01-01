package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteStudent {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "tiger";

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 1);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No record found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
