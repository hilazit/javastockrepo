package com.mta.javacourse.service;

import com.mta.javacourse.Stock;
import com.mta.javacourse.model.Portfolio;

import java.util.Calendar;
import java.util.Date;

public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Portfolio portfolio = new Portfolio();
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15);
		
		Date date1 = cal.getTime();
		Stock stock1 = new Stock("PIH", (float)13.1 ,(float)12.4, date1);
		portfolio.addStock(stock1);
		
		Date date2 = cal.getTime();
		Stock stock2 = new Stock("AAL", (float)5.78 ,(float)5.5, date2);
		portfolio.addStock(stock2);
		
		Date date3 = cal.getTime();
		Stock stock3 = new Stock("CAAS", (float)32.2 ,(float)31.5, date3);
		portfolio.addStock(stock3);
		
		return portfolio;

	}
}