package spittr.config;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.model.Spitter;

public interface SpitterJpaRepository extends JpaRepository<Spitter	,Long> {

}
