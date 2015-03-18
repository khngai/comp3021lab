package base;

import java.io.Serializable;
import java.util.Date;

public class User implements Comparable<User>, Serializable{
	private int UserID;
	private String UserName;
	private String UserEmail;
	
	//constructor
	public User(int UserIDs,String UserNames, String UserEmails){
		UserID=UserIDs;
		UserName=UserNames;
		UserEmail=UserEmails;
		
	}
	
	public int getuserid(){
		return UserID;
	}
	
	public void setID(int UserIDs){
		 UserID= UserIDs;
	}
	
	public String getUserName(){
		return UserName;
	}
	
	public void setUserName(String  UserNames){
		 UserName= UserNames;
	}
	
	public String getUserEmail(){
		return UserEmail;
	}
	
	public void SetEmail(String UserEmails){
		UserEmail= UserEmails;
	}
	// override function
	public String toString(){
		String detail ="User [userId =" + UserID + ",userName="+  UserName + ", userEmail=" + UserEmail +"]";
		
		return detail;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((UserEmail == null) ? 0 : UserEmail.hashCode());
		result = prime * result + UserID;
		result = prime * result
				+ ((UserName == null) ? 0 : UserName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (UserEmail == null) {
			if (other.UserEmail != null)
				return false;
		} else if (!UserEmail.equals(other.UserEmail))
			return false;
		if (UserID != other.UserID)
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		return true;
	}

	public boolean contains(String keyword){
		return true;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(this.UserID==o.UserID){
			return 0;
		}
		else if(this.UserID>o.UserID){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	
}
