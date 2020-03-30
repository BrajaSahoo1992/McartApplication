package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	@Query(value="select * from Product_Details where PRODUCT_CODE like 'Tab%'",nativeQuery=true)
	public List<Product> getAllTablets();
	
	@Query(value="select * from Product_Details where PRODUCT_CODE like 'Mob%'",nativeQuery=true)
	public List<Product> getAllMobiles();
	
	@Query(value=" select * from Product_Details where PRODUCT_NAME= ? ",nativeQuery=true)
	public Product getProductByProductName(String productName);

}
