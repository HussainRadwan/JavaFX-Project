package application;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;


public class MediaRental implements MediaRentalInt {
	
	ArrayList <Customers> customer = new ArrayList <Customers>();
	ArrayList <Media> media =new ArrayList<>();
	public ArrayList<Customers> getCustomer() {
		return customer;
	}

	public ArrayList<Media> getMedia() {
		return media;
	}

	protected int limt =2;
	
	
	public boolean addCustomer(String name,String address,String plan,String mobile, String ID)
	{
		if (!customer.isEmpty())
		{
			for (int i=0 ; i<customer.size(); i++)
			{
				if (ID.equals(customer.get(i).ID))
					return false;
				else {
					customer.add(new Customers(name,address,plan,mobile,ID));
					return true;
				}
			}
		}else {
			customer.add(new Customers(name,address,plan,mobile,ID));
			return true;
		}
		return false;
	}
	
	public boolean addMovie(String title, int copiesAvailable,String rating, String code)
	{
		if (!media.isEmpty())
		{
			for (int i=0;i<media.size();i++)
			{
				if(media.get(i).code.equals(code))
					return false;
				else {
					media.add(new Movie(title,copiesAvailable,rating,code));
					return true;
				}
			}
		}else {
			media.add(new Movie(title,copiesAvailable,rating,code));
			return true;
		}
		return false;
	}
	
	public boolean addGame(String title, int copiesAvailable,double weight, String code)
	{
		if (!media.isEmpty())
		{
			for (int i=0;i<media.size();i++)
			{
				if(media.get(i).code.equals(code))
					return false;
				else {
					media.add(new Game(title,copiesAvailable,weight,code));
					return true;
				}
			}
		}else {
			media.add(new Game(title,copiesAvailable,weight,code));
			return true;
		}
		return false;
	}
	
	public boolean addAlbum(String title,int copiesAvailable,String artist,String songs,String code)
	{
		if (!media.isEmpty())
		{
			for (int i=0;i<media.size();i++)
			{
				if(media.get(i).code.equals(code))
					return false;
				else {
					media.add(new Album(title,copiesAvailable,artist,songs,code));
					return true;
				}
			}
		}else {
			media.add(new Album(title,copiesAvailable,artist,songs,code));
			return true;
		}
		return false;
	}
	
	public void setLimitedPlanLimit(int value)
	{
		limt = value;
	}
	
	public String getAllCustomersInfo()
	{
		String infoC ="";
		for (int i=0; i<customer.size();i++)
			infoC +=customer.get(i).toString() +"\n";
		return infoC;
	}
	
	public String getAllMediaInfo()
	{
		String infoM ="";
		for (int i=0;i<media.size();i++)
			infoM += media.get(i).toString() +"\n";
		return infoM;
	}
	
	public boolean addToCart(String ID,String code)
	{
		for (int i=0;i<customer.size();i++)
		{
			
			if (customer.get(i).getID().equals(ID))
			{
				for (int j=0;j<customer.get(i).getCart().size();j++)
				{
					if (customer.get(i).getCart().get(j).equals(code))
						return false;
				}
				customer.get(i).getCart().add(code);
			}
		}
		return true;
	}
	
	public boolean removeFromCart(String ID,String code)
	{
		for (int i=0;i<customer.size();i++)
		{
			if (customer.get(i).getID().equals(ID))
			{
				for (int j=0;j<customer.get(i).getCart().size();j++)
				{
					if (! code.equals(customer.get(i).getCart().get(j)))
						return false;
					if (code.equals(customer.get(i).getCart().get(j)) )
						customer.get(i).getCart().remove(j);
					
				}
			}
		}
		return true;
	}
	
