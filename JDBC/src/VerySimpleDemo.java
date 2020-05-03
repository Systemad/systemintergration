import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class VerySimpleDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Properties p = new Properties();
        p.load(new FileInputStream("JDBC/src/settings.properties"));


        try(Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name from child")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                //String city = rs.getString("city");

                System.out.println("Id: " + id + " name " + name ); //+ "city" + city);
            }
        }
        catch(SQLException e ){
            e.printStackTrace();
        }
    }
}
