package AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {

    static int deleteUser(String usrContact){
        try {
            if (CheckElement.checkContact(usrContact)){
                Connection con = JDBCconnection.createConnection();
                String q = "DELETE FROM contactdetails WHERE usrContact = ?";
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, usrContact);
                return pstmt.executeUpdate();
            }
            else {
                System.out.println("No record found");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    static void deleteContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number: ");
        String usrContact = sc.nextLine();

        if(deleteUser(usrContact) > 0){
            System.out.println("User deleted successfully");
        }
    }
}
