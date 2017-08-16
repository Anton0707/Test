import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;


public class Main {

    public static void main(String[] args) {
        // create a new connection from MySQLJDBCUtil
        String sql = "SELECT productName, buyPrice " +
                "FROM products";

        String sqlUpdate = "UPDATE products "
                + "SET buyPrice = ? "
                + "WHERE productName = ?";

        try (Connection conn = JavaToMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate))
        {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("productName") + "\t" +
                        rs.getDouble("buyPrice"));

            }

            double buyPrice = 10;
            String  productName = "cap";
            pstmt.setDouble(1, buyPrice);
            pstmt.setString(2, productName);
            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}