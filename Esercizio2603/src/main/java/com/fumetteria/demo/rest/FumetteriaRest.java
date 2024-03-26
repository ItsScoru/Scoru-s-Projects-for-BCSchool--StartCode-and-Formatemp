package com.fumetteria.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fumetteria.demo.controller.FumetteriaController;
import com.fumetteria.demo.controller.MangaController;
import com.fumetteria.demo.model.Fumetteria;
import com.fumetteria.demo.model.Manga;

@RestController
public class FumetteriaRest {
	
	@Autowired
	MangaController mangaController;
	
	@Autowired
	FumetteriaController fumetteriaController;
	
	@RequestMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/findAllFumetterie")
	public ModelAndView findAllFumetterie() {
		List<Fumetteria> listaFumetterie = fumetteriaController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaFumetterie", listaFumetterie);
		modelAndView.setViewName("listaFumetterie.html");
		return modelAndView;
	}
	
	@RequestMapping("/findAllManga")
	public ModelAndView findAllManga() {
		List<Manga> listaManga = mangaController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaManga", listaManga);
		modelAndView.setViewName("listaManga.html");
		return modelAndView;
	}

}
