package com.java.batch;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.model.FoodItem;
import com.java.repository.FoodItemRepository;

@Component
public class Writer implements ItemWriter<FoodItem> {

	@Autowired
	private FoodItemRepository repo;

	@Override
	@Transactional
	public void write(List<? extends FoodItem> items) throws Exception {
		repo.saveAll(items);
	}

}
