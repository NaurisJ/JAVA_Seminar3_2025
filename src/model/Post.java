package model;

import java.time.LocalDateTime;

public class Post {
	
	// mainigie
	private String msg;
	private LocalDateTime datetime;
	private long countOfLikes = 0;

	
	// getter
	
	public String getMsg() {
		return msg;
	}
	public LocalDateTime getDate() {
		return datetime;
	}
	public long getCountOfLikes() {
		return countOfLikes;
	}
	
	
	// setter
	
	public void setMsg(String inputMsg) {
		if (inputMsg != null
				&& inputMsg.matches("[A-Za-z .0-9!@#$%^&*()?]{3,200}")) {
			msg = inputMsg;
		} else {
			msg = "No message";
		}
	}
	
	public void increaseCountOfLikes() {
		countOfLikes++;
	}
	
	public void setDate() {
		datetime = LocalDateTime.now();
	}
	
	
	// bez arg konstruktors
	
	public Post() {
		setDate();
		setMsg("Default message");

		
	}
	
	// ar arg kontr
	
	public Post(String inputMsg) {
		setDate();		
		setMsg(inputMsg);

	}
	
	// TODO apskatities formatus datetime
	@Override
	public String toString() {
		return msg + " (" + datetime + ") Likes - " + countOfLikes;
	}
	
	
	
}
