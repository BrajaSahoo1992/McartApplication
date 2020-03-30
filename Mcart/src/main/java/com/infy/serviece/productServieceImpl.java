package com.infy.serviece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ProductDto;
import com.infy.entity.Product;
import com.infy.exception.McartException;
import com.infy.exception.ProductNotFoundException;
import com.infy.repository.ProductRepository;

@Service("productServieceImpl")
public class productServieceImpl implements ProductServiece{
	
	@Autowired
	ProductRepository prodRepo;

	@Override
	public ProductDto addProdcut(ProductDto productDto) throws McartException {
		Product product= ProductDto.convertToProduct(productDto);
		Product prod =prodRepo.saveAndFlush(product);	
		return productDto.convertToProductDto(prod);
	}

	@Override
	public List<ProductDto> getAlltablets() throws McartException {
		// TODO Auto-generated method stub
		List<Product> products=prodRepo.getAllTablets();
		ArrayList<ProductDto> prodDto= new ArrayList<>();
		for(Product product: products){
			
			ProductDto pDto=ProductDto.convertToProductDto(product);
			prodDto.add(pDto);
			
		}
		return prodDto;
	}

	@Override
	public List<ProductDto> getAllMobiles() throws McartException {
		List<Product> products=prodRepo.getAllTablets();
		ArrayList<ProductDto> prodDto= new ArrayList<>();
		for(Product product: products){
			
			ProductDto pDto=ProductDto.convertToProductDto(product);
			prodDto.add(pDto);
			
		}
		return prodDto;
	}

	@Override
	public String deleteProductbyProductName(String productName) throws McartException {
		
		Product product=prodRepo.getProductByProductName(productName);
		if(product!=null){
			prodRepo.deleteById(product.getProductId());
			return productName+" deleted Sucessfully";
		}
		else{
			throw new ProductNotFoundException(productName+" is not availabel");
		}
	}

}
