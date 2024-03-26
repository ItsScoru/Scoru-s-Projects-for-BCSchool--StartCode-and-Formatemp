package com.fumetteria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fumetteria.demo.model.Fumetteria;

public interface FumetteriaRepository extends JpaRepository<Fumetteria, Integer>{

}
