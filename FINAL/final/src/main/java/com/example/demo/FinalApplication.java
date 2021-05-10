package com.example.demo;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Company;
import com.example.demo.model.Product;
import org.apache.tomcat.jni.Time;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class FinalApplication {

	static HttpClient client = HttpClient.newHttpClient();

	public static void main(String[] args) throws IOException, InterruptedException  {
		SpringApplication.run(FinalApplication.class, args);

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			System.out.println("Updating product 1...");
			try {
				get(1, 5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Updating product 1 again...");
			try {
				get(1, 10);
			} catch (Exception e) {
				e.printStackTrace();
			}


			System.out.println("Updating product 1 again...");
		});

	}

	// For testing
	private static String get(int id, int quantity) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/buy?product_id=" + id + "&quantity=" + quantity))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // optional line
				.build();
		System.out.println("Get request: " + sendRequest(request).toString());
		return sendRequest(request);
	}

	// For testing
	private static String sendRequest(HttpRequest request) throws IOException, InterruptedException {
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}


}
