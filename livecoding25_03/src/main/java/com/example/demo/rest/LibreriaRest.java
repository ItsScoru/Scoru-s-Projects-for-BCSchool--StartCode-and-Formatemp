package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.AutoreController;
import com.example.demo.controller.LibroController;
import com.example.demo.model.Autore;
import com.example.demo.model.Libro;

@RestController
public class LibreriaRest {
	
	@Autowired
	LibroController libroController;
	
	@Autowired
	AutoreController autoreController;
	
	@RequestMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/findAllAutori")
	public ModelAndView findAllAutori() {
		List<Autore> listaAutori = autoreController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaAutori", listaAutori);
		modelAndView.setViewName("listaAutori.html");
		return modelAndView;
	}
	
	@RequestMapping("/findAllLibri")
	public ModelAndView findAllLibri() {
		List<Libro> listaLibri = libroController.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaLibri", listaLibri);
		modelAndView.setViewName("listaLibri.html");
		return modelAndView;
	}

}
