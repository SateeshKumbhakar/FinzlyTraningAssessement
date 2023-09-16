package com.finzly.sateesh.fxTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.exception.DataObjectNotFoundException;
import com.finzly.sateesh.fxTrading.model.FxTrade;
import com.finzly.sateesh.fxTrading.services.FxTradingService;

@RestController()
@RequestMapping("api/v1/trade")
public class FxTradingController {

	@Autowired
	FxTradingService fxTradingService;

	// Get All Trade
	@GetMapping("/get-all-trades")
	public ResponseEntity<Object> getAllTrades() {

		List<FxTrade> tradeList = fxTradingService.getAllTrades();

		if (tradeList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(" No Trade is found.Please Book trade first.Thank you..!");
		} else {
			return ResponseEntity.ok(tradeList);
		}

	}

	// Trade By Id
	@GetMapping("/trade-by-id/{tradeId}")
	public ResponseEntity<Object> getTradeById(@PathVariable int tradeId) {

		FxTrade trade = null;
		try {
			trade = fxTradingService.getTradeById(tradeId);
			return ResponseEntity.ok(trade);
		} catch (DataObjectNotFoundException e) {

			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Trade Found with this " + tradeId);

	}
	
	
    //If user want to transfer amount
	
	@PostMapping("/transfer-amount")
	public ResponseEntity<Object> transferAmount(@RequestBody FxTrade fxTrade) {
		FxTrade fxTradeFromDB = null;
		try {
			fxTradeFromDB = fxTradingService.transferAmount(fxTrade);
			return ResponseEntity.ok(fxTradeFromDB);
		} catch (CurrencyNotFoundExeption e) {

			e.printStackTrace();

		}
		return ResponseEntity.badRequest()
				.body("You have selected " + fxTrade.getCurrencyPair() + " Please Select corrcect currnecy pair...! ");
	}


    //If user want to Receive amount
	
	@PostMapping("/recieve-amount")
	public ResponseEntity<Object> recieveAmount(@RequestBody FxTrade fxTrade) {

		FxTrade fxTradeFromDB = null;
		try {
			fxTradeFromDB = fxTradingService.recieveAmount(fxTrade);
			return ResponseEntity.ok(fxTradeFromDB);
		} catch (CurrencyNotFoundExeption e) {

			e.printStackTrace();

		}
		return ResponseEntity.badRequest()
				.body("You have selected " + fxTrade.getCurrencyPair() + " Please Select corrcect currnecy pair...! ");
	}

}
