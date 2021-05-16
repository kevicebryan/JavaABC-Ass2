import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BJ - SHARE");
		ArrayList<User> users = new ArrayList<>();
		int menuchoice = -1;
		Scanner scan  = new Scanner(System.in);
		do {
			printMenu();
			menuchoice = scan.nextInt();
			scan.nextLine();
			if(menuchoice == 1) {
				users = User.startSharing(users);
			}else if (menuchoice == 2) {
				users = User.updateParticipant(users);
			}else if (menuchoice == 3) {
				users = User.deleteUser(users);
			}else if (menuchoice == 4) {
				users = User.beforeClose(users);
			}else {
				System.out.println("Bro 1-4 please!");
			}
			
		}while(menuchoice != 4);
	}
	
//METHODS	
	
	public static void printMenu() {
		System.out.println("=========================");
		System.out.println("Options");
		System.out.println("=========================");
		System.out.println("1. Start Sharing");
		System.out.println("2. Update Participant");
		System.out.println("3. Delete Participant");
		System.out.println("4. Close App");
		System.out.println("=========================");
		System.out.print("Choice >> ");
	}
	
//	public static void bubbleSortAL(List <User> list) {
//		User temp;
//		boolean sorted =false;
//		while(!sorted) {
//			sorted = true;
//			for (int i = 0; i < list.size()-1; i++){
//				if(list.get(i).compareTo(list.get(i+1))> 0) {
//					temp = list.get(i);
//					list.set(i, list.get(i+1));
//					list.set(i+1, temp);
//					sorted = false;
//				}
//			}
//		}
//	}
}
