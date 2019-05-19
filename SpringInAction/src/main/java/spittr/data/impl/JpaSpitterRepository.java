package spittr.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.data.SpitterRepository;
import spittr.model.Spitter;
@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {
@PersistenceContext
private EntityManager emf;
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		  emf.persist(spitter);
		  return null;
	}

	@Override
	public Spitter update(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter findOne(long id) {
		// TODO Auto-generated method stub
		return  emf.find(Spitter.class, id);
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spitter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
