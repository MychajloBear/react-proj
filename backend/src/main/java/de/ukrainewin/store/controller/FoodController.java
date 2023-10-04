package de.ukrainewin.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.ukrainewin.store.model.Food;
import de.ukrainewin.store.model.FoodDTO;
import de.ukrainewin.store.service.FoodService;

@RestController
@RequestMapping("api")
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping("food")
	public List<Food> listFoods(@RequestParam Optional<String> search) {
		if (search.isPresent()) {
			return foodService.search(search.get()); 
		}
		return foodService.list();
	}

	@GetMapping("food/{id}")
	public Food getFood(@PathVariable String id) {
		return foodService.findById(id);
	}

	@PostMapping("food")
	public Food addFood(@RequestBody FoodDTO foodDTO) {
		return foodService.addFood(foodDTO);
	}

	@DeleteMapping("food/{id}")
	public void deleteFood(@PathVariable String id) {
		foodService.delete(id);
	}
	
	@PutMapping("food/{id}")
	public void putFood(@PathVariable String id) {
		foodService.delete(id);
	}
	
	// @GetMapping("header")
	// public String getHeader(@RequestParam Optional<String> search) {
	// 	return "TestHeaderFromBackend";
	// }

}

