package com.mta.javacourse.model;


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
	/** copy c'tor of Portfolio class
	 * @author HILA
	 * @param portfolioToCopy
	 */
	
	public Portfolio (Portfolio portfolioToCopy){
		
		this.setTitle(portfolioToCopy.getTitle());
		this.setPortfolioSize(portfolioToCopy.getPortfolioSize());
		
		for (int i= 0; i<this.portfolioSize; i++ )	
		{
			Stock temp = new Stock (portfolioToCopy.getStock()[i]);
			this.addStock (temp);
			
		}
	}	
		
	
	public void addStock (Stock stocks){
		if(stocks != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			this.stocks[portfolioSize] = stocks;
			portfolioSize++;
		}else {
			System.out.println("Sorry, the protfolio is full, or the stock is null!");
		}
		
	}
	
	/**
	 * function for removing a specific stock from portfolio (according to it's symbol)
	 * @author HILA
	 */
	
	public void removeStock(String symbol) {
		if (portfolioSize == 1 || symbol.equals(stocks[portfolioSize-1].getSymbol())){
			/*in case the stocks array has 1 or symbol is last node in array*/
			stocks[portfolioSize-1] = null;
			portfolioSize--;
			return;
		}
		for (int i = 0; i < portfolioSize; i++){
			if (symbol == null){ //check validate input
				return;
			}
			else if (symbol.equals(stocks[i].getSymbol()))
			{
				stocks[i] = stocks[portfolioSize - 1];
				stocks[portfolioSize - 1] = null;
				portfolioSize--;
			}
		}
		return;
	}

	public String getHtmlString(){
		String ret = new String( "<h1>" + getTitle() + "</h1>" );

		for(int i = 0; i < portfolioSize ;i++) 
		{	
			ret += this.stocks[i].getHtmlDescription() + "<br>";
		}
			return ret;
			
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
