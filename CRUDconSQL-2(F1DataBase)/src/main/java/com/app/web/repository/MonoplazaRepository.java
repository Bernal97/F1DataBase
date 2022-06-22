package com.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.web.entity.Monoplaza;

@Repository
public interface MonoplazaRepository extends JpaRepository<Monoplaza, Long> {

	@Query("SELECT e FROM Monoplaza e WHERE e.equipo LIKE %?1%")
	public List<Monoplaza> findAll(String equipoClave);
}
