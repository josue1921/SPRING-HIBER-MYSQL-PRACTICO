package com.jcg.examples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jcg.examples.delegate.LoginDelegate;
import com.jcg.examples.viewBean.LoginBean;

@Controller
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean) {
//		ModelAndView model = new ModelAndView("login");
//		// LoginBean loginBean = new LoginBean();
//		model.addObject("loginBean", loginBean);
//		return model;
//	}

	@RequestMapping("login")
	public String displayLogin(Model model) {
		LoginBean login = new LoginBean();
		model.addAttribute("login", login);
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("loginBean") LoginBean loginBean) {
//		ModelAndView model = null;
//		try {
//			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
//			if (isValidUser) {
//				request.setAttribute("loggedInUser", loginBean.getUsername());
//				model = new ModelAndView("welcome");
//			} else {
//				model = new ModelAndView("login");
//				request.setAttribute("message", "Invalid credentials!!");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return model;
//	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("login") LoginBean loginBean, BindingResult bindingresult,
			HttpSession session, HttpServletRequest request) {
		ModelAndView view = new ModelAndView("login");
		if (!bindingresult.hasErrors()) {
			try {
				boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
				if (!isValidUser) {
					bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
					session.setMaxInactiveInterval(60);
					request.setAttribute("loggedInUser", loginBean.getUsername());
					return new ModelAndView("error");
				} else {
					session.setAttribute("login", loginBean);
					view.setViewName("welcome");
				}
			} 
			catch(Exception e ) {
				e.printStackTrace();
			} 
		}
		return view;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		LoginBean login = new LoginBean();
		model.addAttribute("login", login);
		return "login";
	}

}
