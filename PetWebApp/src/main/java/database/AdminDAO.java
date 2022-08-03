package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to get data from database assigned to administration user.
 * User is created in MySQL Server.
 */
public class AdminDAO extends DBUtil {

    private DBUtil dbUtil;
    private String url;
    private String login;
    private String password;

    /**
     * Constructor of AdminDAO class.
     * @param url
     */
    public AdminDAO(String url) {this.url = url;}

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

            conn = DriverManager.getConnection(url, login, password);
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
            close(conn, stat ,rs);
        }
        return groomer;
    }

    /**
     * This method is used to add groomer to database.
     * @throws Exception
     */
    public void addGroomer(Groomer groomer) throws Exception {

        Connection conn = null;
        PreparedStatement stat = null;

        try {
            conn = DriverManager.getConnection(url, login, password);
            String sql = "INSERT INTO groomers(id,name,website,openDays,city,pets) " + "VALUES(?,?,?,?,?,?)";

            stat = conn.prepareStatement(sql);
            stat.setInt(1, groomer.getId());
            stat.setString(2, groomer.getName());
            stat.setString(3, groomer.getWebsite());
            stat.setString(4, groomer.getOpenDays());
            stat.setString(5, groomer.getCity());
            stat.setString(6, groomer.getPets());
            stat.execute();

        } finally {
            close(conn, stat, null);
        }
    }

    /**
     * This method is used to find groomer by id in database.
     * @throws Exception
     */
    public Groomer getGroomer(String id) throws Exception{

        Groomer groomer = null;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;

        try{

            int groomerID = Integer.parseInt(id);
            conn = DriverManager.getConnection(url, login, password);
            stat = conn.prepareStatement("SELECT * FROM groomers WHERE id=?");
            stat.setInt(1, groomerID);
            rs = stat.executeQuery();

            if(rs.next()){
                groomer = new Groomer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("website"),
                        rs.getString("openDays"),
                        rs.getString("city"),
                        rs.getString("pets")
                );

            } else {
                throw new Exception("Nie ma takiego id " + groomerID);
            }
            return groomer;

        } finally {
            close(conn, stat, rs);

        }
    }

    /**
     * This method is used to update groomer's information in database.
     * @throws Exception
     */
    public void updateGroomer(Groomer groomer) throws Exception{

        Connection conn = null;
        PreparedStatement stat = null;

        try{

            conn = DriverManager.getConnection(url, login, password);
            String sql = "UPDATE groomers SET name=?, website=?, openDays=?, city=?, pets=? WHERE id=?";

            stat = conn.prepareStatement(sql);
            stat.setString(1, groomer.getName());
            stat.setString(2, groomer.getWebsite());
            stat.setString(3, groomer.getOpenDays());
            stat.setString(4, groomer.getCity());
            stat.setString(5, groomer.getPets());
            stat.setString(6, String.valueOf(groomer.getId()));
            stat.execute();

        } finally {
            close(conn, stat,null);
        }
    }

    /**
     * This method is used to delete groomer from database.
     * @throws Exception
     */
    public void deleteGroomer(String id) throws Exception{

        Connection conn = null;
        PreparedStatement stat = null;

        try{

            int groomerID = Integer.parseInt(id);
            conn = DriverManager.getConnection(url, login, password);
            String sql = "DELETE FROM groomers WHERE id=?";

            stat = conn.prepareStatement(sql);
            stat.setInt(1, groomerID);
            stat.execute();

        } finally {
            close(conn, stat,null);
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

