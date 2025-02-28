package model;

import java.util.ArrayList;

public class BusinessUser extends RegisterUser{

	private String businessName;
	private ArrayList<Page> allPagesForBusinessUser = new ArrayList<Page>();
	
	
	// getter
	public String getBusinessName() {
		return businessName;
	}

	public ArrayList<Page> getAllPagesForBusinessUser() {
		return allPagesForBusinessUser;
	}
	
	// setter
	
	public void setBusinessName(String businessName) {
		if (businessName != null && businessName.matches("[A-Za-z ]{5,30}")) {
			this.businessName = businessName;
		} else {
			this.businessName = "NO PAGE TITLE!";
		}
	}
	
	public BusinessUser() {
		super();
		setBusinessName("TESTA UZNEMUMS");
	}
	
	public BusinessUser(String username, String password, String businessName) {
		super(username,password);
		setBusinessName(businessName);
	}
	
	public String toString() {
		return businessName + ", " + super.toString();
	}




	public void createPage(String title, String description) {
		
	}

	
	
	// params[0] - zinas teksts
	// params[1] - lapas nosaukums, kur publicet zinu
	// params[2] - otras lapas nosaukums, kur publicet zinu (var ari nebut)
	@Override
	public void createPost(PostType postType, String... params) throws Exception {
		// TODO Auto-generated method stub
		if (postType != null && params != null) {
			if (params.length >= 2) {
				Post newPost = new Post(params[0]);
				
				for (int i = 1; i < params.length; i++) {
					for (Page tempP : allPagesForBusinessUser) {
						if (params[i].equals(tempP.getTitle())) {
							tempP.getPostsInPage().add(newPost);
						}
					}
					
				}
				
			} else {
				throw new Exception("MESSAGE TEXT AND PAGE TITLE ARE NECESSARY");
			}
		}
		
	}
	
	
	
	
	
	
	

	
	
	
	
	

}
