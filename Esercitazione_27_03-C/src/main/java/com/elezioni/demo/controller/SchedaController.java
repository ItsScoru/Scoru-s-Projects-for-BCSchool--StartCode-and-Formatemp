package com.elezioni.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.elezioni.demo.model.Scheda;
import com.elezioni.demo.repository.SchedaRepository;

@Controller
public class SchedaController {

	@Autowired
	SchedaRepository r;

	public void insert(Scheda ogg) {
		r.save(ogg);
	}

	public Scheda findOne(Integer codice) {
		return r.findById(codice).orElse(null);
	}

	public List<Scheda> findAll() {
		return r.findAll();
	}

}
