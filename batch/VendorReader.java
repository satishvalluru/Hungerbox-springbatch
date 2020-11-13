package com.java.batch;


import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import com.java.model.Vendors;

public class VendorReader extends FlatFileItemReader<Vendors> {
	
public VendorReader(Resource resource) {
		
		super();
		
		setResource(resource);
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "vendorId", "vendorAccountNumber", "vendorAddress", "vendorEmail", "vendorName", "vendorPhone" });
		lineTokenizer.setDelimiter(",");
	    lineTokenizer.setStrict(false);
	    
	    BeanWrapperFieldSetMapper<Vendors> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Vendors.class);

		LineMapper<Vendors> defaultLineMapper = new DefaultLineMapper<>();
		((DefaultLineMapper<Vendors>) defaultLineMapper).setLineTokenizer(lineTokenizer);
		((DefaultLineMapper<Vendors>) defaultLineMapper).setFieldSetMapper(fieldSetMapper);
		setLineMapper(defaultLineMapper);
	}

}
