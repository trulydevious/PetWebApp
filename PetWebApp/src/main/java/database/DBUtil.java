package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * This class is used for connection with database.
 */
public abstract class DBUtil {

    abstract List<Groomer> getGroomersList() throws Exception;

    protected static void close(Connection conn, Statement statement, ResultSet resultSet){

        try{
            if(resultSet != null)
                resultSet.close();

            if(statement != null)
                statement.close();

            if(conn != null)
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
