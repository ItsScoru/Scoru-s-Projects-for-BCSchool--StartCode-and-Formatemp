package com.elezioni.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.elezioni.demo.model.Seggio;
import com.elezioni.demo.repository.SeggioRepository;

@Controller
public class SeggioController {

	@Autowired
	SeggioRepository r;

	public void insert(Seggio ogg) {
		r.save(ogg);
	}

	public Seggio findOne(Integer codice) {
		return r.findById(codice).orElse(null);
	}

	public List<Seggio> findAll() {
		return r.findAll();
	}

}
