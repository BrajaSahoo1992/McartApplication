package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CartDetails")
public class CartDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartIdDetailsId;
	private int productId;
	private String productName;
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cartId",nullable=false)
	@JsonBackReference
	private Cart cart;
	public CartDetails(){
		
	}
	public int getCartIdDetailsId() {
		return cartIdDetailsId;
	}
	public void setCartIdDetailsId(int cartIdDetailsId) {
		this.cartIdDetailsId = cartIdDetailsId;
	}
	public int getProductId() {
		return productId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
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
	@Override
	public String toString() {
		return "CartDetails [cartIdDetailsId=" + cartIdDetailsId + ", productId=" + productId + ", productName="
				+ productName + ", quantity=" + quantity + ", cart=" + cart + "]";
	}
	
	

}
