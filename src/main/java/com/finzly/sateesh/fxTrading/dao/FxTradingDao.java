package com.finzly.sateesh.fxTrading.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.sateesh.fxTrading.exception.CurrencyNotFoundExeption;
import com.finzly.sateesh.fxTrading.exception.MyException;
import com.finzly.sateesh.fxTrading.model.Currency;
import com.finzly.sateesh.fxTrading.model.FxTrade;

@Repository
public class FxTradingDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<FxTrade> getAllTrades() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FxTrade.class);
		
		return criteria.list();
	}

	public FxTrade transferAmount(FxTrade fxTrade) {
		
		Session session = sessionFactory.openSession();
		fxTrade.setRemark("Transfered Amount");
		
		session.save(fxTrade);
		session.beginTransaction().commit();
		
		return fxTrade;
	}

	public FxTrade recieveAmount(FxTrade fxTrade) {
		
		Session session = sessionFactory.openSession();
		fxTrade.setRemark("Recieved Amount");
		
		session.save(fxTrade);
		session.beginTransaction().commit();
		
		return fxTrade;
	}

	public FxTrade getTradeById(int tradeId) {
		Session session = sessionFactory.openSession();
		FxTrade fxTradeDB =  session.get(FxTrade.class, tradeId);
		if(fxTradeDB== null) {
			return null;
		}
		return fxTradeDB;
	}

	

}
