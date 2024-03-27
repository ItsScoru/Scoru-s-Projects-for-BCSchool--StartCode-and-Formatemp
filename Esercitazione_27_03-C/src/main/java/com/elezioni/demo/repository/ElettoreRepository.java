package com.elezioni.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elezioni.demo.model.Elettore;

public interface ElettoreRepository extends JpaRepository<Elettore, String>{

}