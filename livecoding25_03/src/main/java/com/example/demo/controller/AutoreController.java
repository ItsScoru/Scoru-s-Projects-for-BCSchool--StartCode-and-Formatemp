package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Autore;
import com.example.demo.repository.AutoreRepository;

@Controller
public class AutoreController {
	
	@Autowired
	AutoreRepository autoreRepository;
	
	public void insert(Autore autore) {
		autoreRepository.save(autore);
	}
	
	public Autore findOne(Integer id) {
		Autore autore = autoreRepository.findById(id).orElse(null);
		return autore;
	}
	
	public List<Autore> findAll() {
		List<Autore> listaAutore = autoreRepository.findAll();
		return listaAutore;
	}

}
