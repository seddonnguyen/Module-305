package exercise.preparedstatement;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassExercisePreparedStatement {
/*
Create SQL PreparedStatements that would perform the following functionalities (you can use the "classicmodels" database):
    ● Select all employees whose officecode is 1 and 4.
    ● Select all orderdetails whose orderNumber is 10100 and 10102.
    ● Update the extension number of employees whose officecode is 2, and the new extension number will be "5698."
    ● Select all employees whose last name is less than five characters in length.
*/

    public static void main(String[] args) {
        try (Connection connection = DBConnection.connect("classicmodels")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuries.SELECT_EMPLOYEES_BY_OFFICECODE)) {
                System.out.println("Select all employees whose officecode is 1 and 4.");

                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, 4);
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                    String EmployeeID = result.getString("employeeNumber");
                    String fname = result.getString("firstName");
                    String lname = result.getString("lastName");
                    System.out.println(EmployeeID + " | " + fname + "|" + lname);
                }
                System.out.println();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuries.SELECT_ORDERDETAILS_BY_ORDERNUMBER)) {
                System.out.println("Select all orderdetails whose orderNumber is 10100 and 10102.");

                preparedStatement.setInt(1, 10100);
                preparedStatement.setInt(2, 10102);
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                    String orderNumber = result.getString("orderNumber");
                    String productCode = result.getString("productCode");
                    String quantityOrdered = result.getString("quantityOrdered");
                    System.out.println(orderNumber + " | " + productCode + "|" + quantityOrdered);
                }
                System.out.println();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuries.UPDATE_EMPLOYEES_EXTENSION)) {
                System.out.println("Update the extension number of employees whose officecode is 2, and the new extension number will be '5698.'");

                preparedStatement.setString(1, "5698");
                preparedStatement.setInt(2, 2);
                preparedStatement.executeUpdate();
                System.out.println();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuries.SELECT_EMPLOYEES_BY_LASTNAME)) {
                System.out.println("Select all employees whose last name is less than five characters in length.");

                preparedStatement.setInt(1, 5);
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                    String EmployeeID = result.getString("employeeNumber");
                    String fname = result.getString("firstName");
                    String lname = result.getString("lastName");
                    System.out.println(EmployeeID + " | " + fname + "|" + lname);
                }
                System.out.println();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}