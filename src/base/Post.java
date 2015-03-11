package base;
import java.util.Date;

public class Post implements Comparable<Post>{
		
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	public boolean contains(String keyword){
		String content = getContent();
		if(content.toLowerCase().indexOf(keyword.toLowerCase())==-1){
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.date);
	}
	
	
}
