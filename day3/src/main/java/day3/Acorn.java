package day3;

public class Acorn {

	String id;
	String pw;
	String name;
	
	
	public Acorn(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	
	public Acorn() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Acorn [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	
	
}

