package com.java.batch;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.model.Vendors;
import com.java.repository.VendorRepository;

@Component
public class VendorWriter implements ItemWriter<Vendors> {

	@Autowired
	private VendorRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Vendors> vendors) throws Exception {
		repo.saveAll(vendors);
	}

}
