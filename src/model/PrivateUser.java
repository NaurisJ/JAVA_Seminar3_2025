package model;

import java.util.ArrayList;

public class PrivateUser extends RegisterUser{
	
	private String name;
	private String surname;
	private ArrayList<Post> privatePost = new ArrayList<Post>();
	private ArrayList<Post> publicPost = new ArrayList<Post>();
	private ArrayList<RegisterUser> allFollowers = new ArrayList<RegisterUser>();
	
	// getter
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public ArrayList<Post> getPrivatePost() {
		return privatePost;
	}

	public ArrayList<Post> getPublicPost() {
		return publicPost;
	}

	public ArrayList<RegisterUser> getAllFollowers() {
		return allFollowers;
	}

	
	// setter
	

	public void setName(String inputName) {
		if (inputName != null
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
			name = inputName;
		} else {
			name = "unknown";
		}
	}
	public void setSurname(String inputSurname) {
		if (inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?")) {
		surname = inputSurname;
		} else {
			surname = "unknown";
		}
	}
	
	public PrivateUser(){ 
		super(); // RegisterUser bez arg kontruktors
		setName("Testa");
		setSurname("Lietotajs");
	}
	
	public PrivateUser(String name, String surname, String username, String password) {
		super(username,password);
		setName(name);
		setSurname(surname);
	}
	
	
	
	
	public String toString() {
		return name + " " + surname + ", " + super.toString();
	}
	
	













	@Override
	public void createPost(PostType postType, String ...params) {
		// TODO something
	}
}
