package com.finzly.sateesh.fxTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.model.Currency;
import com.finzly.sateesh.fxTrading.services.CurrencyService;

@RestController
@RequestMapping("api/v1/ccy")
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@GetMapping("/get-all-ccy")
	public ResponseEntity<Object> getAllCurrencyPairs() {

		List<Currency> allCurrencyPairs = currencyService.getAllCurrencyPairs();

		if (allCurrencyPairs.isEmpty()) {
			return ResponseEntity.badRequest().body("No currency pair found..");
		} else {
			return ResponseEntity.ok(allCurrencyPairs);
		}

	}

	@PostMapping("/update-rate")
	public ResponseEntity<Object> updateRate(@RequestBody Currency currency) {
		Currency updatedCurrency = null;
		try {
			updatedCurrency = currencyService.updateRate(currency);
			return ResponseEntity.ok(updatedCurrency);

		} catch (CurrencyNotFoundExeption e) {
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().body("Invalid Currency Pair. Please Enter Valid  currency pair for Update.");

	}

}
