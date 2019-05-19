package spring.mbean.config;



public interface MbeanTest {
	
	 String getName() ;
	
	 void setName(String name) ;
	
	public int getAge();

	public void setAge(int age) ;
	public String getAddress() ;
	public void setAddress(String address) ;

	public String getEmail() ;
	public void setEmail(String email) ;

	public void method (String name,int age) ;
}
