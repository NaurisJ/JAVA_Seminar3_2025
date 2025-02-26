package model;

public class GuestUser {
	//mainigie
	private long generatedID;
	
	private static long counter = 0;
	
	
	// getter
	public long getGeneratedID() {
		return generatedID;
	}
	
	
	// setter
	public void setGeneratedID() {
		generatedID = counter++;
	}
	
	
	// konstruktors
	
	public GuestUser() {
		setGeneratedID();
	}
	
	
	@Override
	
	public String toString() {
		return "ID: " + generatedID + " ";
	}
	
	
	//TODO pabeigt ar filtraciajs funkkcija
	
}
