package com.homechallenge.QikServe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.homechallenge.QikServe.Consuming.Consuming;
import com.homechallenge.QikServe.controller.ShoppingController;

class ShoppingCartTest {
	
	 //instantiate the list of products

	//List<ShoppingCartItem> cartItems = new ArrayList<>();
	

	@BeforeEach
	void setUp() throws IOException {
		List<Product> products = new ArrayList<Product>(Consuming.findAll()); //instantiate the list of products

		//List<ShoppingCartItem> cartItems = new ArrayList<>();
		Product p1 = Consuming.findById(products.get(0).getId()); //Amazing Pizza 
		Product p2 = Consuming.findById(products.get(1).getId()); //Amazing Burger
		Product p3 = Consuming.findById(products.get(2).getId()); //Amazing Salad
		Product p4 = Consuming.findById(products.get(3).getId()); //Boring Fries

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);

		ShoppingController sp = new ShoppingController();
	}
	
	@Test
	final void testAdd() throws IOException {
		List<Product> products = new ArrayList<Product>(Consuming.findAll());
		ShoppingController sp = new ShoppingController();
		Product p1 = Consuming.findById(products.get(0).getId());
		sp.addItem(p1, 4);
		
		//Assertions.assertEquals(p1.ge, p1, null);
	}

	@Test
	final void testTotal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testUserId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testContains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNumberOf() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

}
