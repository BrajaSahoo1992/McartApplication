package com.infy.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="CART")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	private String userName;
	private Date dateOfCretion;
	private Date dateOfModification;
    private String statusOfCart;
    
	public Date getDateOfCretion() {
		return dateOfCretion;
	}

	public void setDateOfCretion(Date dateOfCretion) {
		this.dateOfCretion = dateOfCretion;
	}

	public Date getDateOfModification() {
		return dateOfModification;
	}

	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	public String getStatusOfCart() {
		return statusOfCart;
	}

	public void setStatusOfCart(String statusOfCart) {
		this.statusOfCart = statusOfCart;
	}

	public Cart(){
		
	}
    @OneToMany(cascade = CascadeType.ALL,mappedBy="cart")
    @JsonManagedReference
    private List<CartDetails> cartDetails;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CartDetails> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetails> cartDetails) {
		
		this.cartDetails = cartDetails;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userName=" + userName + ", dateOfCretion=" + dateOfCretion
				+ ", dateOfModification=" + dateOfModification + ", statusOfCart=" + statusOfCart + ", cartDetails="
				+ cartDetails + "]";
	}

	
	

}
