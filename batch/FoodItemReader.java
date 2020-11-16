package com.java.batch;


import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import com.java.model.FoodItem;

public class FoodItemReader extends FlatFileItemReader<FoodItem> {
	
public FoodItemReader(Resource resource) {
		
		super();
		
		setResource(resource);
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "food_description", "food_name", "food_price" });
		lineTokenizer.setDelimiter(",");
	    lineTokenizer.setStrict(false);
	    
	    BeanWrapperFieldSetMapper<FoodItem> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FoodItem.class);

		DefaultLineMapper<FoodItem> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		setLineMapper(defaultLineMapper);
	}

}
