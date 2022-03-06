package com.homechallenge.QikServe.model;


public class Promotion {
	String id;
	String type;
	int required_qty;
	int amount;
	int free_qty;
	Double price;
	
	
	
	
	//contrutor da salada
	
	public Promotion(String id, String type, int amount) {
		this.id = id;
		this.type = type;
		this.amount = amount;
	}
	
	//contrutor da pizza
	public Promotion(String id, String type, int required_qty, Double price) {
		this.id = id;
		this.type = type;
		this.required_qty = required_qty;
		this.price = price;
	}
	
	
	//construtor do hamburguer
	public Promotion(String id, String type, int required_qty, int free_qty) {
		this.id = id;
		this.type = type;
		this.required_qty = required_qty;
		this.free_qty = free_qty;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRequired_qty() {
		return required_qty;
	}
	public void setRequired_qty(int required_qty) {
		this.required_qty = required_qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public int getFree_qty() {
		return free_qty;
	}


	public void setFree_qty(int free_qty) {
		this.free_qty = free_qty;
	}


	@Override
	public String toString() {
		return "Promotion [id=" + id + ", type=" + type + ", required_qty=" + required_qty + ", amount=" + amount
				+ ", free_qty=" + free_qty + ", price=" + price + "]";
	}
	
}