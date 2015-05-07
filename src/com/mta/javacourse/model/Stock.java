package com.mta.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private final static int BUY = 0;		
	private final static int SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private int recommendation;
	private int stockQuantity;
	
	
	public Stock(String symbol, float ask, float bid, Date date) {
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
		this.recommendation = 0;
		this.stockQuantity= 0;
	}
	/**
	 * copy c'tor of stock class
	 * @param stockToCopy
	 * @author HILA
	 */
	
	public Stock (Stock stockToCopy){
		this(stockToCopy.getSymbol(),stockToCopy.getBid(),stockToCopy.getAsk(),new Date(stockToCopy.getDate().getTime()));
		this.recommendation = stockToCopy.getRecommendation();
		this.stockQuantity = stockToCopy.getStockQuantity();
		
	}
	
	public String getHtmlDescription(){
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = df.format(getDate());
		
		String result = new String("<b>Stock symbol is: </b>" +getSymbol()+", <b>ask: </b>"+getAsk() +", <b>Bid: </b>"+getBid()+", <b>Date: </b>"+dateStr);
		return result;
	}
	/**
	 * getters and setters
	 * @author HILA
	 */
	
	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	

}