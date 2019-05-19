package spittr.data.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.data.SpitterRepository;
import spittr.model.Spitter;
@Repository

public class HibernateSpitterRepository implements SpitterRepository {

private SessionFactory sessionFactory;	
@Autowired
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
private Session currentSession() {
//return 	sessionFactory.openSession();
	return sessionFactory.getCurrentSession();
}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return findAll().size();
	}

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
       Serializable id=currentSession().save(spitter);
       spitter.setId((Long)id);
       return spitter;
	}

	@Override
	public Spitter update(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Spitter findOne(long id) {
		// TODO Auto-generated method stub
		return  (Spitter)currentSession().get(Spitter.class, id);
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return  (Spitter)currentSession()
				.createCriteria(Spitter.class)
				.add(Restrictions.eq("username",username))
				.list().get(0);
				
	}

	@Override
	public List<Spitter> findAll() {
		// TODO Auto-generated method stub
		return  (List<Spitter>)currentSession().createCriteria(Spitter.class).list();
	}

}
