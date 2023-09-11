package com.finzly.sateesh.fxTrading.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.sateesh.fxTrading.model.FxTrade;
import com.finzly.sateesh.fxTrading.repo.FxTradeRepository;

@Service
public class FxTradingServices {
     
	@Autowired
	FxTradeRepository fxTradeRepository;

	// Get All Trades from here
	public List<FxTrade> getAllTrades() {
		List<FxTrade> list = fxTradeRepository.findAll();
		return list;
	}

	// Create Trade Here
	public FxTrade createFxtTrade(FxTrade fxTrade) {
        
		if ( getTradeById( fxTrade.gettradeId() ) != null ) {
			return null;
		} else {	
			fxTrade.setBooked(false); // Don't want book trade while creation of trade
			double amount = fxTrade.getAmount();
			float rate = fxTrade.getRate();
			fxTrade.setTotalAmt(rate * amount);

			return fxTradeRepository.save(fxTrade);
		}
	}

	// Get a Trade using tradeId
	public FxTrade getTradeById(int tradeId) {
		Optional<FxTrade> trade = fxTradeRepository.findById(tradeId);
		return trade.orElse(null);
	}

	// Book a Trade using tradeId
	public FxTrade bookTradeById(int tradeId) {
		FxTrade trade = getTradeById(tradeId);
		if (trade != null) {
			trade.setBooked(true);
			fxTradeRepository.save(trade);
			return trade;
		} else{
			return null;
		}
	}

	// Get a Trade using tradeId if it's not booked yet.
	public FxTrade cancelTradeById(int tradeId) {

		FxTrade trade = getTradeById(tradeId);
		if (trade == null) {
			return null;
		} else if (trade.isBooked()) {
			return trade;
		} else {

			fxTradeRepository.delete(trade);
			return trade;
		}
	}

	
	// Delete all Unbooked Trade 
	
	public List<FxTrade> deleteAllUnBookedTrade() {
		
		List<FxTrade> list = fxTradeRepository.findAll();
		List<FxTrade> tempList = new ArrayList<>();
		if(list==null) {
			return null; 
		}
		for (FxTrade fxTrade : list) {
			if(!fxTrade.isBooked()) {
				tempList.add(fxTrade);
			  	fxTradeRepository.deleteById(fxTrade.gettradeId());
			}
			
		}
		return tempList;
	}

	public FxTrade updateTradeById(int tradeId,FxTrade fxTrade) {
		
		FxTrade trade = getTradeById(tradeId);
		 if(fxTrade.gettradeId() != tradeId) return null;
		 
		 if( trade == null )
		         return null;
		 else {	 
			 return fxTradeRepository.save(fxTrade);
		 }
	}

}
