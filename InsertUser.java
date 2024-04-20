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
            pstmt.setInt(5, user.usrZip);
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
        Scanner sc = new Scanner(System.in);
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

        System.out.println("Enter contact number:");
        String usrContact = sc.nextLine();
        if(CheckElement.checkContact(usrContact)){
            System.out.println("Contact already exists");
            return;
        }

        Main user = new Main(usrName, usrMail, usrCity, usrState, usrZip, usrContact);

        if (insertInDB(user)){
            System.out.println("User added successfully");
        }else {
            System.out.println("Something went wrong");
        }
    }
}
