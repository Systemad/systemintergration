import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import static javax.swing.DropMode.INSERT;

public class Repository2 {

    private Connection con;
    private Properties p = new Properties();

    public Repository2() {
        try {
            p.load(new FileInputStream("JDBC/src/settings.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Child getChildByName(String name) {
        Child child = new Child();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM child WHERE name='" + name + "'");) {

            while (rs.next()) {
                child = new Child(rs.getInt("id"), rs.getString("name"), rs.getBoolean("nice"), rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return child;
    }

    public void updateTemp(float temp) {

        //String query = "update tomtedatabasedemoiot.child" +
        //        "set name = ?, address = ?, countryId = ?" +
        //        " where id = ?";

        String query1 = "INSERT INTO temperaturelog(temperature) VALUES (?)";

        //String query = "UPDATE tomtedatabasedemoiot.child SET name = ?, address = ?, countryId = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query1))
        {
            stmt.setFloat(1, temp);
            stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
