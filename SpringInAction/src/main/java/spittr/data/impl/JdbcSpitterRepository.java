package spittr.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.data.SpitterRepository;
import spittr.model.Spitter;
@Repository
public class JdbcSpitterRepository implements SpitterRepository {
     private JdbcOperations jdbcOperations;
     
     
	
@Autowired
	public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
		super();
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
	
		return 0;
	}
     
	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		jdbcOperations.update(
				"insert into Spitter values(null,?,?,?,?,?)",
				spitter.getUsername(),
				spitter.getPassword(),
		       spitter.getEmail(),
		       spitter.isUpdateByEmail()
				
				);
		return null;
	}

	@Override
	public Spitter findOne(long id) {
		// TODO Auto-generated method stub
		
	return jdbcOperations.queryForObject("select * from spitter where id=?",SpitterRowMapper::mapRow ,id);
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spitter> findAll() {
		// TODO Auto-generated method stub
	return jdbcOperations.query("select * from spitter", SpitterRowMapper::mapRow);
	}

	@Override
	public Spitter update(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

}
