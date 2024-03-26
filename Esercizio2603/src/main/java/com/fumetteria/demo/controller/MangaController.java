package com.fumetteria.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fumetteria.demo.model.Manga;
import com.fumetteria.demo.repository.MangaRepository;

@Controller
public class MangaController {
	
	@Autowired
	MangaRepository mangaRepository;
	
	public List<Manga> findAll() {
		return mangaRepository.findAll();
	}
	
	public Manga findOne(Integer id) {
		return mangaRepository.findById(id).orElse(null);
	}
	
	public void insert(Manga manga) {
		mangaRepository.save(manga);
	}
	
	public List<Manga> findAllByIdAutore(Integer idFumetteria) {
		return mangaRepository.findAllByIdFumetteria(idFumetteria);
	}

}
