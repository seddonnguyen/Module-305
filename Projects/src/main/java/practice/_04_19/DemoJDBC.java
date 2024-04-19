package practice._04_19;

import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);

            String selectSQL = "SELECT * FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(selectSQL);

            while (result.next()) {
                String EmployeeID = result.getString("employeeNumber");
                String fname = result.getString("firstName");
                String lname = result.getString("lastName");
                System.out.println(EmployeeID + " | " + fname + "|" + lname);
            }

            connection.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}