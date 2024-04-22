package AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUser {

    static void updateUser(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter contact number: ");
            String usrContact = sc.nextLine();

            if(CheckElement.checkContact(usrContact)){
                System.out.println("Previous user details: ");
                FetchOneUser.fetchOne(usrContact);

                Connection con = JDBCconnection.createConnection();
                String q = "UPDATE contactdetails SET usrName = ?, usrMail = ?, usrCity = ?, usrState = ?, usrZip = ? WHERE usrContact = ?";

                System.out.println("Enter username: ");
                String usrName = sc.nextLine();

                if(CheckElement.checkName(usrName)){
                    System.out.println("Username already exists");
                    return;
                }
                System.out.println("Enter email: ");
                String usrMail = sc.nextLine();

                System.out.println("Enter city:");
                String usrCity = sc.nextLine();

                System.out.println("Enter state:");
                String usrState = sc.nextLine();

                System.out.println("Enter zipcode:");
                int usrZip = sc.nextInt();
                sc.nextLine();

                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, usrName);
                pstmt.setString(2, usrMail);
                pstmt.setString(3, usrCity);
                pstmt.setString(4, usrState);
                pstmt.setInt(5, usrZip);
                pstmt.setString(6, usrContact);
//                pstmt.setString(7, usrContact);
                pstmt.executeUpdate();

                System.out.println("Updated user details: ");
                FetchOneUser.fetchOne(usrContact);
            }
            else{
                System.out.println("No record found");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
