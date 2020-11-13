package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.model.Vendors;

import feign.Param;

@Repository
public interface VendorRepository extends JpaRepository<Vendors, Integer> {

	@Query(value = "select * from vendors v where v.vendor_name = :vendorName", nativeQuery = true)
	List<Vendors> searchVendorName(@Param("vendorName") String vendorName);

	List<Vendors> findByVendorNameContains(String vendorName);

}
