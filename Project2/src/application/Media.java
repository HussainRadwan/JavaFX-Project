package application;

public abstract class Media {
	
	String title;
	int NOC;
	String code;
	
	public Media() {
	}
    
	
	public Media(String title, int NOC, String code) {
		this.title = title;
		this.NOC = NOC;
		this.code = code;
	}

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract int getNOC();

	public abstract void setNOC(int NOC) ;

	public abstract String toString() ;
	
	public abstract String getCode ();
	
	public abstract void setCode (String code);
	
}
