package comp3021lab2;
import java.util.Date;

public class Post {
		
	private Date date;
	private String content;
	
	//constructor
	public Post(Date dates, String contents){
		date=dates;
		content=contents;
		
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String contents){
		content=contents;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void SetDate(Date dates){
		date=dates;
	}
	// override function
	public String toString(){
		String dateString=getDate().toString();
		String detail=dateString+" "+ getContent();
		
		return detail;
	}
	
	public boolean equals(Object o){
		boolean ans = true;
		
		o.getClass();
		
		Post post = (Post) o;
		//to DO(DATE)
		
		if(post.content!=this.content){
			ans = false;
		}
		
		
		return ans;
	}
	
	public int hashCode(){
		int hashCode = 0;
		
		date.hashCode();
		content.hashCode();
		
		return hashCode;
	}
	
	public boolean contains(String keyword){
		String content = getContent();
		if(content.toLowerCase().indexOf(keyword.toLowerCase())==-1){
			return false;
		}
		return true;
	}
}
