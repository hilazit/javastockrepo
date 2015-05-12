package com.mta.javacourse.model;

import java.text.DecimalFormat;

public class Portfolio {

	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock[] stocks;
	private int portfolioSize;
	private float balance;
	
	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD 
	}
	
	public Portfolio() {
		this.title = "Exercise 7 protfolio";
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		
	}
	/** Copy c'tor of Portfolio class
	 * @author HILA
	 * @param portfolioToCopy
	 */
	
	public Portfolio (Portfolio portfolioToCopy){		
		this();
		for (int i= 0; i< portfolioToCopy.getPortfolioSize(); i++)
		{
			Stock temp = new Stock(portfolioToCopy.getStock()[i]);
			this.addStock(temp);
			
		}
		
		this.setTitle(portfolioToCopy.getTitle());
	}	
		
	public void addStock (Stock stocks){
		if(stocks != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			this.stocks[this.portfolioSize] = stocks;
			portfolioSize++;
		}else {
			System.out.println("Sorry, the protfolio is full, or the stock is null!");
		}
		
	}
	
	/**
	 * Function uses the portfolio's stock details
	 * @author HILA
	 */
	
	public String getHtmlString(){
		DecimalFormat decimalFormat=new DecimalFormat("#.#"); // SHOULD WE USE IT OR NOT?
		String htmlResString = new String();
		htmlResString = htmlResString+"<h1>"+this.getTitle()+"</h1> <br>";
		
		for(int i=0; i<portfolioSize; i++)
		{
			Stock tempStock = stocks[i];
			if (tempStock != null){
				htmlResString = htmlResString + tempStock.getHtmlDescription()+"<br>";
			}
		}
		htmlResString += "Total Portfolio Value :" + this.getTotalValue() + " $, "+
		"Total Stocks Value :"+this.getStocksValue()+" $, "+"Balance :"+this.balance+"$.";
		return htmlResString;	
	}
		

	/**
	 * Function for removing a specific stock from portfolio (according to it's symbol)
	 * @param stockName
	 * @author HILA
	 */
	
	public boolean removeStock(String stockName){
		
		if (stockName == null){
			System.out.println("The stock received is invalid!");
			return false;
		}
	
		for(int i = 0; i< this.portfolioSize; i++){
			
			if((this.stocks[i].getSymbol().equals(stockName) == true)){
				if (portfolioSize > 1){
					this.sellStock(stocks[i].getSymbol(), -1);
					stocks[i] = stocks[this.portfolioSize-1];
					stocks[this.portfolioSize-1]=null;
					
				}else  if (this.portfolioSize == 1){
					this.sellStock(stocks[i].getSymbol(), -1);
					stocks[i]=null;
				}
				portfolioSize--;
				System.out.println("Stock "+stockName+" was deleted as per request");
				return true;
			}
		}
		System.out.println("Stock wasn't found in this portfolio");
		return false;
	}
	
	/**
	 * Return true if the stock recommendation was updated to SELL, else return false. 
	 */
	public boolean sellStock(String symbol, int quantity){
		
		if(symbol == null || quantity < -1){
			System.out.println("There is an error! Please check your stock symbol or stock quntity.");
			return false;
		}
		
		for(int i = 0; i< this.portfolioSize; i++){

			if(this.stocks[i].getSymbol().equals(symbol) == true){

				if(this.stocks[i].getStockQuantity() - quantity < 0){
					System.out.println("Not enough stocks to sell");
					return false;

				}else if(quantity == -1){
					this.updateBalance(this.stocks[i].getStockQuantity()*this.stocks[i].getBid());
					this.stocks[i].setStockQuantity(0);
					System.out.println("Entire stock ("+symbol+") holdings was sold succefully");
					return true;

				}else {
					this.updateBalance(quantity*this.stocks[i].getBid());
					this.stocks[i].setStockQuantity(stocks[i].getStockQuantity()-quantity);
					System.out.println("An amount of "+quantity+" of stock ("+symbol+") was sold succefully");
					return true;
				}
			}

		}
	System.out.println("Stock wasn't found in this Portfolio");
		return false; 
	}
	
	/**
	 * Return true if the stock recommendation was updated to BUY else return false. 
	 * @author HILA
	 */

	public boolean buyStock(Stock stock, int quantity){
		int i = 0;
		if(stock == null || quantity < -1){
			System.out.println("There is an error! Please check your stock symbol or stock quntity.");
			return false;
		}
		if(quantity*stock.getAsk() > this.balance){
			System.out.println("Not enough balance to complete purchase.");
			return false;
		}
		for(i = 0; i< this.portfolioSize; i++){
			// THIS BLOCK REFEST TO THE CASE THAT THE STOCK ALREADY EXIST IN OUR STOCK ARRAY.
			if(this.stocks[i].getSymbol().equals(stock.getSymbol()) == true){
				
				if(quantity == -1){
					int howManyToBuy = (int)this.balance/(int)this.stocks[i].getAsk();
					this.updateBalance(-howManyToBuy*this.stocks[i].getAsk());
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()+howManyToBuy);
					System.out.println("Entire stock ("+stock.getSymbol()+") holdings that could be bought "
							+ "was bought succefully.");
					return true;

				}else {
					this.updateBalance(-quantity*this.stocks[i].getAsk());
					this.stocks[i].setStockQuantity(stocks[i].getStockQuantity()+quantity);
					System.out.println("An amount of "+quantity+" of stock ("+stock.getSymbol()+") was bought succefully");
					return true;
				}
	
			}
		}
		
		return false;
	}	
	
		
	/**
	 * Calculates the portfolio's total value
	 */
	public float getTotalValue(){
		
		return this.getStocksValue()+this.balance;		
	}
	
	/**
	 * Calculates the portfolio's total stocks value
	 * @author HILA
	 */
	
	public float getStocksValue(){
		float totalValue =0;
		for(int i = 0; i<this.portfolioSize ;i++){
			totalValue += this.stocks[i].getStockQuantity()*this.stocks[i].getBid();
		}
		return totalValue;		
	}
	
	/**
	 * 
	 * @author HILA
	 */
	
	public void updateBalance (float amount){
		float tempBalance = this.balance + amount;
		if(tempBalance < 0){
			System.out.println("Please note you may not change balance to negative amount!");
		}else {
			this.balance = tempBalance;
			System.out.println("Balance has been updated to "+ this.balance);
		}
		
	}
	
	/**
	 * getters and setters
	 * @author HILA
	 */
	
	
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
