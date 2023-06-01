package org.java.pizzeria.controller;

import java.util.List;

import org.java.pizzeria.pojo.Offer;
import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.OfferService;
import org.java.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
	@Autowired
	private OfferService offerService;
	
	@GetMapping
	public String getOfferIndex(Model model) {
		List<Offer> offers=offerService.findAll();
		model.addAttribute("offers", offers);
		return "offer-index";
	}
	
	@GetMapping("/create")
	public String getOfferCreateForm(Model model) {
		model.addAttribute("offer", new Offer());
		return "offer-create";
	}
	
	@PostMapping("/create")
	public String storeNewOffer(Model model,@ModelAttribute Offer offer , BindingResult bindingResult) {
		List<Pizza> pizzas=pizzaService.findAll();
		model.addAttribute("offer", offer);
		model.addAttribute("pizzas", pizzas);
		
		pizzaService.save(pizza);
		return "redirect:/offers"; 
	}
}
