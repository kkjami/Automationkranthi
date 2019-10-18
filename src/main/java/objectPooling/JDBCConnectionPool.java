package objectPooling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Three methods are abstract
// and therefore must be implemented by the subclass

public class  JDBCConnectionPool extends ObjectPool<Connection> {
    String dsn, usr, pwd;

    Connection create() {
        try {
            return (DriverManager.getConnection(dsn, usr, pwd));
        } catch (SQLException e) {
            e.printStackTrace();
            return (null);
        }
    }

    void dead(Connection o) {
        try {
            ((Connection) o).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean validate(Connection o) {
        try {
            return (!((Connection) o).isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}


