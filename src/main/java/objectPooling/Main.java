package objectPooling;

import java.sql.Connection;

public class Main {
    public static void main(String args[]) {
        // Create the ConnectionPool:
        RestPool restPool = new RestPool();
        JDBCConnectionPool pool = new JDBCConnectionPool();

        // Get a connection:
        Connection con = pool.takeOut();
        // Return the connection:
        pool.takeIn(con);
    }

}