	public String processRequests()
	{
		String message="";
		for (int i=0;i< customer.size();i++)
		{
			if (customer.get(i).getPlan().equals("LIMITED"))
			{
				for (int j=0;j<limt &&j< customer.get(i).getCart().size() ; j++)
				{
					for(int t=0;t<media.size();t++)
					{
						if (media.get(t).title.equals(customer.get(i).getCart().get(j)))
						{
							if (media.get(t).NOC == 0)
								System.out.println("There is no copy of the media available");
							if (media.get(t).NOC != 0)
							{
								media.get(t).setNOC(media.get(t).NOC-1);
								customer.get(i).getRent().add(customer.get(i).getCart().get(j));
								customer.get(i).getCart().remove(j);
								message += "Sending ["+(media.get(t).title)+"] to ["+(customer.get(i).name)+"]"+"\n";
							}
						}
					}
				}
			}
			if (customer.get(i).getPlan().equals("UNLIMITED"))
			{
				for (int j=0;j<limt &&j< customer.get(i).getCart().size() ; j++)
				{
					for(int t=0;t<media.size();t++)
					{
						if (media.get(t).getCode().equals(customer.get(i).getCart().get(j)))
						{
							if (media.get(t).NOC == 0)
								System.out.println("There is no copy of the media available");
							if (media.get(t).NOC != 0)
							{
								media.get(t).setNOC(media.get(t).NOC-1);
								customer.get(i).getRent().add(customer.get(i).getCart().get(j));
								customer.get(i).getCart().remove(j);
								message += "Sending ["+(media.get(t).getCode())+"] to ["+(customer.get(i).getID())+"]"+"\n";
							}
						}
					}
				}
			}
		}
		return message;
	}
	
	public boolean returnMedia(String customerName,String mediaTitle)
	{
		boolean test = true;
		for (int i=0;i<customer.size();i++)
		{
			if (customer.get(i).name.equals(customerName))
			{
				for (int j=0;j<customer.get(i).getRent().size();j++)
				{
					if (customer.get(i).getRent().get(j).equals(mediaTitle))
					{
						for (int t=0;t<media.size();t++)
						{
							if (media.get(t).title.equals(mediaTitle))
								media.get(t).setNOC(media.get(t).NOC+1);
						}
						customer.get(i).getRent().remove(j);
					}
					if (! customer.get(i).getRent().get(j).equals(mediaTitle))
					{
						System.out.println("This customer dosen't buy this media ");	
						test = false;
					}	
				}
			}
			if (! customer.get(i).name.equals(customerName))
			{
				System.out.println("this person is not a customer");
				test = false;
			}
		}
		return test;
	}
	
	public ArrayList<String> searchMedia(String title,String rating, String artist,String songs,String code)
	{
		ArrayList <String> info = new ArrayList <String>();
		
		for (int i=0;i<media.size();i++)
		{
			if (media.get(i) instanceof Game)
			{
				if ((title.equals("") || ((Game)media.get(i)).getTitle().equals(title)) && rating.equals("") && artist.equals("") && songs.equals(""))
					info.add(media.get(i).title);
			}
			
			if (media.get(i) instanceof Movie)
			{
				if (artist.equals("") && songs.equals("") && 
						(title.equals("") || ((Movie)media.get(i)).getTitle().equals(title)) && (((Movie)media.get(i)).getRating().equals(rating) || rating.equals("")))
				{
					info.add(media.get(i).title);
				}
			}
			
			if (media.get(i) instanceof Album)
			{
				if (rating.equals("") && ((((Album)media.get(i)).getArtist().equals(artist)||artist.equals(""))||((((Album)media.get(i)).getSong().indexOf(songs)!=-1)||songs.equals(""))) &&
						(title.equals("") || ((Album)media.get(i)).getTitle().equals(title)) )
				{
					if(((((Album)media.get(i)).getSong().indexOf(songs)!=-1)||songs.equals("")))
						info.add(media.get(i).title);
				}
				
				else if (rating.equals("") && ((((Album)media.get(i)).getArtist().equals(artist)||artist.equals("")) && ((((Album)media.get(i)).getSong().indexOf(songs)!=-1)||songs.equals(""))) &&
						(title.equals("") || ((Album)media.get(i)).getTitle().equals(title)))
				{
					info.add(media.get(i).title);
				}
			}
			
			if (code.equals(""))
			{
				if(media.get(i).getCode().equals(code))
				{
					info.add(media.get(i).title);
				}
			}
		}
		
		Collections.sort(info);
		return info;
	}
	
}
