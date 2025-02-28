package service;

import model.GuestUser;
import model.Page;
import model.PostType;
import model.PrivateUser;
import model.RegisterUser;

import java.util.ArrayList;
import java.util.Arrays;

import model.BusinessUser;

public class MainService {
	private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuestUser u1 = new GuestUser();
		GuestUser u2 = new GuestUser();
		
		PrivateUser u3 = new PrivateUser("Angelina","Gomeza","gomeza23","1234qWert!");
		BusinessUser u4 = new BusinessUser("ziedu.veikals", "4321qwEr!@", "SIA ZIEDU VEIKALS");
		
		allUsers.addAll(Arrays.asList(u1,u2,u3,u4));
		for (GuestUser tempU : allUsers) {
			System.out.println(tempU.getClass().getName() + "->" + tempU);
		}
		
		
		try {
			u3.createPost(PostType.publicPost, "Man ne, patik JAVA");
			u3.createPost(PostType.privatePost, "Man gribas majas");
			
			System.out.println(u3.getSurname() + " privatas zinas: " + u3.getPrivatePosts());
			System.out.println(u3.getSurname() + " publiskas zinas: " + u3.getPublicPosts());
			
			u4.createPage("Ziedi Ventspili", "Mana lapa par ziediem Ventspili");
			u4.createPage("Ziedi Daugavpili", "Mana lapa par ziediem Daugavpili");
			
			u4.createPost(PostType.publicPost, "Ventspils svetki - 20% atlaide visiem ziediem", "Ziedi Ventspili");
			u4.createPost(PostType.publicPost,"Priecigas Lieldienas",
					"Ziedi Daugavpili", "Ziedi Ventspili");
			
			for(Page tempP : u4.getAllPagesForBusinessUser())
			{
				System.out.println(tempP);
			}
			
			u3.followPage("Ziedi Ventspili");
			System.out.println("Sekotaji: " + u4.getAllPagesForBusinessUser().get(0).getAllFollowersUser());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static ArrayList<GuestUser> getAllUsers() {
		return allUsers;
	}
	
	

}
