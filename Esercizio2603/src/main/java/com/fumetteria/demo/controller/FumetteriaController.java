package com.fumetteria.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fumetteria.demo.model.Fumetteria;
import com.fumetteria.demo.repository.FumetteriaRepository;

@Controller
public class FumetteriaController {
	
	@Autowired
	FumetteriaRepository fumetteriaRepository;
	
	public void insert(Fumetteria fumetteria) {
		fumetteriaRepository.save(fumetteria);
	}
	
	public Fumetteria findOne(Integer id) {
		Fumetteria fumetteria = fumetteriaRepository.findById(id).orElse(null);
		return fumetteria;
	}
	
	public List<Fumetteria> findAll() {
		List<Fumetteria> listaFumetteria = fumetteriaRepository.findAll();
		return listaFumetteria;
	}

}
