package com.servlet.study.web.servlet.auth.api;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.study.web.service.UserService;

@WebServlet("/api/v1/auth/overlap/userId")
public class CheckUserIdApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    public CheckUserIdApi() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	userService = (UserService) config.getServletContext().getAttribute("userService");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(userService.checkUserId(userId));
	}
}








