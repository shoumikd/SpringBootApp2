package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Nifty50Model;

@Repository
public interface Nifty50ListRepository extends JpaRepository<Nifty50Model, String> {

	 
}
