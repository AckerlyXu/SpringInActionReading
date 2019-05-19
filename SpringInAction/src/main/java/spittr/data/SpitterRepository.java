package spittr.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.model.Spitter;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository  {

  long count();
  
  Spitter save(Spitter spitter);
  Spitter update(Spitter spitter);
  Spitter findOne(long id);

  Spitter findByUsername(String username);

  List<Spitter> findAll();

}
