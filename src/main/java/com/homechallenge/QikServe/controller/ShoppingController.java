package com.homechallenge.QikServe.controller;


import com.homechallenge.QikServe.model.ShoppingCartItem;
import com.homechallenge.QikServe.model.TypePromotion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.homechallenge.QikServe.model.Product;
import com.homechallenge.QikServe.model.Promotion;
import com.homechallenge.QikServe.model.ShoppingCart;




//Lembrete: antes de enviar procurar palavras em português e mudar.
public class ShoppingController{
	//private static final String Abscs = null;
	//private Product product;
	TypePromotion typepromo;
	ShoppingCart  shoppingCart = new ShoppingCart();
	List<ShoppingCartItem> cartItems = new ArrayList<>();

	
	//add item to cart
	public void addItem(Product product, int quantity) {   	
	    shoppingCart.add(new ShoppingCartItem(product, quantity));	    
    }
	
	
	//List items to cart
	public List<ShoppingCartItem> listItems() {
		return shoppingCart.getItems();
	}
	
	
	//show the prices per item item | qty | value | total value
	public void Details() {
		for (ShoppingCartItem item : listItems()) {
			if (!item.getProduct().getPromotions().isEmpty()) {
				//System.out.println("entrando");
				//TypePromotion typepromo = item.getProduct().getPromotions().get(0).getType();
			if (item.getProduct().getPromotions().get(0).getType() == typepromo.FLAT_PERCENT) {
				System.out.println(" Item name : "+item.getProduct().getName()
						+" Quantity: "+item.getQuantity()
						+" Item price : $"+item.getProduct().getPrice() 
						+" Total : $"+ item.totalPrice().doubleValue()
						+ " Bonus Promo: $" + item.totalPriceFlatPercent().doubleValue());
				shoppingCart.setTotalWithPromo(item.totalPrice(), item.totalPriceFlatPercent());
				
			}
			
			if (item.getProduct().getPromotions().get(0).getType() == typepromo.QTY_BASED_PRICE_OVERRIDE && item.getQuantity()>=2) {
				System.out.println(" Item name : "+item.getProduct().getName()
						+" Quantity: "+item.getQuantity()
						+" Item price $:"+item.getProduct().getPrice() 
						+" Total : $"+ item.totalPrice().doubleValue()
						+ " Bonus Promo: $" + item.totalPromoQtyOvrPrice());
				shoppingCart.setTotalWithPromo(item.totalPrice(), item.totalPromoQtyOvrPrice());
				
			}
			if (item.getProduct().getPromotions().get(0).getType() == typepromo.BUY_X_GET_Y_FREE && item.getQuantity()>2) {
				System.out.println(" Item name : "+item.getProduct().getName()
						+" Quantity: "+item.getQuantity()
						+" Item price $:"+item.getProduct().getPrice() 
						+" Total : $"+ item.totalPrice().doubleValue()
						+ " Bonus Promo: " + item.totalPromoBuyXgetYfree());
			
			}
			} else {
				System.out.println("ITEM WITHOUT PROMOTION");
				System.out.println(" Item name : "+item.getProduct().getName()
						+" Quantity: "+item.getQuantity()
						+" Item price $:"+item.getProduct().getPrice() 
						+" Total : $"+ item.totalPrice().doubleValue());
						//+ " Bonus Promo: " + item.totalPromoBuyXgetYfree());
			}
		}
		System.out.println(" The total amount of your cart is : " + shoppingCart.total());
		//System.out.println(" The total amount of you cart is : " + shoppingCart.total().doubleValue() - item.t);
		System.out.println("The total amount of your cart with promotions!"
				+ "YOU HAVE TO PAY ONLY: $" +shoppingCart.getTotalShoppingCart());
		
	}
	
	

}
	








