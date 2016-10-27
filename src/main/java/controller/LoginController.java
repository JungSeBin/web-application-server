package controller;

import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpSession;
import model.User;

public class LoginController implements Controller {

	@Override
	public void service(HttpRequest request, HttpResponse response) {
		// TODO Auto-generated method stub
		   User user = DataBase.findUserById(request.getParameter("userId"));
           if (user != null) {
               if (user.login(request.getParameter("password"))) {
                  HttpSession session = request.getSession();
                  session.setAttribute("user", user);
                   response.sendRedirect("/index.html");
               } else {
                   response.sendRedirect("/user/login_failed.html");
               }
           } else {
               response.sendRedirect("/user/login_failed.html");
           }
	}

}
