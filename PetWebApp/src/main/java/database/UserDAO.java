package database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to get data from database assigned to basic user.
 * User is created in MySQL Server.
 */
public class UserDAO extends DBUtil {

    private DataSource dataSource;

    /**
     * Constructor of UserDAO class.
     * @param dataSource
     */
    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * This method is used to get list of groomers from database.
     * @return groomer
     * @throws Exception
     */
    @Override
    public List<Groomer> getGroomersList() throws Exception {

        List<Groomer> groomer = new ArrayList<>();

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM groomers");

            while (rs.next()) {
                groomer.add(new Groomer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("website"),
                        rs.getString("openDays"),
                        rs.getString("city"),
                        rs.getString("pets")
                ));
            }

        } finally {
            close(conn, stat, rs);
        }
        return groomer;
    }

}
