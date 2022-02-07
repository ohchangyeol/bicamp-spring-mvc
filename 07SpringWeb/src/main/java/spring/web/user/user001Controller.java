package spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class user001Controller {

	public user001Controller() {
		System.out.println("user001Controller defualt");
		
	}
	
	@RequestMapping("/logon.do")
	public ModelAndView logon() {
		// TODO Auto-generated method stub
		System.out.println(":: ==> logon() Start ...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user001/logon.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		// TODO Auto-generated method stub
		System.out.println(":: ==> home() Start ...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user001/home.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/logonAction.do")
	public ModelAndView logonAction() {
		// TODO Auto-generated method stub
		System.out.println(":: ==> logonAction() Start ...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user001/logonAction.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout() {
		// TODO Auto-generated method stub
		System.out.println(":: ==> logout() Start ...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user001/logout.jsp");
		
		return modelAndView;
	}
}
