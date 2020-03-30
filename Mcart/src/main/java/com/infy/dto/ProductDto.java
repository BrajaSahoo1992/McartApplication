package com.infy.dto;

import javax.validation.constraints.NotNull;

import com.infy.entity.Product;

public class ProductDto {
	private int productId;
	@NotNull(message="productName is mandatory")
	private String productName;
	@NotNull(message="produtCode is mandatory")
	private String produtCode;
	@NotNull(message="description is mandatory")
    private String description;
	@NotNull(message="imageUrl is mandatory")
    private String imageUrl;
    private double price;
    @NotNull(message="manufacturer is mandatory")
    private String manufacturer;
    @NotNull(message="osType is mandatory")
    private String osType;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProdutCode() {
		return produtCode;
	}
	public void setProdutCode(String produtCode) {
		this.produtCode = produtCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", produtCode=" + produtCode
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", price=" + price + ", manufacturer="
				+ manufacturer + ", osType=" + osType + "]";
	}
    
	public static ProductDto convertToProductDto(Product product){
		ProductDto productDto=new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setProdutCode(product.getProdutCode());
		productDto.setPrice(product.getPrice());
		productDto.setOsType(product.getOsType());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setManufacturer(product.getManufacturer());
		productDto.setDescription(product.getDescription());
		
		return productDto;
		
		
	}
	public static Product convertToProduct(ProductDto productDto){
		Product product=new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProdutCode(productDto.getProdutCode());
		product.setPrice(productDto.getPrice());
		product.setOsType(productDto.getOsType());
		product.setImageUrl(productDto.getImageUrl());
		product.setManufacturer(productDto.getManufacturer());
		product.setDescription(productDto.getDescription());
		
		return product;
		
		
	}

}
