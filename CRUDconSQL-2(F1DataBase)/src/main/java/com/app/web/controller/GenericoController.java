package com.app.web.controller;
/*
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/api")
public class GenericoController {

	@GetMapping
	public String ejemplo() {
		OkHttpClient ok = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
				.url("https://v1.baseball.api-sports.io/status")
				.addHeader("x-rapidapi-key", "732966784dcf8f8666ab6b1829bb0d40")
				.addHeader("x-rapidapi-host", "v1.baseball.api-sports.io")
				.build();
		Call llamada = ok.newCall(request);
		Response response = null;
		String valor = null;
		try {
			response = llamada.execute();
			valor = response.body().string();
		}catch (Exception e) {
			
		}
		
		return valor;
		
	} Este codigo nomas quedo como ejemplo para un tema sobre implementacion de API's. No es 
	  necesario para el funcionamiento del codigo en cuestion
	
}
*/