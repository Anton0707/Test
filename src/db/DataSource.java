package db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Class DataSource
 *
 * Created by yslabko on 08/08/2017.
 */
public class DataSource {

    private static DataSource datasource;
    private ComboPooledDataSource pooledDatasource;

    private final String URL;
    private final String DRIVER;
    private final String USER;
    private final String PASSWORD;

    {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        if (rb == null) {
            URL = "UNDEFINED";
            USER = "UNDEFINED";
            PASSWORD = "UNDEFINED";
            DRIVER = "com.mysql.jdbc.Driver";
            System.out.println("Бандл для db не был инициализирован");
        } else {
            URL = rb.getString("jdbc:mysql://localhost/internet_shop");
            USER = rb.getString("root");
            PASSWORD = rb.getString("root");
            DRIVER = rb.getString("com.mysql.jdbc.Driver");
        }
    }

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        pooledDatasource = new ComboPooledDataSource();
        pooledDatasource.setDriverClass(DRIVER); //loads the jdbc driver
        pooledDatasource.setJdbcUrl(URL);
        pooledDatasource.setUser(USER);
        pooledDatasource.setPassword(PASSWORD);

        // the settings below are optional -- c3p0 can work with defaults
        pooledDatasource.setMinPoolSize(10);
        pooledDatasource.setAcquireIncrement(5);
        pooledDatasource.setMaxPoolSize(20);
        pooledDatasource.setMaxStatements(180);

    }

    public static synchronized DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return pooledDatasource.getConnection();
    }
}
