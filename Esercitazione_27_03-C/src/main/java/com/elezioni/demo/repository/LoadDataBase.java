package com.elezioni.demo.repository;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elezioni.demo.model.Elettore;
import com.elezioni.demo.model.Scheda;
import com.elezioni.demo.model.Seggio;
import com.elezioni.demo.model.Ubicazione;

@Configuration
public class LoadDataBase {
	
	private static final Logger log =  LoggerFactory.getLogger(LoadDataBase.class);
	
	@Bean
	CommandLineRunner initDataBase(ElettoreRepository elettoreRepository, SchedaRepository schedaRepository, SeggioRepository seggioRepository) {
		return args -> {
			try {
				
				log.info("Preloading " + seggioRepository.save(new Seggio(1234, new Ubicazione("1234", "Roma", "Roma", "Lazio"), new Date(124, 03, 27))));
				
				log.info("Preloading " + schedaRepository.save(new Scheda(12345, new Date(130, 6, 6), 1234)));
				log.info("Preloading " + schedaRepository.save(new Scheda(54321, new Date(134, 11, 10), 1234)));
				log.info("Preloading " + schedaRepository.save(new Scheda(11111, new Date(126, 7, 18), 1234)));
				log.info("Preloading " + schedaRepository.save(new Scheda(13579, new Date(129, 3, 14), 1234)));
				log.info("Preloading " + schedaRepository.save(new Scheda(24680, new Date(131, 12, 29), 1234)));
				
				log.info("Preloading " + elettoreRepository.save(new Elettore("ABC123DEF", "Mario", "Rossi", 12345)));
				log.info("Preloading " + elettoreRepository.save(new Elettore("AAA111BBB", "Pippo", "Programmini", 54321)));
				log.info("Preloading " + elettoreRepository.save(new Elettore("ZYX987WUT", "Fabio", "Verdi", 11111)));
				log.info("Preloading " + elettoreRepository.save(new Elettore("ZZZ999XXX", "Marco", "Bianchi", 13579)));
				log.info("Preloading " + elettoreRepository.save(new Elettore("NUM150RND", "Chiara", "Neri", 24680)));
				
			} catch (Exception e) {
				
				log.error("Something went wrong while inserting into database ->" + e.getClass().getSimpleName());
				
			}
			
			Integer numSeggio = 1234;
			
			log.info("\r\n Tutti gli elettori" + elettoreRepository.findAll());
			
		};
	}

}
