package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
				&& inputUsername.matches("[A-Za-z1-9._]{3,20}")) {
			username = inputUsername;
		} else {
			username = "No username";
		}
	}
	
	
	public void setPassword(String inputPassword) {
		if (inputPassword != null
				&& inputPassword.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")) {	
			
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
		super();
		setUsername("Testa.lietotajs");
		setPassword("123qwerty");
	}
	
	public RegisterUser(String inputUsername, String inputPassword) {
		super(); // Guestuser klases konstruktors
		setUsername(inputUsername);
		setPassword(inputPassword);
	}
	
	public String toString() {
		return super.toString() + "| USERNAME: " + username + " | PASSWORD: " + password;
	}
	
	
	
}
