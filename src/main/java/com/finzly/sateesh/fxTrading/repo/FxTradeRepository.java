package com.finzly.sateesh.fxTrading.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.sateesh.fxTrading.model.FxTrade;



public interface FxTradeRepository extends JpaRepository<FxTrade,Integer> {

}
