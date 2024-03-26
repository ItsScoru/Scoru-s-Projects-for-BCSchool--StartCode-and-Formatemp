package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;

@Controller
public class LibroController {
	
	@Autowired
	LibroRepository libroRepository;
	
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}
	
	public Libro findOne(Integer id) {
		return libroRepository.findById(id).orElse(null);
	}
	
	public void insert(Libro libro) {
		libroRepository.save(libro);
	}
	
	public List<Libro> findAllByIdAutore(Integer idAutore) {
		return libroRepository.findAllByIdAutore(idAutore);
	}

}
