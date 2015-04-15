package blog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ConcurrentModificationException;

import base.Post;
import base.User;

/**
 * @author khngai
 *
 */
public class Blog implements Serializable{
		private User user;
		private ArrayList<Post> allPosts;
		
		public Blog(){
			
		}
		
		public Blog(User user){
			allPosts=new ArrayList<Post>();
			
		}
		
		public void setUser(User users){
			user=users;
		}
		
		public User getUser(){
			return user;
		}
		
		public void add(Post p){
			allPosts.add(p);
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
			String Blogdetail="Blog [user=" + user ;
			String BlogPost="allPosts=";
			String Post="";
			for(Post p:allPosts){
			Post=Post+p.toString()+"\n";
					}
			String Blogtext=Blogdetail+" "+BlogPost+Post+" ]";
			
			return Blogtext;
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
		
		public void search(int month, String someone){
			
			Calendar cal = Calendar.getInstance();
			
			for(Post p : allPosts){
				cal.setTime(p.getDate());
				int postMonth = cal.get(Calendar.MONTH);
				
				if(postMonth+1==month&&p.getContent().contains(someone)){
					System.out.println(p);
				}
			}
		}

		public void setPosts(ArrayList<Post> allposts2) {
			// TODO Auto-generated method stub
			allPosts=allposts2;
		}
		
		public void save(String filepath) {
			FileOutputStream out;
			ObjectOutputStream oos;
			try {
				out = new FileOutputStream(filepath);
				oos = new ObjectOutputStream(out);
				oos.writeObject(this);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		public void load(String filepath){
			FileInputStream in;
			ObjectInputStream ois;
			try {
				in = new FileInputStream(filepath);
				
				ois = new ObjectInputStream(in);

					Blog read = (Blog) ois.readObject();
					this.allPosts=read.allPosts;
					this.user=read.user;
					in.close();
			}catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}catch(FileNotFoundException e){
						System.out.println("Wait! There is something wrong. I cannot find the file");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
