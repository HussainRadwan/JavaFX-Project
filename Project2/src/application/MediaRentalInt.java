package application;

import java.util.*;

public interface MediaRentalInt {
	
	boolean addCustomer(String name,String address,String plan, String mobile, String ID);
	boolean addMovie(String title, int copiesAvailable,String rating, String code);
	boolean addGame(String title, int copiesAvailable,double weight,String code);
	boolean addAlbum(String title,int copiesAvailable,String artist,String songs,String code);
	void setLimitedPlanLimit(int value);
	String getAllCustomersInfo();
	String getAllMediaInfo();
	boolean addToCart(String customerName,String mediaTitle);
	boolean removeFromCart(String customerName,String mediaTitle);
	String processRequests();
	boolean returnMedia(String customerName,String mediaTitle);
	ArrayList<String> searchMedia(String title,String rating, String artist,String songs,String code);
	
}
