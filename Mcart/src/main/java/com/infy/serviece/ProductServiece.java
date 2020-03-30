package com.infy.serviece;

import java.util.List;

import com.infy.dto.ProductDto;
import com.infy.entity.Product;
import com.infy.exception.McartException;

public interface ProductServiece {
	public ProductDto addProdcut(ProductDto productDto) throws McartException;
	public List<ProductDto> getAlltablets() throws McartException;
	public List<ProductDto> getAllMobiles() throws McartException;
	public String deleteProductbyProductName(String productName)  throws McartException;

}
