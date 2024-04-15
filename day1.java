// import java.lang.*;
import java.util.*;



class day1{

	String Uname; 
	String Umail;
	Long contact;
	String Upass;
	
	day1(String Uname, String Umail, Long contact, String Upass){

		this.Uname = Uname;
		this.Umail = Umail; 
		this.contact = contact;
		this.Upass = Upass; 
		
	}

	public static day1 signIn(){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username: ");
			String Uname = sc.nextLine();
		
			System.out.println("Enter email id: ");
			String Umail = sc.nextLine();
		
			System.out.println("Enter contact no. :");
			Long contact = sc.nextLong();

			sc.nextLine(); //to skip \n
 		
			System.out.println("Enter password: ");
			String Upass = sc.nextLine();
			
			System.out.println("Confirm password: ");
			String CUpass = sc.nextLine();	
		
			if(Upass.equals(CUpass)){
				day1 usr = new day1(Uname, Umail, contact, Upass);
				return usr;
			}	
			else{
				System.out.println("Password mismatched.");
			}
		}
		catch(Exception e){
			System.out.println("Enter valid mobile number");
		}
		return null;
	}

	public static String logIn(ArrayList<day1> usrDetails){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.nextLine();
		
		System.out.println("Enter password");
		String password = sc.nextLine();

		for(int j = 0; j < usrDetails.size(); j++){
			if(username.equals(usrDetails.get(j).Uname) && password.equals(usrDetails.get(j).Upass)){
				return "Login successful";
				
			}
		}
		return "Invalid username or password";

	}

	public static void main(String[] args){
		// int[] usrDetails new int[20];
		ArrayList<day1> usrDetails = new ArrayList<>();
		boolean i = true;
		int count = -1;
		
		while(i){
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 to signIn or Press 2 to logIn: ");
			int choice = sc.nextInt();
			
			if(choice == 1){
				day1 usr1 = day1.signIn();
				if(usr1 != null){
					count++;
					usrDetails.add(usr1);
					System.out.println("Signed up successfully");
				}
			}
			else if(choice == 2){
				String login = logIn(usrDetails);
				System.out.println(login);
			}
			else{
				System.out.println("Invalid input");
			}
			
			System.out.println("Press 1 to continue and 0 to exit: ");
			int ch = sc.nextInt();
			if(ch == 0){
				i = false;
				break;
			}

		}
		// System.out.println(usrDetails.get(0).Uname);  
	}

} 
