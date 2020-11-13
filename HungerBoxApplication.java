package com.java;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class HungerBoxApplication implements CommandLineRunner {

	/*
	 * @Autowired JobLauncher jobLauncher;
	 * 
	 * @Autowired JobOperator jobOperator;
	 * 
	 * @Autowired Job job;
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(HungerBoxApplication.class, args);
	}
	
	/*
	 * @Scheduled(fixedDelay = 30000) public void doJob() { JobParameters parameters
	 * = new JobParametersBuilder().addString("JobID",
	 * String.valueOf(System.currentTimeMillis())) .addString("JobName",
	 * job.getName()).toJobParameters(); try { jobLauncher.run(job, parameters); }
	 * catch (JobExecutionAlreadyRunningException e) { e.printStackTrace(); // TODO:
	 * handle exception } catch (JobRestartException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (JobInstanceAlreadyCompleteException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (JobParametersInvalidException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
