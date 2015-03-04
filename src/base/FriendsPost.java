package base;

import java.util.Date;

public class FriendsPost extends Post {
		private User friend;
		public FriendsPost(Date dates, String contents,User friends ){
			 super(dates,contents);
			 friend=friends;
		}
		
		public User getUser(){
			return friend;
		}
		
		public void setFriend(User friends){
			friend=friends;
		}
		
		public String toString(){
			String dateString=getDate().toString();
			String detail= friend.toString() +'\n'+dateString+" "+ '\n'+ getContent();
			
			return detail;
		}
}
