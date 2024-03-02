package application;

public class Album extends Media{
	
	String artist;
	String song;

	public Album() {
		super();
	}

	public Album( String title,int NOC,String artist,String song,String code) {
		super(title, NOC,code);
		this.artist = artist;
		this.song=song;
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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
	public String getCode () {
		return this.code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String toString() {
		return "Album [title=" + title + ", NOC=" + NOC + ", artist=" + artist + ", song=" + song + ", code=" + code + "]";
	}
}
