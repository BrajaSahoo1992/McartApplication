package com.infy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.ProductDto;
import com.infy.exception.McartException;
import com.infy.serviece.ProductServiece;

@RestController
public class ProductController {
	@Autowired
	ProductServiece prodServiece;
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) throws McartException{
		
		return new ResponseEntity<ProductDto>(prodServiece.addProdcut(productDto), HttpStatus.OK);
		
	}
	@GetMapping("/tablets")
	public ResponseEntity<List<ProductDto>> getTabletDetails() throws McartException{
		
		return new  ResponseEntity<List<ProductDto>>(prodServiece.getAlltablets(),HttpStatus.OK);	
	}
	@GetMapping("/mobiles")
	public ResponseEntity<List<ProductDto>> getMobileDetails() throws McartException{	
		return new  ResponseEntity<List<ProductDto>>(prodServiece.getAllMobiles(),HttpStatus.OK);		
	}
	@DeleteMapping("/products/{productName}")
	public ResponseEntity<String> deleteProductbyProdcutName( @PathVariable String productName) throws McartException{	
		return new  ResponseEntity<String>(prodServiece.deleteProductbyProductName(productName),HttpStatus.OK);		
	}
	

}
