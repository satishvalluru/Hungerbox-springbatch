package com.java.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.model.FoodItem;
import com.java.repository.FoodItemRepository;

@Component
public class FoodItemProcessor implements ItemProcessor<FoodItem, FoodItem> {

	@Autowired
	private FoodItemRepository foodItemRepo;

	@Override
	public FoodItem process(FoodItem foodItem) throws Exception {
		Optional<FoodItem> foodItemFromDb = foodItemRepo.findById(foodItem.getId());
		if(foodItemFromDb.isPresent()) {
			foodItem.setFoodName(foodItem.getFoodName());
			foodItem.setFoodDescription(foodItem.getFoodDescription());
			foodItem.setFoodPrice(foodItem.getFoodPrice());
			foodItem.setId(foodItem.getId());
		}
		return foodItem;
	}
}
