package spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.User;
import spring.service.user.impl.UserDAO;

//@Controller
public class User002Controller {
	
	public User002Controller() {
		System.out.println(":: User002Controller default Constructor call");
	}
	
	@RequestMapping("/logon.do")
	public ModelAndView logon(HttpSession session) {
		
		System.out.println("[logon() start....................]");
		
		if(session.isNew() ||session.getAttribute("sessionUser")==null) {
			session.setAttribute("sessionUser", new User());
		}
		User sessionUser = (User)session.getAttribute("sessionUser");
		
		String viewName = "/user002/logon.jsp";
		
		if(sessionUser.isActive()) {
			viewName = "/user002/home.jsp";
		}
		System.out.println("[ action : " +viewName+ "]");
		
		String message = null;
		if(viewName.equals("/user002/home.jsp")) {
			message = "[logon () ] WELCOME";
		}else {
			message = "[logon () ] ���̵�, �н����� 3�� �̻� �Է��϶�!";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println("[logon() end....................]");
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home(HttpSession session) {
		System.out.println("[home() start....................]");
		
		if(session.isNew() ||session.getAttribute("sessionUser")==null) {
			session.setAttribute("sessionUser", new User());
		}
		User sessionUser = (User)session.getAttribute("sessionUser");
		
		String viewName = "/user002/logon.jsp";
		
		if(sessionUser.isActive()) {
			viewName = "/user002/home.jsp";
		}
		System.out.println("[ action : " +viewName+ "]");
		
		String message = null;
		if(viewName.equals("/user002/home.jsp")) {
			message = "[logon () ] WELCOME";
		}else {
			message = "[logon () ] ���̵�, �н����� 3�� �̻� �Է��϶�!";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println("[home() end....................]");
		return modelAndView;
	}
	
	@RequestMapping("/logonAction.do")
	public ModelAndView logonAction(@ModelAttribute("user") User user, HttpSession session) {
		System.out.println("[logonAction() start....................]");
		
		if(session.isNew() ||session.getAttribute("sessionUser")==null) {
			session.setAttribute("sessionUser", new User());
		}
		User sessionUser = (User)session.getAttribute("sessionUser");
		
		String viewName = "/user002/logon.jsp";
		
		if(sessionUser.isActive()) {
			viewName = "/user002/home.jsp";
		}
		else {
			UserDAO userDAO = new UserDAO();
			userDAO.getUser(user);
			
			if(user.isActive()) {
				viewName = "/user002/home.jsp";
				session.setAttribute("sessionUser", user);
			}
		}
		System.out.println("[ action : " +viewName+ "]");
		
		String message = null;
		if(viewName.equals("/user002/home.jsp")) {
			message = "[logon () ] WELCOME";
		}else {
			message = "[logon () ] ���̵�, �н����� 3�� �̻� �Է��϶�!";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println("[LogonAction() end....................]");

		return modelAndView;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		System.out.println("[logout() start....................]");
		
		session.removeAttribute("sessionUser");
		
		String message = "[Logout()] ���̵�, �н����� 3�� �̻� �Է��ϼ���.";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user001/logout.jsp");
		modelAndView.addObject("message",message);
		
		System.out.println("[Logout() end....................]");
		
		return modelAndView;
	}
	
}
