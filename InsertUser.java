package AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUser {
    static boolean insertInDB(Main user){
        boolean flag = false;
        try{
            Connection con = JDBCconnection.createConnection();

            String q = "INSERT into contactdetails(usrName, usrMail, usrCity, usrState, usrZip, usrContact) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, user.usrName);
            pstmt.setString(2, user.usrMail);
            pstmt.setString(3, user.usrCity);
            pstmt.setString(4, user.usrState);
            pstmt.setString(5, user.usrZip);
            pstmt.setString(6, user.usrContact);
            pstmt.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }

    public static void addUser(){
        try{

            Scanner sc = new Scanner(System.in);
            String usrName, usrMail, usrCity, usrState, usrZip, usrContact;
            while (true){
                System.out.println("Enter username: ");
                usrName = sc.nextLine();
                if (CheckElement.checkName(usrName)){
                    System.out.println("Username already exist");
                }
                else {
                    break;
                }
            }

            while(true){
                System.out.println("Enter email: ");
                usrMail = sc.nextLine();
                if(!CheckRegex.isValidEmail(usrMail)){
                    System.out.println("Not valid Email");
                    System.out.println("You should have at least 4 or more characters\nDomain name should contain at least 3 or more characters\nAnd your mail should end with (.com, .net, .org, .edu, .gov, .co.in)");
                }
                else{
                    break;
                }
            }

            while(true){
                System.out.println("Enter city:");
                usrCity = sc.nextLine();
                if (!CheckRegex.isValidCity(usrCity)){
                    System.out.println("City name should not contain number or special character");
                }
                else {
                    break;
                }
            }

            while (true){
                System.out.println("Enter state:");
                usrState = sc.nextLine();
                if(!CheckRegex.isValidState(usrState)){
                    System.out.println("State name should not contain number or special character");
                }
                else {
                    break;
                }
            }

            while (true){
                System.out.println("Enter zipcode:");
                usrZip = sc.nextLine();
                if(!CheckRegex.isValidZip(usrZip)){
                    System.out.println("Zip code should only contain 6 digits");
                }
                else {
                    break;
                }
            }

//            sc.nextLine();



            while (true){
                System.out.println("Enter contact number:");
                usrContact = sc.nextLine();
                if(!CheckRegex.isValidContact(usrContact)){
                    System.out.println("Contact should only contain 10 digits");
                }
                else if(CheckElement.checkContact(usrContact)){
                    System.out.println("Contact already exists");
                }
                else {
                    break;
                }
            }

            Main user = new Main(usrName, usrMail, usrCity, usrState, usrZip, usrContact);

            if (insertInDB(user)){
                System.out.println("User added successfully");
            }else {
                System.out.println("Something went wrong");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
