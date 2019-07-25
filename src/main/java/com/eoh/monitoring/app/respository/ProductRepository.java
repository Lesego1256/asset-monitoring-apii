package com.eoh.monitoring.app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eoh.monitoring.app.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	String status = "Not Assigned";

	@Query("select p from Product p where p.serialNumber=?1")
	public Product getDevice(String serialNumber);
	
	@Query("select p from Product p where p.status=?1")
	public List<Product> getUnassignedDevice(String status);
        
    @Query("select count(*) from Product p")
	public Integer countAll ();
        
        
	
        
	
}
