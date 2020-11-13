package com.java.service;

import java.util.List;

import com.java.dto.FoodItemDTO;
import com.java.model.FoodItem;

public interface FoodItemService {

	
	  public List<FoodItem> listFoodItem();
	  
	  public FoodItem insertNewFoodItems(FoodItem items);
	  
	  //public List<FoodItemDTO> searchFoodItemName(String foodName);
	  
	  List<FoodItemDTO> findByFoodNameContains(String foodName);
	 

}
