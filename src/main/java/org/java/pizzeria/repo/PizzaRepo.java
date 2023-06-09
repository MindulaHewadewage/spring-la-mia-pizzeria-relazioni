package org.java.pizzeria.repo;

import java.util.List;

import org.java.pizzeria.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PizzaRepo extends JpaRepository<Pizza, Integer>{
	public List<Pizza> findByName(String name);
}
