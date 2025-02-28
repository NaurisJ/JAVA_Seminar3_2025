package model;

import java.util.ArrayList;

public class Page {

	// mainigie
	private String title;
	private String description;
	private ArrayList<RegisterUser> allFollowers = new ArrayList<RegisterUser>();
	private ArrayList<Post> postsInPage = new ArrayList<Post>();
	
	// getter
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<RegisterUser> getAllFollowersUser() {
		return allFollowers;
	}
	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}
	
	
	// setter
	
	public void setTitle(String title) {
		if (title != null && title.matches("[A-Za-z ]{5,30}")) {
			this.title = title;
		} else {
			this.title = "NO PAGE TITLE!";
		}
	}
	
	public void setDesctiption(String description) {
		if (description != null && description.matches("[A-Za-z0-9 !?@#$%^&*()-+]{5,100}")) {
			this.description = description;
		} else {
			this.description = "NO DESCRIPTION!";
		}
	}
	
	
	// bez arg konstruktors
	public Page() {
		
	}
	
	
	
	
}
