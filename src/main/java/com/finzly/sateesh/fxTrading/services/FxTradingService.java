package com.finzly.sateesh.fxTrading.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.exception.DataObjectNotFoundException;
import com.finzly.sateesh.fxTrading.model.FxTrade;

public interface FxTradingService {
	public List<FxTrade> getAllTrades();

	public FxTrade transferAmount(FxTrade fxTrade) throws CurrencyNotFoundExeption;

	public FxTrade recieveAmount(FxTrade fxTrade) throws CurrencyNotFoundExeption;

//	public FxTrade createFxtTrade(FxTrade fxTrade);
	public FxTrade getTradeById(int tradeId) throws DataObjectNotFoundException;

}
