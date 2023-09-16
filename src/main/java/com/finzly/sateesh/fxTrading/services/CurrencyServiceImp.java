package com.finzly.sateesh.fxTrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.sateesh.fxTrading.dao.CurrencyDao;
import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.exception.MyException;
import com.finzly.sateesh.fxTrading.model.Currency;

@Service
public class CurrencyServiceImp implements CurrencyService {

	@Autowired
	CurrencyDao currencyDao;

	public List<Currency> getAllCurrencyPairs() {
		return currencyDao.getAllCurrencyPair();
	}
    
	public Currency updateRate(Currency currency) throws CurrencyNotFoundExeption {
        Currency vaildCurrency = currencyDao.currencyValidator(currency.getCurrencyPair().trim().toUpperCase());
        if(vaildCurrency == null) {
        	throw MyException.getCurrenypairNotFoundException();
        }
        return currencyDao.updateRate(currency);
	}

}
