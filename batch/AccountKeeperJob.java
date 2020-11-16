package com.java.batch;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.java.model.FoodItem;
import com.java.model.Vendors;


@Component
public class AccountKeeperJob extends JobExecutionListenerSupport {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Value("${input.file}")
	Resource resource;
	
	@Value("${inputVendor.file}")
	Resource resources;

	@Autowired
	FoodItemProcessor processor;
	
	@Autowired
	VendorProcessor vendorProcessor;

	@Autowired
	FoodItemWriter foodItemWriter;
	
	@Autowired
	VendorWriter vendorwriter;

	@Bean(name = "accountJob")
	public Job accountKeeperJob() {

		Step step = stepBuilderFactory.get("step-1").<FoodItem, FoodItem>chunk(1).reader(new FoodItemReader(resource))
				.writer(foodItemWriter).build();

		Job job = jobBuilderFactory.get("accounting-job").incrementer(new RunIdIncrementer()).listener(this).start(step)
				.build();

		return job;
	}
	
	@Bean(name = "vendorJob")
	public Job vendorJob() {

		Step step = stepBuilderFactory.get("step-2").<Vendors, Vendors>chunk(1).reader(new VendorReader(resources))
				.writer(vendorwriter).build();

		Job job = jobBuilderFactory.get("vendor-job").incrementer(new RunIdIncrementer()).listener(this).start(step)
				.build();

		return job;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}

}
