package com.elezioni.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elezioni.demo.model.Scheda;

public interface SchedaRepository extends JpaRepository<Scheda, Integer>{

}