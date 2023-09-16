package com.finzly.sateesh.fxTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.sateesh.fxTrading.model.Currency;

@Repository
public class CurrencyDao {

	@Autowired
	SessionFactory sessionFactory;

	// Get all Currency Pairs and Rate

	public List<Currency> getAllCurrencyPair() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Currency.class);
		
		return criteria.list();
	}

	// update Currency Rate
	public Currency updateRate(Currency currency) {

		Session session = sessionFactory.openSession();
		Currency currencyDB = session.get(Currency.class, currency.getCurrencyPair());
		currencyDB.setRate(currency.getRate());
       
		session.save(currencyDB);
		session.beginTransaction().commit();

		session.close();
		return currencyDB;

	}

	// this method valid currency pair
	public Currency currencyValidator(String currencyPair) {

		Session session = sessionFactory.openSession();
		Currency currency = session.get(Currency.class, currencyPair);
		session.close();
		if (currency == null) {
			return null;
		}
		return currency;
	}

}
