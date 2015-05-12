package com.mta.javacourse.service;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

import java.util.Calendar;
import java.util.Date;

public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		
		Portfolio portfolio = new Portfolio();
		portfolio.updateBalance(10000);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 11, 15);
		
		Date date1 = cal.getTime();
		Stock stock1 = new Stock("PIH",10F,8.5F,date1);
		portfolio.addStock(stock1);
		
		Date date2 = cal.getTime();
		Stock stock2 = new Stock("AAL", 30F, 25.5F,date1);
		portfolio.addStock(stock2);
		
		Date date3 = cal.getTime();
		Stock stock3 = new Stock("CAAS", 20F, 15.5F,date3);
		portfolio.addStock(stock3);
		
		portfolio.buyStock(stock1, 20);
		portfolio.buyStock(stock2, 30);
		portfolio.buyStock(stock3, 40);
		
		portfolio.sellStock("AAL", -1);
		portfolio.removeStock("CAAS");
		
		return portfolio;

	}
}