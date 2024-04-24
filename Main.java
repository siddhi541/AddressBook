package AddressBook;

import java.util.*;

public class Main {

    String usrName;
    String usrMail;
    String usrCity;
    String usrState;
    int usrZip;
    String usrContact;

    Main(String usrName, String usrMail, String usrCity, String usrState, int usrZip, String usrContact){
        this.usrName  = usrName;
        this.usrMail = usrMail;
        this.usrCity = usrCity;
        this.usrState = usrState;
        this.usrZip = usrZip;
        this.usrContact = usrContact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to address book program");
        while(true){
            System.out.println("1. Add new contact\n2. Show details of a contact\n3. Edit contact\n4. Delete contact\n5. View all contacts for state or city\n6. Get a count of contacts\n7. View all records\n8. Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:

                    InsertUser.addUser();
                    break;

                case 2:
                    FetchOneUser.showDetails();
                    break;

                case 3:
                    UpdateUser.updateUser();
                    break;

                case 4:
                    DeleteUser.deleteContact();
                    break;

                case 5:
                    FetchAllUsers.fetchWhere();
                    break;

                case 6:
                    CountUser.countUser();
                    break;

                case 7:
                    FetchAllUsers.fetchAll();
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }
    }
}