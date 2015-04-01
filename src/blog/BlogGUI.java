package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGUI implements ActionListener{
	
	private JFrame mainFrame;
	private JPanel posting;
	private JPanel buttonPanel;
	private JLabel inputLabel;
	private JPanel postPanel;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI(){
		
	}
	
	
	public void setWindow(){
		
		JFrame mainFrame = new JFrame("Gary");
		posting = new JPanel(new BorderLayout()); 
		mainFrame.setSize(500,500);
		mainFrame.setLayout(new FlowLayout());
		inputLabel = new JLabel("You can still input 140 Characters");
		posting.add(inputLabel,BorderLayout.PAGE_START);
		postTextArea = new JTextArea("What's on your mind?", 20, 40);
		postTextArea.setBackground(Color.CYAN);
		JScrollPane scrollPane = new JScrollPane(postTextArea); 
		postTextArea.setEditable(true);
		posting.add(postTextArea,BorderLayout.CENTER);
		buttonPanel = new JPanel(new BorderLayout());
		refresh=new JButton("refresh");
		refresh.addActionListener(this);
		buttonPanel.add(refresh,BorderLayout.EAST);
		post=new JButton("post");
		post.addActionListener(this);
		buttonPanel.add(post,BorderLayout.WEST);
		mainFrame.add(posting);
		
		//postPanel=new JPanel(new BorderLayout());
		postContent=new JTextField("Here is put my posts!", 25);
		postContent.setEditable(false);
		buttonPanel.add(postContent, BorderLayout.SOUTH);
		mainFrame.add(buttonPanel);
		
		
		mainFrame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==post){
			postContent.setText("You click POST!!");
		}
		else if(e.getSource()==refresh){
			postContent.setText("You click REFRESH!!");
		}
	}
	
	public static void main(String[] args){
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}
}
