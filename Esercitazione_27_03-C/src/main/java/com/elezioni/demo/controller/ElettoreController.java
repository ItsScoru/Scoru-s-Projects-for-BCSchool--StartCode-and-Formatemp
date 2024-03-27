package com.elezioni.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.elezioni.demo.model.Elettore;
import com.elezioni.demo.repository.ElettoreRepository;

@Controller
public class ElettoreController {
	
	@Autowired
	ElettoreRepository r;
	
	public void insert(Elettore ogg) {
		r.save(ogg);
	}
	
	public Elettore findOne(String codiceFiscale) {
		return r.findById(codiceFiscale).orElse(null);
	}
	
	public List<Elettore> findAll() {
		return r.findAll();
	}

}
