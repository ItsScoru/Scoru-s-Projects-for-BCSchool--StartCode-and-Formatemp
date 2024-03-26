package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	Libro findByTitolo(String titolo) ;
	
	List<Libro> findAllByIdAutore(Integer idAutore);

}
