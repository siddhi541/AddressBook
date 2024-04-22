package AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class FetchAllUsers {
    static void fetchAll(){
        try{
            Connection con = JDBCconnection.createConnection();
            String q = "select * from contactdetails";
            PreparedStatement pstmt = con.prepareStatement(q);

            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("User details:-");
            System.out.printf("%-15s %-15s %-15s %-15s  %-10s  %-15s\n", "Username", "Email", "City", "State", "Zipcode","Contact");
            System.out.println("-------------------------------------------------------------------------------------------------");

            while(resultSet.next()){
                String usrName = resultSet.getString("usrName");
                String usrMail = resultSet.getString("usrMail");
                String usrCity = resultSet.getString("usrCity");
                String usrState = resultSet.getString("usrState");
                int usrZip = resultSet.getInt("usrZip");
                String usrContact = resultSet.getString("usrContact");

                System.out.printf("%-15s %-15s %-15s %-15s  %-10d  %-15s\n", usrName, usrMail, usrCity, usrState, usrZip, usrContact);
            }
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void fetchWhere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("City / State: ");
        String str = sc.nextLine();
        if(str.equals("City")|| str.equals("city")){
            fetchByCity();
        }
        else{
            fetchByState();
        }
    }

    static void fetchByCity(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter city: ");
            String usrCity = sc.nextLine();
            Connection con = JDBCconnection.createConnection();
            String q = "select * from contactdetails where usrCity = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, usrCity);

            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("User details:-");
            System.out.printf("%-15s %-15s %-15s %-15s  %-10s  %-15s\n", "Username", "Email", "City", "State", "Zipcode","Contact");
            System.out.println("-------------------------------------------------------------------------------------------------");

            while(resultSet.next()){
                String usrName = resultSet.getString("usrName");
                String usrMail = resultSet.getString("usrMail");
                usrCity = resultSet.getString("usrCity");
                String usrState = resultSet.getString("usrState");
                int usrZip = resultSet.getInt("usrZip");
                String usrContact = resultSet.getString("usrContact");

                System.out.printf("%-15s %-15s %-15s %-15s  %-10d  %-15s\n", usrName, usrMail, usrCity, usrState, usrZip, usrContact);
            }
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void fetchByState(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter state: ");
            String usrState = sc.nextLine();
            Connection con = JDBCconnection.createConnection();
            String q = "select * from contactdetails where usrState = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, usrState);

            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("User details:-");
            System.out.printf("%-15s %-15s %-15s %-15s  %-10s  %-15s\n", "Username", "Email", "City", "State", "Zipcode","Contact");
            System.out.println("-------------------------------------------------------------------------------------------------");

            while(resultSet.next()){
                String usrName = resultSet.getString("usrName");
                String usrMail = resultSet.getString("usrMail");
                String usrCity = resultSet.getString("usrCity");
                usrState = resultSet.getString("usrState");
                int usrZip = resultSet.getInt("usrZip");
                String usrContact = resultSet.getString("usrContact");

                System.out.printf("%-15s %-15s %-15s %-15s  %-10d  %-15s\n", usrName, usrMail, usrCity, usrState, usrZip, usrContact);
            }
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
