package com.java.dto;

import java.util.List;

public class UserOrdersDTO {

	private Integer userId;
	
	private Integer userAccountNumber;;

	private List<FoodItemQuantityDTO> foodItemQuantityDto;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<FoodItemQuantityDTO> getFoodItemQuantityDto() {
		return foodItemQuantityDto;
	}

	public void setFoodItemQuantityDto(List<FoodItemQuantityDTO> foodItemQuantityDto) {
		this.foodItemQuantityDto = foodItemQuantityDto;
	}

	public Integer getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(Integer userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

}
