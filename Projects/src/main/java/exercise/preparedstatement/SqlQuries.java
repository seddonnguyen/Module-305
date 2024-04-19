package exercise.preparedstatement;

public class SqlQuries {
    public static final String SELECT_EMPLOYEES_BY_OFFICECODE = "SELECT * FROM employees WHERE officeCode = ? OR officeCode = ?";
    public static final String SELECT_ORDERDETAILS_BY_ORDERNUMBER = "SELECT * FROM orderdetails WHERE orderNumber = ? OR orderNumber = ?";
    public static final String UPDATE_EMPLOYEES_EXTENSION = "UPDATE employees SET extension = ? WHERE officeCode = ?";
    public static final String SELECT_EMPLOYEES_BY_LASTNAME = "SELECT * FROM employees WHERE LENGTH(lastName) < ?";
}