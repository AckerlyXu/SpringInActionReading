package spittr.data;

import java.util.List;

import spittr.model.Spitter;
import spittr.model.Spittle;

/**
 * Repository interface with operations for {@link Spittle} persistence.
 * @author habuma
 */
public interface SpittleRepository {

  long count();
  
  List<spittr.model.Spittle> findRecent();

  List<Spittle> findRecent(int count);

  Spittle findOne(long id);

  Spittle save(Spittle spittle);
    
  List<Spittle> findBySpitterId(long spitterId);
  
  void delete(long id);
    
}
