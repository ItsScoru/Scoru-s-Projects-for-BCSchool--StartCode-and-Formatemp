package com.elezioni.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elezioni.demo.model.Seggio;

public interface SeggioRepository extends JpaRepository<Seggio, Integer>{

}