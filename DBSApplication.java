package assignMent01_Bank;

import java.util.Scanner;

public class DBSApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to DBS Bank \n" +"================\n");
		UserInput.userInput();
	}

}

class DBS {
	
	static int amount = 500;
	static void deposit(int val){
		amount = amount + val;
		System.out.println("Successful done..");
		System.out.println("Available Balance :" + amount);
	}
	
	static void withdraw(int val){
		if(val > amount){
			System.err.println("Sorry Insufficient Amount");
		}else{
			 amount = amount - val;
			System.out.println("Successfull done..\n" +"Available Balance :" + amount);
		}
	}
	
	static void checkBalance(){
		System.out.println("Available Balance :" + amount);
	}

	
	
}

class LoginAuthentication {
	static void validateUser(String id, String pwd){
		String choice = null;
		
		if(id.equals("admin") && pwd.equals("33")){
			System.out.println("Welcome " +id);
			System.out.println("1. Check Balance \n" + "2. Deposit \n" + "3. Withdraw \n");
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choiceS = sc.nextInt();			
			
			
		if(choiceS == 1){
			DBS.checkBalance();
		}
		else if(choiceS == 2){
			Scanner ds = new Scanner(System.in);
			System.out.println("Enter Amount :");
			if (ds.hasNextInt() == false){
				System.err.println("Invalid user input" +"\n");
				System.out.println("Please key in number only :");
				
				
			}		
			else{
			DBS.deposit(ds.nextInt());	
		}
		}	
		else if (choiceS == 3) {
			Scanner ws = new Scanner(System.in);
			System.out.println("Enter Amount :");
			DBS.withdraw(ws.nextInt());
		}
		else{
			System.out.println("valid number plz");
		}
		Scanner wc = new Scanner(System.in);
		System.out.println("Wish to continue :");
		choice = wc.next();
		// UserInput.userInput();
		}
		while(!choice.equals("no"));
		System.out.println("Thank You!!!");
		} else {
			System.out.println("Sorry Unauthorized Customer..");
			Scanner sc = new Scanner(System.in);
			System.out.println("Wish to Continue (yes/no) or (1/2) :");
			choice = sc.next();
			if (choice.equals("no") || choice.equals("2")){
				System.out.println("Thank you!!!");
			} else if(choice.equals("yes") || choice.equals("1")){
				UserInput.userInput();
			}
		}
	}
}

class UserInput {
	static void userInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID and Password :");
		String id = sc.next();
		String pwd = sc.next();
		LoginAuthentication.validateUser(id, pwd);
	}
}
