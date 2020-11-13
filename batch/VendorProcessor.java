package com.java.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.model.Vendors;
import com.java.repository.VendorRepository;

@Component
public class VendorProcessor implements ItemProcessor<Vendors, Vendors> {

	@Autowired
	VendorRepository vendorRepo;

	@Override
	public Vendors process(Vendors vendors) throws Exception {
		Optional<Vendors> vendorsFromDb = vendorRepo.findById(vendors.getVendorId());
		if (vendorsFromDb.isPresent()) {
			vendors.setVendorName(vendors.getVendorName());
		}
		return vendors;
	}
}
