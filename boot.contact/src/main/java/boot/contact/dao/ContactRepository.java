package boot.contact.dao;


import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import boot.contact.model.Contact;

@Repository
public class ContactRepository {
   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   public void save(Contact contact) {
	   
	   jdbcTemplate.update("insert into  contacts (firstName,lastName,phoneNumber,emailAddress)"
	   		+ " values(?,?,?,?)", contact.getFirstName(),
	   		contact.getLastName(),contact.getPhoneNumber(),contact.getEmailAddress());
   }
   
   public List<Contact> getAll(){
	
	   List<Contact> queryForList = jdbcTemplate.query("select * from contacts",
			   (m,r)->{ 
				   Contact contact=new Contact();
				contact.setId(m.getLong(1) );  
				   contact.setFirstName(m.getString(2));
				   contact.setLastName(m.getString(3));
				   contact.setPhoneNumber(m.getString(4));
				   contact.setEmailAddress(m.getString(5));
				   return contact;
			   });
	   
	   
	   return queryForList;
	   
   }
   
}
