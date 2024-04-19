package practice._04_19;

import java.sql.*;

public class ExamplePrepareStat {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSQL = "SELECT * FROM employees WHERE employeeNumber = ?";
            PreparedStatement mystmt = conn.prepareStatement(selectSQL);
            mystmt.setInt(1, 1002);
            ResultSet result = mystmt.executeQuery();

            while (result.next()) {
                String name = result.getString("firstName");
                String email = result.getString("email");
                System.out.println(name + " | " + email);
            }

            conn.close();
            mystmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}