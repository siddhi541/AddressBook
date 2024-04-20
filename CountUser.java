import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountUser {
    static void countUser(){
        try{
            Connection con = JDBCconnection.createConnection();
            String q = "Select Count(*) as row_count from contactdetails";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(q);
            if (resultSet.next()){
                int rowCount = resultSet.getInt("row_count");
                System.out.println(rowCount + "users present in an addressbook");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
