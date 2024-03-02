package application;

import java.util.*;

public class Customers {
	
	public String name ;
	public String addres;
	public String plan;
	String mobile;
	String ID;
	
	ArrayList <String> cart = new ArrayList <String>();
	ArrayList <String> rent = new ArrayList <String>();
	
	public Customers() {}

	public Customers(String name, String addres, String plan,String mobile ,String ID) {
		this.name = name;
		this.addres = addres;
		this.mobile=mobile;
		this.ID=ID;
		
		if(plan.toUpperCase().equals("LIMITED") || plan.toUpperCase().equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		
		if(plan.toUpperCase().equals("LIMITED") || plan.toUpperCase().equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
	}

	public ArrayList<String> getCart() {
		return cart;
	}

	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}

	public ArrayList<String> getRent() {
		return rent;
	}

	public void setRent(ArrayList<String> rent) {
		this.rent = rent;
	}

	public String toString() {
		return "Customers [name=" + name + ", addres=" + addres + ", plan=" + plan + ", mobile=" + mobile +", ID=" + ID + "]";
	}
	
	
}
