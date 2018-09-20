package cn.edu.hbue.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void showSuccess(HttpServletResponse response, String message) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>" + message + "</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showError(HttpServletResponse response, String message) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>" + message + "</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
