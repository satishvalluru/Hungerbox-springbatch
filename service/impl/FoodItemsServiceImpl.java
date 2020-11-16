package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.FoodItemDTO;
import com.java.model.FoodItem;
import com.java.repository.FoodItemRepository;
import com.java.service.FoodItemService;

@Service
public class FoodItemsServiceImpl implements FoodItemService {

	@Autowired
	private FoodItemRepository foodItemsRepository;

	@Override
	public List<FoodItem> listFoodItem() {
		return foodItemsRepository.findAll();
	}

	@Override
	public FoodItem insertNewFoodItems(FoodItem items) {
		return foodItemsRepository.save(items);
	}

	@Override
	public List<FoodItemDTO> findByFoodNameContains(String foodName) {
		List<FoodItem> foodItem = foodItemsRepository.findByFoodNameContains(foodName);
		List<FoodItemDTO> foodItemDtos = new ArrayList<>(); // foodItemDto = null;

		foodItem.stream().forEach(foodItems -> {

			FoodItemDTO foodItemDto = new FoodItemDTO();
			BeanUtils.copyProperties(foodItems, foodItemDto);
			foodItemDtos.add(foodItemDto);

		});

		/*
		 * for (FoodItem foodItems : foodItem) { FoodItemDTO foodItemDto = new
		 * FoodItemDTO(); BeanUtils.copyProperties(foodItems, foodItemDto);
		 * foodItemDtos.add(foodItemDto); }
		 */

		return foodItemDtos;
	}

}
