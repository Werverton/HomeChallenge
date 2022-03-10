package com.homechallenge.QikServe.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {

	String id;
	String name;
	BigDecimal price;
	List<Promotion> promotions;
	
	public Product() {}
	
	
	
	public Product(String id, String name, BigDecimal price, List<Promotion> promotions) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.promotions = promotions;
	}



	public Product(String id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public BigDecimal getPrice() {
		return price.divide(new BigDecimal(100)); //Transforming pennies to Dolars
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	public List<Promotion> getPromotions() {
		return promotions;
	}



	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", promotions=" + promotions + "]";
	}
	
	
	



	





	
	}
	
	
	

	

