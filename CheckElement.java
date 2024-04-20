import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckElement {
    static boolean checkName(String usrName){
        try{
            Connection con = JDBCconnection.createConnection();
            String q = "Select * from contactdetails where usrName = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, usrName);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    static boolean checkContact(String usrContact){
        try{
            Connection con = JDBCconnection.createConnection();
            String q = "Select * from contactdetails where usrContact = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, usrContact);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
