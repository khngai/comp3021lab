package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import base.Post;
import base.User;

public class BlogGUI implements ActionListener{
	
	private JFrame mainFrame;
	private JPanel posting;
	private JPanel buttonPanel;
	private JLabel inputLabel;
	private JPanel postPanel;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private Blog myBlog;
	
	User user = new User(1, "A", "a@cse.ust.hk");
	
	
	
	public BlogGUI(){
		
	}
	
	
	class postListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String content = postTextArea.getText();
			Date d;
			String savefilepath="M:/"+user.getUserName()+".blog";
			if(content==""){
				
			}
			else if(content.length()>140){
				
			}
			else{
				d=new Date();
				Post p = new Post(d,content);
				myBlog.add(p);
				myBlog.save(savefilepath);
				System.out.println("File path: "+savefilepath);
			}
		}
		
	}
	
	class refreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String loadfilepath="M:/"+user.getUserName()+".blog";
			myBlog.load(loadfilepath);
			postContent.setText(myBlog.toString());
		}
	}
	
	class lengthListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int textlength=postTextArea.getText().length();
			inputLabel.setText("You can still input "+(140-textlength) +"Characters");
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public void setWindow(){
		myBlog=new Blog(user);
		JFrame mainFrame = new JFrame("Gary");
		posting = new JPanel(new BorderLayout()); 
		mainFrame.setSize(500,500);
		mainFrame.setLayout(new FlowLayout());
		inputLabel = new JLabel("You can still input 140 Characters");
		posting.add(inputLabel,BorderLayout.PAGE_START);
		postTextArea = new JTextArea("What's on your mind?", 20, 40);
		//postTextArea.setBackground(Color.CYAN);
		postTextArea.setBackground(Color.decode("#FFFFE0"));
		JScrollPane scrollPane = new JScrollPane(postTextArea); 
		postTextArea.setEditable(true);
		postTextArea.addKeyListener(new lengthListener());
		posting.add(postTextArea,BorderLayout.CENTER);
		buttonPanel = new JPanel(new BorderLayout());
		refresh=new JButton("refresh");
		refresh.addActionListener(new refreshListener());
		buttonPanel.add(refresh,BorderLayout.EAST);
		post=new JButton("post");
		post.addActionListener(new postListener());
		buttonPanel.add(post,BorderLayout.WEST);
		mainFrame.add(posting);
		
		//postPanel=new JPanel(new BorderLayout());
		postContent=new JTextArea("Here is put my posts!", 20, 40);
		postContent.setEditable(false);
		buttonPanel.add(postContent, BorderLayout.SOUTH);
		mainFrame.add(buttonPanel);
		
		
		mainFrame.setVisible(true);
		
	}
	
	/*public void actionPerformed(ActionEvent e){
		if(e.getSource()==post){
			postContent.setText("You click POST!!");
		}
		else if(e.getSource()==refresh){
			postContent.setText("You click REFRESH!!");
		}
	}*/
	
	public static void main(String[] args){
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
