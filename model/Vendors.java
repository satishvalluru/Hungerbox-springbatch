package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
//@Table(name = "vendors")
public class Vendors {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vendorId;

	private String vendorName;

	private String vendorAddress;

	private String vendorPhone;

	private String vendorEmail;
	
	private Long vendorAccountNumber;

	/*
	 * @OneToMany private List<FoodItem> foodItems;
	 */

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	/*
	 * public List<FoodItem> getFoodItems() { return foodItems; }
	 * 
	 * public void setFoodItems(List<FoodItem> foodItems) { this.foodItems =
	 * foodItems; }
	 */

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Long getVendorAccountNumber() {
		return vendorAccountNumber;
	}

	public void setVendorAccountNumber(Long vendorAccountNumber) {
		this.vendorAccountNumber = vendorAccountNumber;
	}

}
