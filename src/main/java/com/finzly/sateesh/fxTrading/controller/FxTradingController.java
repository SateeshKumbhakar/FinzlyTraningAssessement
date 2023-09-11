package com.finzly.sateesh.fxTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.finzly.sateesh.fxTrading.model.FxTrade;
import com.finzly.sateesh.fxTrading.services.FxTradingServices;
import com.finzly.sateesh.fxTrading.services.UtiliyClass;

@RestController()
@RequestMapping("api/v1")
public class FxTradingController {

	@Autowired
	FxTradingServices fxTradingServices;

	@GetMapping("/get-all-trades")
	public ResponseEntity<Object> getAllTrades() {

		List<FxTrade> list = fxTradingServices.getAllTrades();

		if ( list.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(" No Trade is found.Please Book trade first.Thank you..!");
		} else {
			return ResponseEntity.ok(list);
		}

	}

	@PostMapping("/create-trade")
	public ResponseEntity<Object> createFxTrade(@RequestBody FxTrade fxTrade) {
		boolean isValidTrade = UtiliyClass.isValidTrade(fxTrade);

		if ( !isValidTrade )
			return ResponseEntity.badRequest()
				.body("Please Enter Valid details(CustomerName/TradeId/currency Pair)");

		FxTrade createdFxTrade = fxTradingServices.createFxtTrade(fxTrade);
		if ( createdFxTrade == null )  {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("Can't create Trade with given tradeId. Trade is found...");
		}

		System.out.println("created trade  " + fxTrade);
		return ResponseEntity.ok(createdFxTrade);
	}

	@PutMapping("/update-trade/{tradeId}")
	public ResponseEntity<Object> updateTradeById(@PathVariable int tradeId,@RequestBody FxTrade fxTrade ) {

		FxTrade trade = fxTradingServices.updateTradeById(tradeId,fxTrade);
		if ( trade == null )  {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No Trade Found with this " + tradeId);
		} else
			return ResponseEntity.ok(trade);
	}
	

	@GetMapping("/get-trade/{tradeId}")
	public ResponseEntity<Object> getTradeById(@PathVariable int tradeId) {

		FxTrade trade = fxTradingServices.getTradeById(tradeId);
		if ( trade == null ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No Trade Found with this " + tradeId);
		} else {
			return ResponseEntity.ok(trade);
		}

	}

	@GetMapping("/book-trade/{tradeId}")
	public ResponseEntity<Object> bookTradeById(@PathVariable int tradeId) {

		FxTrade trade = fxTradingServices.bookTradeById(tradeId);
		if ( trade == null ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No Trade Found with this " + tradeId);
		} else {
			return ResponseEntity.ok(trade);
		}

	}

	@GetMapping("/cancel-trade/{tradeId}")
	public ResponseEntity<Object> cancelTradeById(@PathVariable int tradeId) {
		FxTrade trade = fxTradingServices.cancelTradeById(tradeId);

		if ( trade == null ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No Trade Found with this " + tradeId);
		} else if (trade.isBooked()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("Trade is booked with tradeId " + tradeId + "You Cann't delete a trade after booking");
		} else {
			return ResponseEntity.ok(trade);
		}
	}

	@GetMapping("/delete-unbooked-trades")
	public ResponseEntity<Object> deleteAllUnBookedTrade() {

		List<FxTrade> deletedTrade = fxTradingServices.deleteAllUnBookedTrade();

		return ResponseEntity.ok(deletedTrade);

	}

}
