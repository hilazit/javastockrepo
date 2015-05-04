package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Hila_NasdaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		int num1=3, num2=4, num3=7;
		int sum=(num1+num2)*num3;
		String resultStr = new String("<h1> Result of (" +
				 + num1 + "+" + num2 + ")*" + num3 + " = " + sum + "</h1>");
		resp.getWriter().println(resultStr); //
	}
}
