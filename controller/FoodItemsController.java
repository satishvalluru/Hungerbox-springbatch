package com.java.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.FoodItemService;

@RestController
@RequestMapping("/api/order")
public class FoodItemsController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	private FoodItemService itemsService;

	@Autowired
	@Qualifier("accountJob")
	Job accountKeeperJob;

	@RequestMapping("/run-batch-job")
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addString("source", "Spring Boot").toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}

	/*
	 * @PostMapping("/saveFoodItems") public FoodItem insert(@RequestBody FoodItem
	 * foodItem) { return itemsService.insertNewFoodItems(foodItem);
	 * 
	 * }
	 * 
	 * @GetMapping("/searchFoodItemName") public List<FoodItemDTO>
	 * getFoodItemName(@RequestParam String foodName) { return
	 * itemsService.findByFoodNameContains(foodName);
	 * 
	 * }
	 * 
	 * @GetMapping("/all") public List<FoodItem> list() { return
	 * itemsService.listFoodItem();
	 * 
	 * }
	 */

}
