package spring.exception;

public class SpittleNotFoundException extends RuntimeException {

	int id;

	public SpittleNotFoundException(String arg0,int id) {
		super(arg0);
		this.id=id;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
