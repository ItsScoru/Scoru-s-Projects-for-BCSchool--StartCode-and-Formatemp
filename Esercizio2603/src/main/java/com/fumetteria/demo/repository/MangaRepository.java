package com.fumetteria.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fumetteria.demo.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer>{
	
	Manga findByTitolo(String titolo);
	
	List<Manga> findAllByIdFumetteria(Integer idFumetteria);

}
