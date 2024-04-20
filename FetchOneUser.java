import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchOneUser {
    static void fetchOne(String usrContact){
        try{
            Connection con = JDBCconnection.createConnection();
            String q = "SELECT * FROM contactdetails WHERE usrContact = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,usrContact);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                String usrName = resultSet.getString("usrName");
                String usrMail = resultSet.getString("usrMail");
                String usrCity = resultSet.getString("usrCity");
                String usrState = resultSet.getString("usrState");
                int usrZip = resultSet.getInt("usrZip");
                usrContact = resultSet.getString("usrContact");

                System.out.println("Username: " + usrName);
                System.out.println("Email: " + usrMail);
                System.out.println("City: " + usrCity);
                System.out.println("State: " + usrState);
                System.out.println("Zipcode: " + usrZip);
                System.out.println("Contact: "+ usrContact);
                System.out.println();
            }
            else{
                System.out.println("No records found.");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void showDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number:");
        String usrContact = sc.nextLine();
        fetchOne(usrContact);
    }
}
