package base;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Blog {
		private User user;
		private ArrayList<Post> allPosts;
		
		public Blog(User user){
			allPosts=new ArrayList<Post>();
			
		}
		
		public void setUser(User users){
			user=users;
		}
		
		public User getUser(){
			return user;
		}
		
		public void post(Post p){
			allPosts.add(p);
			System.out.println("A new Post:");
			System.out.println(p.getDate().toString());
			System.out.println(p.getContent().toString());
			
			/*catch(ConcurrentModificationException)
			{
				return;
			}*/
		}
		
		public void list(){
			for(int i=0;i<allPosts.size();i++){
				System.out.println("Current posts:");
				System.out.println("Post["+(i+1)+"]: "+allPosts.get(i).getDate().toString());
				System.out.println(allPosts.get(i).getContent().toString());
			}
		}
		
		public void delete(int index){
			if(index<0||index>=allPosts.size()){
				System.out.println("No this posts");
			}
			else{
			allPosts.remove(index);
			}
		}

		@Override
		public String toString() {
			return "Blog [user=" + user + ", allPosts=" + allPosts + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((allPosts == null) ? 0 : allPosts.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
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
			Blog other = (Blog) obj;
			if (allPosts == null) {
				if (other.allPosts != null)
					return false;
			} else if (!allPosts.equals(other.allPosts))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}
		
		
}
