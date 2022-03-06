package com.homechallenge.QikServe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.homechallenge.QikServe.Consuming.Consuming;
import com.homechallenge.QikServe.controller.ShoppingController;
import com.homechallenge.QikServe.model.Product;
import com.homechallenge.QikServe.model.Promotion;
import com.homechallenge.QikServe.model.ShoppingCartItem;


public class testing {
	
	public static void main(String[] args) throws IOException {
		List<Product> products = new ArrayList<Product>(Consuming.findAll()); //instantiate the list of products
		
		List<ShoppingCartItem> cartItems = new ArrayList<>();
		Product p1 = Consuming.findById(products.get(0).getId()); //Amazing Pizza 
		Product p2 = Consuming.findById(products.get(1).getId()); //Amazing Burger
		Product p3 = Consuming.findById(products.get(2).getId()); //Amazing Salad
		Product p4 = Consuming.findById(products.get(3).getId()); //Boring Fries
		
		
		
		//System.out.println(p2);
		
		
		
		ShoppingController sp = new ShoppingController();
		
		sp.addItem(p4, 3);
		sp.addItem(p3, 2);
		sp.addItem(p2, 5);
		sp.addItem(p1, 4);
		//System.out.println(sp.hasPromo());
		
		//System.out.println(sp.ApplyingPromos());
		//cartItems = sp.listItems();
		
		//show the details:
		sp.Details();
		//sp.ApplyingPromos(cartItems);
		
		
		
	
	}

	
	}
	
		


