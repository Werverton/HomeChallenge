package com.homechallenge.QikServe.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class ShoppingCart {
	//private ShoppingCart shoppingCart;
	private List<ShoppingCartItem> items = new ArrayList<>();
	
	

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

    public void add(ShoppingCartItem item) {
        items.add(item);
    }

    public BigDecimal total() {
        return valueOf(items.stream()
                            .map(item -> item.totalPrice().doubleValue())
                            .reduce((t, acc) -> acc + t).orElse(0.0)).setScale(2, RoundingMode.HALF_EVEN);
    }

    
	public boolean contains(Product product) {
		return items.stream()
					.anyMatch(i -> i.getProduct() == product);
	}

	public int numberOf(Product product) {
		return items.stream()
					.filter(i -> i.getProduct() == product)
					.map(ShoppingCartItem::getQuantity)
					.reduce((quantity, acc) -> acc + quantity)
					.orElse(0);
	}
	
	//item.getProduct().getPromotions().get(0).getType()
	public void applyPromoPrice(List<ShoppingCartItem> items) {
		items.stream().filter(i -> i.getProduct().getPromotions().get(0).getType() == "FLAT_PERCENT").forEach(i-> System.out.println("tem desconto"));
	}

	/*
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}*/

	public List<ShoppingCartItem> getItems() {
		return items;
	}
	

	

	
}