package com.mta.javacourse;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({ "unused", "serial" })
public class StockDetailsServlet extends HttpServlet  {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	resp.setContentType("text/html");
	
	Calendar cal = Calendar.getInstance();
	cal.set(2015,10, 15);
	java.util.Date date = cal.getTime();
	
	Stock s1 = new Stock("PIH", (float)13.1 ,(float)12.4, date);
	Stock s2 = new Stock("AAL", (float)5.78 ,(float)5.5, date);
	Stock s3 = new Stock("CAAS", (float)32.2 ,(float)31.5, date);
	
	resp.getWriter().println(s1.getHtmlDescription() + "<br>");
	resp.getWriter().println(s2.getHtmlDescription() + "<br>");
	resp.getWriter().println(s3.getHtmlDescription() + "<br>");

	}

}
