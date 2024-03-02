package application;

public class Game extends Media{
	
	double weight ;
	
	public Game() {
	}
	
	public Game(String title,int NOC,double weight , String code) {
		this.weight = weight;
		this.title = title;
		this.NOC = NOC;
		this.code=code;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
	
	public String getCode () {
		return this.code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String toString() {
		return "Game [title=" + title + ", NOC=" + NOC + ", weight="+ weight + ", code=" + code + "]";

	}
	
	
}
