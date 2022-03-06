package com.homechallenge.QikServe.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartItem {
	
	
	private final int quantity;
    private final Product product;
    
    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

	
    public int getQuantity() {
		return quantity;
	}
	public Product getProduct() {
		return product;
	}
	
	 public BigDecimal totalPrice() {
		
	     return BigDecimal.valueOf(quantity * product.getPrice().doubleValue());
	 }
	 
	 public BigDecimal totalPriceAfterPromo() {
		return null;
		 
	 }


	@Override
	public String toString() {
		return "ShoppingCartItem [quantity=" + quantity + ", product=" + product + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(product, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartItem other = (ShoppingCartItem) obj;
		return Objects.equals(product, other.product) && quantity == other.quantity;
	}
	
	 
	 
}