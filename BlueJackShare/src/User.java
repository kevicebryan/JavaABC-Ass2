import java.util.ArrayList;

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
}


