package com.homechallenge.QikServe;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.homechallenge.QikServe.Consuming.Consuming;
import com.homechallenge.QikServe.controller.ShoppingController;
import com.homechallenge.QikServe.model.Product;


public class CliInterface {

	public static void main(String[] args) throws IOException {
		List<Product> products = new ArrayList<Product>(Consuming.findAll()); //instantiate the list of products

		//List<ShoppingCartItem> cartItems = new ArrayList<>();
		Product p1 = Consuming.findById(products.get(0).getId()); //Amazing Pizza 
		Product p2 = Consuming.findById(products.get(1).getId()); //Amazing Burger
		Product p3 = Consuming.findById(products.get(2).getId()); //Amazing Salad
		Product p4 = Consuming.findById(products.get(3).getId()); //Boring Fries

		ShoppingController sp = new ShoppingController();

	
		
		System.out.println("Select one of the products!");
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Press a to select Amazing Pizza!");
			System.out.println("Press b to select Amazing Burger!");
			System.out.println("Press c to select Amazing Salad!");
			System.out.println("Press d to select Boring Fries!");
			System.out.println("Press q to exit");
			System.out.println("Press E to checkout");
			
			String pick;
			
			do {
				System.out.println("Choose an option: ");
				
				pick = scan.nextLine();
				int qty = 0;
				switch (pick) {
				case "a":
					
					System.out.println("How many?: ");
					qty = scan.nextInt();
					System.out.println(qty + " Amazing Pizza selected");
					
					sp.addItem(p1, qty);
					
					//sp.listItems();
					
					break;
				case "b":
					System.out.println("Amazing Burger selected");
					System.out.println("How many?: ");
					qty = scan.nextInt();
					sp.addItem(p2, qty);
					break;
				case "c":
					System.out.println("Amazing Salad selected");
					System.out.println("How many?: ");
					qty = scan.nextInt();
					sp.addItem(p3, qty);
					break;
				case "d":
					System.out.println("Boring Fries selected");
					System.out.println("How many?: ");
					qty = scan.nextInt();
					sp.addItem(p4, qty);
					break;
					
				case "E":
					sp.Details();

				}

			} while(!pick.equals("q"));
		}


	}


}








