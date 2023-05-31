package org.java.pizzeria;

import java.util.List;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pizza p1 = new Pizza("Tonno e cipolla","Molto buona","https://media-assets.lacucinaitaliana.it/photos/61fbd8df3697f3ffd0cffbc5/3:2/w_1200,h_800,c_limit/pizza-tonno-cipolle-800.jpg",10);
		Pizza p2 = new Pizza("Margerita","Molto buona","https://www.finedininglovers.it/sites/g/files/xknfdk1106/files/styles/recipes_1200_800_fallback/public/fdl_content_import_it/margherita-50kalo.jpg?itok=v9nHxNMS",8);
		Pizza p3 = new Pizza("Capricciosa","Molto buona","https://www.buttalapasta.it/wp-content/uploads/2017/11/pizza-capricciosa.jpg",9);
		Pizza p4 = new Pizza("Napoli","Molto buona","https://images.prismic.io/nahrin/f0adafb8-72c8-4f99-9b4d-ce0483071853_knuspriges-pizza-napoli-rezept-einfach-schnell-zubereitet.jpg?auto=compress,format",10);
		Pizza p5 = new Pizza("Maialona","Molto buona","https://media-cdn.tripadvisor.com/media/photo-s/16/57/6c/e3/pizza-maialona.jpg",11);
		Pizza p6 = new Pizza("Vegetariana","Molto buona","https://cdn.loveandlemons.com/wp-content/uploads/2023/02/vegetarian-pizza.jpg",8);

		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		pizzaService.save(p6);
		
		
		List<Pizza> pizzas=pizzaService.findAll();
		System.out.println(pizzas);
	}

}
