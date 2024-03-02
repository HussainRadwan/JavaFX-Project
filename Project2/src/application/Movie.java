package application;

public class Movie extends Media {
	
	String rating;
	
	public Movie() {
		super();
	}

	public Movie(String title, int NOC, String rating, String code) {
		super(title, NOC, code);
		if(!rating.equals("DR") && !rating.equals("HR") && !rating.equals("AC") ) 
			throw new IllegalArgumentException("Invlid input");
		else
			this.rating = rating;	
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public int getNOC() {
		return NOC;
	}


	public void setNOC(int NOC) {
		this.NOC = NOC;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		if(!rating.equals("DR") && !rating.equals("HR") && !rating.equals("AC") ) 
			throw new IllegalArgumentException("Invlid input");
		else
			this.rating = rating;
	}
	
	public String getCode () {
		return this.code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}

	public String toString() {
		return "Movie [title=" + title + ", NOC=" + NOC + ", rating=" + rating + ", code=" + code + "]";
	}
	
	

}
