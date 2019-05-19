package spittr.data.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.data.SpittleRepository;
import spittr.model.Spitter;
import spittr.model.Spittle;
@Repository
public class SimpleSpittleRepository implements SpittleRepository {


	public List<spittr.model.Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return new ArrayList<spittr.model.Spittle>() {{
//			add(new Spittle("xiaoming",new Date(400l)));
//			add(new Spittle("С�졤",new Date(600)));
			
		}};
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<spittr.model.Spittle> findRecent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spittle> findRecent(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle save(Spittle spittle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spittle> findBySpitterId(long spitterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
