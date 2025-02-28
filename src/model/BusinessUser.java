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





	
	
	// params[0] - zinas teksts
	// params[1] - lapas nosaukums, kur publicet zinu
	// params[2] - otras lapas nosaukums, kur publicet zinu (var ari nebut)
	@Override
	public void createPost(PostType postType, String... params) throws Exception {
		if(postType != null && params != null) {
			if(params.length >= 2) {
				Post newPost = new Post(params[0]);
				
				for(int i = 1; i < params.length; i++) {
					for(Page tempP: allPagesForBusinessUser) {
						if(params[i].equals(tempP.getTitle())) {
							tempP.getPostsInPage().add(newPost);
						}
					}
				}
			}
			else
			{
				throw new Exception("Message text and page title are necessary");
			}
		}
		else
		{
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	public void createPage(String inputTitle, String inputDescription) throws NullPointerException {
		if(inputTitle != null && inputDescription != null) {
			
			Page newPage = new Page(inputTitle, inputDescription);
			allPagesForBusinessUser.add(newPage);
			
		}
		else
		{
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	
	
	
	
	
	

	
	
	
	
	

}
