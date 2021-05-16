import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class User implements Comparable<User> {
	int number = -1;
	String username;
	
	
	public User(int number, String username) {
		this.number = number;
		this.username = username;
	}
	public void  updateNum(int number) {
		this.number = number;
	}
	public String getUsername() {
		return this.username;
	}
	
	public int compareTo (User user) {
		int res = 0;
		int retval = this.username.compareTo(user.getUsername());
		if (retval < 0) {
			res = -1;
		}
		if (retval > 0) {
			res = 1;
		}
		return res;
	}
	
	
//	Add new User
	public static ArrayList<User> startSharing(ArrayList<User> users) {
		boolean validinput = false;
		int num = -1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Input a number [0-100]: ");
			try {
				validinput = true;
				num = scan.nextInt();
				scan.nextLine();
			}catch(Exception e){
				scan.nextLine();
				System.out.println("Input must be numeric!");
				validinput = false;
			}
		}while(!validinput || (num < 0 || num > 100));

		String username;
		boolean unique = true;
		boolean validusername = true;
		do {
			unique = true; validusername = true;
			System.out.print("Your Username? [5-20char]: ");
			username = scan.nextLine();
			if (username.length() < 5 || username.length()> 20) {
				if(username.length()< 5) {
					System.out.println("Your name too short...");
				}else {
					System.out.println("Your name too long...");
				}
				validusername = false;
			}
			for(User user: users) {
				if(username.equals(user.username)) {
					unique = false;
					System.out.println("Username taken bro...");
					break;
				}
			}
		}while(!unique || !validusername);
		User tempuser = new User(num ,username);
		users.add(tempuser);
		int counter = users.size();
		System.out.println("Your are the "+counter+" that joins the game");
		System.out.println("Your share number: "+tempuser.number);
		return users;
	}
	
	
//	Add user from list
	public static ArrayList<User> updateParticipant(ArrayList<User>users){
		int usersize = users.size();
		System.out.println(usersize);
		if(usersize ==  0) {
			System.out.println("Listnya kosong bro...");
			return users;
		}else {
			viewAllUser(users);
			int choice = -1;
			boolean isnum = false;
			Scanner scan = new Scanner(System.in);
			do {
				System.out.print("Which participant u wanna update(0 to exit)? ");
				try {
					isnum = true;
					choice =  scan.nextInt();
					scan.nextLine();
				}catch(Exception e) {
					isnum = false;
					scan.nextLine();
					System.out.println("input must be numeric!");
				}
			}while(choice != 0 && (choice < 0 || choice > usersize));
			
			if(choice == 0) {
				System.out.println("Exited update...");
				return users;
			}else {
				boolean validinput = false;
				int num = -1;
				do {
					System.out.print("Input a number [0-100]: ");
					try {
						validinput = true;
						num = scan.nextInt();
						scan.nextLine();
					}catch(Exception e){
						scan.nextLine();
						System.out.println("Input must be numeric!");
						validinput = false;
					}
				}while(!validinput || (num < 0 || num > 100));
				
				int counter = 0;
				for(User user: users) {
					if (counter == choice-1) {
//						user.updateNum(num);
						user.number = num;
						break;
					}
					counter++;
				}
				System.out.println("Update Succesful!");
//				return users;
			}
		}
		return users;
	}
	
	
//	DELETE USER
	public static ArrayList<User> deleteUser(ArrayList<User>users) {
		int usersize = users.size();
		System.out.println(usersize);
		if(usersize ==  0) {
			System.out.println("Listnya kosong bro...");
			return users;
		}else {
			int choice = -1;
			boolean isnum = false;
			Scanner scan = new Scanner(System.in);
			do {
				viewAllUser(users);
				System.out.print("Which participant u wanna delete(0 to exit)? ");
				try {
					isnum = true;
					choice =  scan.nextInt();
					scan.nextLine();
				}catch(Exception e) {
					isnum = false;
					scan.nextLine();
					System.out.println("input must be numeric!");
				}
			}while(choice != 0 && (choice < 0 || choice > usersize));
			users.remove(choice-1);
			System.out.println("Delete Succesful!");	
		}
		return users;
	}
	
	
	
	
//	View All
	public static void viewAllUser(ArrayList<User>users) {
		System.out.println("==========================================");
		System.out.println("Share List");
		System.out.println("==========================================");
		int count = 0;
		for (User user: users) {
			count++;
			System.out.printf("%d | %-20s | %d\n", count, user.username, user.number);
		}
		System.out.println("==========================================");
		return;
	}
	
//	u/ EXIT
	public static ArrayList<User> beforeClose(ArrayList<User>users){
//		Sorting
//		bubbleSortAL(users);
		Collections.sort(users);
		for (User user: users) {
			System.out.println(user.username + " "+user.number);
		}//Now list is sorted by name
		ArrayList <Integer> shufflenum = new ArrayList<>();
		for (User user: users) {
			shufflenum.add(user.number);
		}
		
//		Shuffling n Reverse
		Collections.shuffle(shufflenum);
		Collections.reverse(shufflenum);
		
		System.out.println("Sharing is caring :D");
		System.out.println("==========================================");
		System.out.println("Share List");
		System.out.println("==========================================");
		System.out.printf("%-20s | %-8s | %-8s\n", "Username", "Before", "After");
		System.out.println("==========================================");
		int i = 0;
		for (User user: users) {
			System.out.printf("%-20s | %-8d | %-8d\n", user.username, user.number
					, shufflenum.get(i));
			i++;
		}
		System.out.println("==========================================");
		return users;
	}
}


