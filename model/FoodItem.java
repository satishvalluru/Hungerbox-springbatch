package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/*@Entity
@Table(name = "food_items")*/
@Data
@Entity
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String foodName;

	private String foodDescription;

	private Double foodPrice;

	/*
	 * @ManyToOne
	 * 
	 * @JsonBackReference private Vendors vendors;
	 */

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public Double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * public Vendors getVendors() { return vendors; }
	 * 
	 * public void setVendors(Vendors vendors) { this.vendors = vendors; }
	 */

}
