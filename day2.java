// import java.lang.*;
import java.util.*;

class day2{

    String usrName;
    String usrMail;
    String usrCity;
    String usrState;
    Long usrZip;
    Long usrContact;

    day2(String usrName, String usrMail, String usrCity, String usrState, Long usrZip, Long usrContact){
        this.usrName = usrName;
        this.usrMail = usrMail;
        this.usrCity = usrCity;
        this.usrState = usrState;
        this.usrZip = usrZip;
        this.usrContact = usrContact;
    }

    //add = 0, edit = 1
    static int takeInput(ArrayList<day2> usrDetails, int count, int addOrEdit, day2 usr){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter email: ");
            String mail = sc.nextLine();

            System.out.println("Enter city: ");
            String city = sc.nextLine();

            System.out.println("Enter state: ");
            String state = sc.nextLine();

            System.out.println("Enter zip code: ");
            Long zip = sc.nextLong();

            sc.nextLine();

            System.out.println("Enter contact number: ");
            Long contact = sc.nextLong();

            for(int i = 0; i < usrDetails.size(); i++){
              if(name.equals(usrDetails.get(i).usrName) || contact.equals(usrDetails.get(i).usrContact)){
                  System.out.println("Username or contact already exits");
                  System.out.printf("\n");
                  return count;
              }
            }
            if(addOrEdit == 0 && usr == null){
                addNew(name, mail, city, state, zip, contact, usrDetails);
                count++;
                System.out.println("Contact added successfully");
            }
            else{
                assignVal(name, mail, city, state, zip, contact, usr);
            }  
            return count;
        }
        catch(Exception e){
            System.out.println("Enter valid number for zip and contact");
            System.out.printf("\n");
            return count;
        }
        // return 0;
    }

    static void assignVal(String name, String mail, String city, String state, Long zip, Long contact, day2 usr){
        usr.usrName = name;
        usr.usrMail = mail;
        usr.usrCity = city;
        usr.usrState = state;
        usr.usrZip = zip;
        usr.usrContact = contact;
         
    }

    static void addNew(String name, String mail, String city, String state, Long zip, Long contact, ArrayList<day2> usrDetails){
        day2 usr = new day2(name, mail, city, state, zip, contact);
        usrDetails.add(usr);
        return;
    }

    static day2 fetchDetails(ArrayList<day2> usrDetails){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number: ");
        Long contact = sc.nextLong();
        for(int i = 0; i < usrDetails.size(); i++){
            if(contact.equals(usrDetails.get(i).usrContact)){
                return usrDetails.get(i);
            }
        }
        return null;
    }

    static void showDetails(ArrayList<day2> usrDetails){
        day2 usr = day2.fetchDetails(usrDetails);
        if(usr == null){
            System.out.println("No contact found");
            System.out.printf("\n");
        }
        else{
            System.out.println("Name: " + usr.usrName);
            System.out.println("Email: " + usr.usrMail);
            System.out.println("City: " + usr.usrCity);
            System.out.println("State: " + usr.usrState);
            System.out.println("Contact: " + usr.usrContact);
            System.out.println("Zip: " + usr.usrZip); 
            System.out.printf("\n");          
        }
    }

    static void editContact(ArrayList<day2> usrDetails, int count){
        day2 usr = day2.fetchDetails(usrDetails);
        if(usr == null){
            System.out.println("No contact found");
            System.out.printf("\n");
            
        }
        else{
            System.out.println("Previous Name: " + usr.usrName);
            System.out.println("Previous Email: " + usr.usrMail);
            System.out.println("Previous City: " + usr.usrCity);
            System.out.println("Previous State: " + usr.usrState);
            System.out.println("Previous Contact: " + usr.usrContact);
            System.out.println("Previous Zip: " + usr.usrZip); 
            System.out.printf("\n");  
            //add = 0, edit = 1
            int cnt = takeInput(usrDetails, count, 1, usr);
            System.out.println("Contact successfully edited");
            System.out.printf("\n");
        }
    }

    static int deleteContact(ArrayList<day2> usrDetails, int count){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number: ");
        Long contact = sc.nextLong();
        for(int i = 0; i < usrDetails.size(); i++){
            if(contact.equals(usrDetails.get(i).usrContact)){
                usrDetails.remove(i);
                count--;
                System.out.println("Contact deleted successfully");
                System.out.printf("\n");
                return count;
            }
        }
        System.out.println("No contact found");
        System.out.printf("\n");
        return count;
    }

    static void searchbyCityorState(ArrayList<day2> usrDetails){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city or state: ");
        String cityOrState = sc.nextLine();
        System.out.println("All contacts for that city/state are:");
        int count = 0;
        for(int i = 0; i < usrDetails.size(); i++){
            if(cityOrState.equals(usrDetails.get(i).usrCity) || cityOrState.equals(usrDetails.get(i).usrState)){
                System.out.println("Name: " + usrDetails.get(i).usrName);
                System.out.println("Email: " + usrDetails.get(i).usrMail);
                System.out.println("City: " + usrDetails.get(i).usrCity);
                System.out.println("State: " + usrDetails.get(i).usrState);
                System.out.println("Contact: " + usrDetails.get(i).usrContact);
                System.out.println("Zip: " + usrDetails.get(i).usrZip); 
                System.out.printf("\n"); 
                count++;
            }
        }
        if(count < 1){
            System.out.println("No contact found for mentioned city/state");
            System.out.printf("\n");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<day2> usrDetails = new ArrayList<> ();
        System.out.println("Welcome to address book program.");
        int count = 0;
        while(true){
            int choice;
            
            System.out.println("1. Add new contact\n2. Show details of a contact\n3. Edit contact\n4. Delete contact\n5. View all contacts for state or city\n6. Get a count of contacts\n7. Exit");
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    {
                        //add = 0, edit = 1
                       count = takeInput(usrDetails, count, 0, null);
                       break;
                    }

                case 2: 
                    showDetails(usrDetails);
                    break;

                case 3:
                    editContact(usrDetails, count);
                    break;
                case 4:
                    count = deleteContact(usrDetails, count);
                    break;
                case 5:
                    searchbyCityorState(usrDetails);
                    break;
                case 6: 
                    System.out.println("There are " + count + " contacts present in address book");
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input! Try again!");

            }
        }
    }
}