package com.homechallenge.QikServe.Consuming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homechallenge.QikServe.model.Product;

public class Consuming {
	public static List<Product> findAll() throws IOException {
		List<Product> products = null;
		String curl = "http://localhost:8081/products";

		URL url = new URL(curl);

		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {

			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();

			//System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			BufferedReader br = null;
			if (http.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					//System.out.println("str: " + strCurrentLine);

					products = gson.fromJson(strCurrentLine, new TypeToken<List<Product>>() {
					}.getType());

					//

					//System.out.println("Produto objeto response:" + products);
					try {

					} catch (Exception e) {
						System.out.println("erro: " + e);
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}



		//System.out.println("lista: " + products.toString());

		return products;

	}
	
	public static Product findById(@PathVariable String id) throws IOException {
		Product product = null;

		String curl = "http://localhost:8081/products/" + id;

		URL url = new URL(curl);

		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {

			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();

			//System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			BufferedReader br = null;
			if (http.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					//System.out.println("str: " + strCurrentLine);

					product = gson.fromJson(strCurrentLine, Product.class);
					// promotions = gson.fromJson(strCurrentLine, new
					// TypeToken<List<Promotion>>(){}.getType());

					//System.out.println("Produto objeto response:" + product);
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
