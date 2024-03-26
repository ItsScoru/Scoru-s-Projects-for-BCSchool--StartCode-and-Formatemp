package com.fumetteria.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fumetteria.demo.model.Fumetteria;
import com.fumetteria.demo.model.Manga;

@Configuration
public class LoadDataBase {
	
	private static final Logger log =  LoggerFactory.getLogger(LoadDataBase.class);
	
	@Bean
	CommandLineRunner initDataBase(MangaRepository mangaRepository, FumetteriaRepository fumetteriaRepository) {
		return args -> {
			try {
				
				log.info("Preloading " + fumetteriaRepository.save(new Fumetteria(1, "Fun&Games")));
				log.info("Preloading " + fumetteriaRepository.save(new Fumetteria(2, "DungeonBook")));
				log.info("Preloading " + fumetteriaRepository.save(new Fumetteria(3, "Feltrinelli")));
				log.info("Preloading " + fumetteriaRepository.save(new Fumetteria(4, "Mondadori")));
				log.info("Preloading " + fumetteriaRepository.save(new Fumetteria(5, "FantasiaBookStore")));
				
				log.info("Preloading " + mangaRepository.save(new Manga(1, "Dragon Ball", 1)));
				log.info("Preloading " + mangaRepository.save(new Manga(2, "One Piece", 5)));
				
			} catch (Exception e) {
				
				log.error("Something went wrong while inserting into database ->" + e.getClass().getSimpleName());
				
			}
			
			String titolo  = "Dragon Ball";
			//Fumetteria fumetteria = fumetteriaRepository.findById(1).orElse(null);
			
			log.info("\r\n Tutti i manga con titolo \"" + titolo + "\"" + mangaRepository.findByTitolo(titolo));
			log.info("\r\n Tutte le fumetterie " + fumetteriaRepository.findAll());
			log.info("\r\n Tutti i manga " + mangaRepository.findAll());
			//log.info("\r\n Tutti i libri con autore " + fumetteria + ":\r\n"+ mangaRepository.findAllByIdAutore(fumetteria.getId()));
			
		};
	}

}
