package com.homechallenge.QikServe.controller;


import com.homechallenge.QikServe.model.ShoppingCartItem;

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
			/*System.out.println(" Item name : "+item.getProduct().getName()+" Quantity: "
					+item.getQuantity()+" Item price :"+item.getProduct().getPrice() 
					+" Total : "+ item.totalPrice().doubleValue()+"");*/
			if (!item.getProduct().getPromotions().isEmpty()) {
				String typepromo = item.getProduct().getPromotions().get(0).getType();
				switch (typepromo) {
				case "FLAT_PERCENT":
					//System.out.println("desconto de 10%");
					//BigDecimal flat_discount;
					//item.getProduct().setPrice(flat_discount = item.getProduct().getPrice());
					BigDecimal flat_discount = item.totalPrice().subtract(item.totalPrice().multiply(new BigDecimal(1.10)));
					System.out.println(" Item name : "+item.getProduct().getName()+" Quantity: "
							+item.getQuantity()+" Item price :"+item.getProduct().getPrice() 
							+" Total : "+ item.totalPrice().doubleValue()+"-"+ flat_discount.setScale(2, RoundingMode.HALF_EVEN));
					//System.out.println(item.getProduct().getName() +""+ flat_percercet_discount+"\n");
				case "BUY_X_GET_Y_FREE":
					if(item.getQuantity()> 2) {
						System.out.println("You got a third Amazing burger for free\n");
					}
					
				case "QTY_BASED_PRICE_OVERRIDE":
					if (item.getQuantity() == 2) {
						BigDecimal qty_based_discount = item.totalPrice().subtract(item.totalPrice().multiply(new BigDecimal(1.20).setScale(2, RoundingMode.HALF_EVEN)));
						System.out.println(qty_based_discount);
					}
					System.out.println(" Item name : "+item.getProduct().getName()+" Quantity: "
							+item.getQuantity()+" Item price :"+item.getProduct().getPrice() 
							+" Total : "+ item.totalPrice().doubleValue());

				default:
					break;
				}
					//System.out.println(item.getProduct().getName()+"has the promotion: "+ typepromo +" 10% off");
				
				
			} 
		}
		System.out.println("The total amount of you cart is : "+shoppingCart.total());
		shoppingCart.applyPromoPrice(cartItems);
		
	}
	
	
	
	public void hasPromo() {
		
		for (ShoppingCartItem item : listItems()) {
			if (!item.getProduct().getPromotions().isEmpty()) {
				String typepromo = item.getProduct().getPromotions().get(0).getType();
				
				if (typepromo == "FLAT_PERCENT") {
					System.out.println(typepromo);
				}
				if (item.getProduct().getPromotions().get(0).getType() == "BUY_X_GET_Y_FREE") {
					System.out.println(typepromo);
				}
				if (item.getProduct().getPromotions().get(0).getType() == "QTY_BASED_PRICE_OVERRIDE") {
					System.out.println(typepromo);
				}
				//System.out.println(item.getProduct().getPromotions().get(0).getType());				
			}
		}
		
		
		
	}
	
	/*
	 * public boolean ApplyingPromos() { for (ShoppingCartItem item : cartItems) {
	 * if (!item.getProduct().getPromotions().isEmpty()) {
	 * 
	 * //System.out.println("aplply qty based price override"); }
	 * 
	 * } //System.out.println(" Item name : "+item.getProduct().getName()
	 * +" Quantity: "+item.getQuantity()+" Item price :"+item.getProduct().getPrice(
	 * ) +" Total : "+ item.totalPrice().doubleValue());
	 * 
	 * 
	 * return false; }
	 */
}
	/*
if (promo.getType() == "BUY_X_GET_Y_FREE" && item.getQuantity()> 2) {
	//apply promo
	System.out.println("applyt sfuahsdfhasd");
}
if (promo.getType() == "FLAT_PERCENT") {
	//apply preço do item - 10%
	
	System.out.println("apllasdfuashd"); //System.out.println(item.getProduct().getPromotions());
				for (Promotion promo : item.getProduct().getPromotions()) {					
					if (promo.getType() == "QTY_BASED_PRICE_OVERRIDE" && item.getQuantity()> 2) {
						return true;
}
		*/









