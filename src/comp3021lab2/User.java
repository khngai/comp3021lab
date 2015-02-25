package comp3021lab2;

import java.util.Date;

public class User {
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
	
	public String getusername(){
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
	
	public boolean equals(Object o){
		boolean ans = true;
		
		o.getClass();
		
		User user = (User) o;
		if(user.UserName!=this.UserName){
			ans = false;
		}
		
		
		return ans;
	}
	
	public int hashCode(){
		int hashCode = 0;
		
		UserName.hashCode();
		UserEmail.hashCode();
		
		return hashCode;
	}
	
	public boolean contains(String keyword){
		return true;
	}
}
