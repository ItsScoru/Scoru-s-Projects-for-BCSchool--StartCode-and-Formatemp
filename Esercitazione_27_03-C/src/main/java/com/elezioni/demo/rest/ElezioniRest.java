package com.elezioni.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elezioni.demo.controller.ElettoreController;
import com.elezioni.demo.controller.SchedaController;
import com.elezioni.demo.controller.SeggioController;
import com.elezioni.demo.model.Elettore;
import com.elezioni.demo.model.Scheda;
import com.elezioni.demo.model.Seggio;

@RestController
public class ElezioniRest {
	
	@Autowired
	ElettoreController elettoreController;
	
	@Autowired
	SchedaController schedaController;
	
	@Autowired
	SeggioController seggioController;
	
	@RequestMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/findAllElettori")
	public ModelAndView findAllElettori() {
		List<Elettore> listaElettori = elettoreController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaElettori", listaElettori);
		modelAndView.setViewName("listaElettori.html");
		return modelAndView;
	}
	
	@RequestMapping("/findAllSchede")
	public ModelAndView findAllSchede() {
		List<Scheda> listaSchede = schedaController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaSchede", listaSchede);
		modelAndView.setViewName("listaSchede.html");
		return modelAndView;
	}
	
	@RequestMapping("/findAllSeggi")
	public ModelAndView findAllSeggi() {
		List<Seggio> listaSeggi = seggioController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaSeggi", listaSeggi);
		modelAndView.setViewName("listaSeggi.html");
		return modelAndView;
	}

}
