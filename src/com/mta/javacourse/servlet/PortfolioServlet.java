package com.mta.javacourse.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioManager;

public class PortfolioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
	
			PortfolioManager portfolioManager = new PortfolioManager(); 
			Portfolio portfolio1 = portfolioManager.getPortfolio();
			
			Portfolio portfolio2 = new Portfolio(portfolio1);
			portfolio2.setTitle("Portfolio #2");
			
			resp.getWriter().println(portfolio1.getHtmlString()); 
			resp.getWriter().println(portfolio2.getHtmlString());
			
			portfolio1.removeStock(portfolio1.getStocks()[0].getSymbol());

			resp.getWriter().println(portfolio1.getHtmlString());
			resp.getWriter().println(portfolio2.getHtmlString());
			
			portfolio2.getStocks()[portfolio2.getPortfolioSize()-1].setBid(55.55f);
			
			resp.getWriter().println(portfolio1.getHtmlString());
			resp.getWriter().println(portfolio2.getHtmlString());

	}
}


