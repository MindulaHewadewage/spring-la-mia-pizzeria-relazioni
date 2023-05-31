package org.java.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getPizzaIndex(Model model) {
		List<Pizza> pizzas=pizzaService.findAll();
		 model.addAttribute("pizzas", pizzas);
		return "index";
	}
	

	

	
	
    @GetMapping("/pizzas/{id}")
	public String getPizzaShow(
			Model model,
			@PathVariable("id") int id
	) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	@GetMapping("/pizzas/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/pizzas/create")
	public String store(@ModelAttribute Pizza pizza) {
		pizzaService.save(pizza);
		return "redirect:/";
	}
	
	@PostMapping("/pizzas/search")
	public String getPizzasByName(Model model,@RequestParam("search")String name) {
		List<Pizza> pizzas=pizzaService.findByName(name);
		 model.addAttribute("pizzas", pizzas);
		 model.addAttribute("search",name);
		 
		return "index";
	}
	
	@GetMapping("/pizzas/delete{id}")
	public String delete(@PathVariable int id) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		pizzaService.delete(pizza);
		return "redirect:/";
	}
	
	@GetMapping("/pizzas/update{id}")
	public String edit(Model model,@PathVariable int id) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		model.addAttribute("pizza", pizza);
		return "update";
	}
	
	@PostMapping("/pizzas/update{id}")
	public String update(Model model,@PathVariable int id,@ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		return "redirect:/";
	}
}
