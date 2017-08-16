import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by admin on 8/12/17.
 */
public class JavaToMySQL {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String mydir = "/Users/admin/IdeaProjects/test/resources/";
        File file = new File(mydir, "database.properties");
        try (FileInputStream f = new FileInputStream(file)) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}