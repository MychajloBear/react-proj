package de.ukrainewin.store.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.ukrainewin.store.model.Food;

@Repository
public interface FoodRepo extends MongoRepository<Food, String> {

}
