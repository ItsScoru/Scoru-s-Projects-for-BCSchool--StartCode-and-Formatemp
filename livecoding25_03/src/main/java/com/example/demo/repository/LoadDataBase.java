package com.example.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Autore;
import com.example.demo.model.Libro;

@Configuration
public class LoadDataBase {
	
	private static final Logger log =  LoggerFactory.getLogger(LoadDataBase.class);
	
	@Bean
	CommandLineRunner initDataBase(LibroRepository libroRepository, AutoreRepository autoreRepository) {
		return args -> {
			try {
				
				log.info("Preloading " + autoreRepository.save(new Autore(1, "J.R.R", "Tolkien")));
				log.info("Preloading " + autoreRepository.save(new Autore(2, "Ernest", "Hemingway")));
				log.info("Preloading " + autoreRepository.save(new Autore(3, "Donato", "Carrisi")));
				log.info("Preloading " + autoreRepository.save(new Autore(4, "Maria", "Marcone")));
				log.info("Preloading " + autoreRepository.save(new Autore(5, "Juan", "Martis")));
				
				log.info("Preloading " + libroRepository.save(new Libro(1, "Il signore degli anelli", 1)));
				log.info("Preloading " + libroRepository.save(new Libro(2, "La casa delle voci", 3)));
				
			} catch (Exception e) {
				
				log.error("Something went wrong while inserting into database ->" + e.getClass().getSimpleName());
				
			}
			
			String titolo  = "Il signore degli anelli";
			Autore autore = autoreRepository.findById(1).orElse(null);
			
			log.info("\r\n Tutti i libri con titolo \"" + titolo + "\"" + libroRepository.findByTitolo(titolo));
			log.info("\r\n Tutti gli autori " + autoreRepository.findAll());
			log.info("\r\n Tutti i libri con autore " + autore + ":\r\n"+ libroRepository.findAllByIdAutore(autore.getId()));
			
		};
	}

}
