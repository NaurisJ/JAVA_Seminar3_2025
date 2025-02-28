package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.MainService;

public abstract class RegisterUser extends GuestUser implements IPostCreate{ // nekad netiks veidoti objekti no sis klases, bet si klase tiks izmantota ka super klase
	
	// mainigie
	private String username;

	private String password;
	


	
	// getteri
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	// setteri
	
	public void setUsername(String inputUsername) {
		if (inputUsername != null
				&& inputUsername.matches("[A-Za-z1-9._]{3,25}")) {
			username = inputUsername;
		} else {
			username = "No username";
		}
	}
	
	
	public void setPassword(String inputPassword) {
		if (inputPassword != null
				&& inputPassword.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {	
			
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				password = new String(md.digest());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			password = "No password";
		}
	}
	
	public RegisterUser() {
		super(); // GuestUser konstruktors
		setUsername("Testa.lietotajs");
		setPassword("123qwerty");
	}
	
	public RegisterUser(String inputUsername, String inputPassword) {
		super(); // Guestuser klases konstruktors
		setUsername(inputUsername);
		setPassword(inputPassword);
	}
	
	
	public void followPage(String inputTitle) throws NullPointerException{
		if (inputTitle != null) {
			for ( GuestUser tempU : MainService.getAllUsers()) {
				if (tempU instanceof BusinessUser) {
					BusinessUser tempBU = (BusinessUser)tempU;
					for (Page tempP : tempBU.getAllPagesForBusinessUser()) {
						if (tempP.getTitle().equals(inputTitle)) {
							tempP.getAllFollowersUser().add(this);
						}
					}
				}
			}
		} else {
			throw new NullPointerException("TITLE SHOULD BE WITH REAL REFERENCE");
		}
	}
	
	
	public String toString() {
		return super.toString() + "| USERNAME: " + username + " | PASSWORD: " + password;
	}
	
	
	
}
