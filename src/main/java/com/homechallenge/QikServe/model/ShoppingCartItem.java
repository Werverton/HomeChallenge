package com.homechallenge.QikServe.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartItem {
	
	
	private final int quantity;
    private final Product product;
    Promotion promotion;
    
    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    
    
    

	
    public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public int getQuantity() {
		return quantity;
	}
	public Product getProduct() {
		return product;
	}
	//Total per item before any promotion
	 public BigDecimal totalPrice() {
		
	     return BigDecimal.valueOf(quantity * product.getPrice().doubleValue());
	 }
	 
	 //applying flat_percent
	 public BigDecimal totalPriceFlatPercent() {
		System.out.println("Promotion Applied: "+TypePromotion.FLAT_PERCENT +" applied");	
		 double discount = (totalPrice().doubleValue() * 1.10) - totalPrice().doubleValue();
			
	     return BigDecimal.valueOf(totalPrice().doubleValue() - discount);
	 }
	 
	 
	 //applying qty_based_price_override
	 public BigDecimal totalPromoQtyOvrPrice() {
		 System.out.println("Promotion Applied: "+ TypePromotion.QTY_BASED_PRICE_OVERRIDE);
		 //set to this price 8,995
		 
		 
		 return BigDecimal.valueOf(8.995 * quantity);
		
		 
	 }
	 
	 public String totalPromoBuyXgetYfree() {
		 System.out.println("Promotion Applied: " + TypePromotion.BUY_X_GET_Y_FREE);
		 return "you got a third one free";
	 }
	 


	@Override
	public String toString() {
		return "ShoppingCartItem [quantity=" + quantity + ", product=" + product + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(product, promotion, quantity);
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
		return Objects.equals(product, other.product) && Objects.equals(promotion, other.promotion)
				&& quantity == other.quantity;
	}
	
	 
	 
}