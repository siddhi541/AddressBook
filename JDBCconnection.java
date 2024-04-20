import java.sql.DriverManager;
import java.sql.Connection;

public class JDBCconnection {

    static Connection con;
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String usr = "root";
            String pass = "mysql123";
            String url = "jdbc:mysql://localhost:3306/addressbook";
            con = DriverManager.getConnection(url, usr,pass);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
