package com.finzly.sateesh.fxTrading.services;


import java.util.List;

import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.model.Currency;

public interface CurrencyService {

	List<Currency> getAllCurrencyPairs();

	Currency updateRate(Currency currency) throws CurrencyNotFoundExeption;
	

}
