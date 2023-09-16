package com.finzly.sateesh.fxTrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.sateesh.fxTrading.dao.CurrencyDao;
import com.finzly.sateesh.fxTrading.dao.FxTradingDao;
import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.exception.DataObjectNotFoundException;
import com.finzly.sateesh.fxTrading.exception.MyException;
import com.finzly.sateesh.fxTrading.model.Currency;
import com.finzly.sateesh.fxTrading.model.FxTrade;


@Service
public class FxTradingServiceImp implements FxTradingService {

	@Autowired
	FxTradingDao fxTradingDao;
	@Autowired
	CurrencyDao currencyDao;

	// Get All Trades from here
	public List<FxTrade> getAllTrades() {
		return fxTradingDao.getAllTrades();
	}

	
	
	public FxTrade transferAmount(FxTrade fxTrade) throws CurrencyNotFoundExeption {

		Currency currency = currencyDao.currencyValidator(fxTrade.getCurrencyPair().trim().toUpperCase());
		if (currency == null) {
			throw MyException.getCurrenypairNotFoundException();
		} else {
			fxTrade.setTotalAmount(fxTrade.getAmount() * currency.getRate());
			return fxTradingDao.transferAmount(fxTrade);
		}
	}

	
	public FxTrade recieveAmount(FxTrade fxTrade) throws CurrencyNotFoundExeption {

		Currency currency = currencyDao.currencyValidator(fxTrade.getCurrencyPair().trim().toUpperCase());
		if (currency == null) {
			throw MyException.getCurrenypairNotFoundException();
		} else {
			fxTrade.setTotalAmount(fxTrade.getAmount() / currency.getRate());
			return fxTradingDao.recieveAmount(fxTrade);
		}

	}

	public FxTrade getTradeById(int tradeId) throws DataObjectNotFoundException {
		
		FxTrade fxTradeDB = fxTradingDao.getTradeById(tradeId);
		if (fxTradeDB == null) {
			throw MyException.getDataObjectNotFoundException();
		}
		return fxTradeDB;
		
	}
}
