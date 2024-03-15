package sample_webpage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample_webpage.dao.LoginPageDao;
import sample_webpage.dto.Users;
import sample_webpage.dto.Users;


@WebServlet("/signup")
public class LoginDetailsController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String cnfpassword=req.getParameter("cnfpassword");
		
		Users login=new Users();
		login.setFirstnName(firstName);
		login.setLastName(lastName);
		login.setPhno(Long.parseLong(mobile));
		login.setEmail(email);
		login.setPassword(password);
		login.setcnfpassword(cnfpassword);
				
		LoginPageDao loginPageDao=new LoginPageDao();
		Users dbstudent=loginPageDao.saveStudent(login);
		
		if(dbstudent!=null) {
			req.setAttribute("message", "signup succesfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
