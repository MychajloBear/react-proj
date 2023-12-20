package de.ukrainewin.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import de.ukrainewin.store.model.Food;
import de.ukrainewin.store.model.FoodDTO;
import de.ukrainewin.store.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping
	public List<Food> listFoods(@RequestParam Optional<String> search) {
		if (search.isPresent()) {
			return foodService.search(search.get()); 
		}
		return foodService.list();
	}

	@GetMapping("{id}")
	public Food getFood(@PathVariable String id) {
		return foodService.findById(id);
	}

	@PostMapping()
	public Food addFood(@RequestBody FoodDTO foodDTO) {
		return foodService.addFood(foodDTO);
	}

	@DeleteMapping("{id}")
	public void deleteFood(@PathVariable String id) {
		foodService.delete(id);
	}
	
	@PutMapping("{id}")
	public void putFood(@PathVariable String id) {
		foodService.delete(id);
	}
	
	// @GetMapping("header")
	// public String getHeader(@RequestParam Optional<String> search) {
	// 	return "TestHeaderFromBackend";
	// }

}

