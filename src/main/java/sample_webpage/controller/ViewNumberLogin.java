package sample_webpage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample_webpage.dao.LoginPageDao;
import sample_webpage.dto.Users;


@WebServlet("/logincontact")
public class ViewNumberLogin extends HttpServlet {
	public static boolean loggedIn= false;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		LoginPageDao studentDao=new LoginPageDao();
		
		Users student=studentDao.loginStudent(email);
		
		if(student.getEmail().equals(email) && student.getPassword().equals(password)) {
			List<Users> list=studentDao.getAllStudent();
			
			req.setAttribute("list", list);
			
			Cookie cookie=new Cookie("username", student.getFirstnName());
			resp.addCookie(cookie);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("contactDetails.jsp");
			dispatcher.forward(req, resp);
//			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
//			
//			dispatcher.forward(req, resp);
			loggedIn= true;
		}
		else {
			req.setAttribute("message", "please login with proper credentials");
			RequestDispatcher dispatcher=req.getRequestDispatcher("logincontact.jsp");
			
			dispatcher.forward(req,resp);
		}
	}


}
