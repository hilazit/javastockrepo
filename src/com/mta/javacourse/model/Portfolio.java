package com.mta.javacourse.model;

import com.mta.javacourse.Stock;

public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	public Portfolio() {
		this.title = "protfolio";
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		
	}
		
	public void addStock (Stock stocks){
		if(stocks != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			this.stocks[portfolioSize] = stocks;
			portfolioSize++;
		}else {
			System.out.println("Sorry, the protfolio is full, or the stock is null!");
		}
		
	}
	
	public String getHtmlString(){
		String ret = new String( "<h1>" + getTitle() + "</h1>" );

		for(int i = 0; i < portfolioSize ;i++) 
		{	
			ret += this.stocks[i].getHtmlDescription() + "<br>";
		}
			return ret;
			
			}


	public Stock[] getStock()
	{
		return stocks;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	


	

	
	
}
