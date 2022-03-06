package com.homechallenge.QikServe.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homechallenge.QikServe.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	// consumindo a lista de produtos, mostra todos os produtos.
	@GetMapping
	public List<Product> findAll() throws IOException {
		List<Product> products = null;
		String curl = "http://localhost:8081/products";

		URL url = new URL(curl);

		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {

			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();

			System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			BufferedReader br = null;
			if (http.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					System.out.println("str: " + strCurrentLine);

					products = gson.fromJson(strCurrentLine, new TypeToken<List<Product>>() {
					}.getType());

					//

					System.out.println("Produto objeto response:" + products);
					try {

					} catch (Exception e) {
						System.out.println("erro: " + e);
					}

					// TODO cadastrar na tabela produto

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Product product = new Product();
		// product.setId("fdaf-fda-112");
		// product.setName("Arroz");

		// products.add(product);

		// product = new Product();
		// product.setId("fssf-dfa-188");
		// product.setName("Arroz");

		// products.add(product);

		System.out.println("lista: " + products.toString());
		/*
		 * Double valorTotal = 0.0; for (Product product : products) { valorTotal =
		 * valorTotal + product.getPrice();
		 * 
		 * 
		 * } System.out.println(valorTotal);
		 */
		return products;

	}

	// recuperando produto por ID
	@GetMapping(value = "/{id}")
	public Product findById(@PathVariable String id) throws IOException {
		Product product = null;

		String curl = "http://localhost:8081/products/" + id;

		URL url = new URL(curl);

		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {

			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();

			System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			BufferedReader br = null;
			if (http.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					System.out.println("str: " + strCurrentLine);

					product = gson.fromJson(strCurrentLine, Product.class);
					// promotions = gson.fromJson(strCurrentLine, new
					// TypeToken<List<Promotion>>(){}.getType());

					System.out.println("Produto objeto response:" + product);
					try {

					} catch (Exception e) {
						System.out.println("erro: " + e);
					}

					
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return product;

	}


}
