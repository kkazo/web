package com.adc.security.handler;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2016-05-16.
 */
public class AdcAccessDeniedHandler implements AccessDeniedHandler {
	private static final Logger logger = LoggerFactory.getLogger(AdcAccessDeniedHandler.class);

	private String errorPage;

	public AdcAccessDeniedHandler() {
	}

	public AdcAccessDeniedHandler(String errorPage) {
		this.errorPage = errorPage;
	}

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {

		String accept = request.getHeader("accept");

		String error = "true";
		String message = exception.getMessage();

		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");

		String data = " { \"response\" : {" +
				" \"error\" : " +  error + ", " +
				" \"message\" : \"" +  message + "\" " +
				"} } "
		;

		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();

	}
}
