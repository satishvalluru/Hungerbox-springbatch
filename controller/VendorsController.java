package com.java.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendors")
public class VendorsController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("vendorJob")
	Job accountKeeperJob;

	@RequestMapping("/run-vendorbatch-job")
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addString("source", " Boot1").toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}
}
