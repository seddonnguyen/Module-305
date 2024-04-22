package glab._3_1.DAOinterface;

import java.sql.*;

public class ConnectionDAO {
    static Connection con = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public static Connection getConnection() throws ClassNotFoundException {
        final String DBURL = "jdbc:mysql://localhost:3306/library";
        final String DBUSERNAME = "root";
        final String DBPASSWORD = "";
        try {
            con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            System.out.println("Connected Database Successfully");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return con;
    }

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}