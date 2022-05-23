package shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.domain.UserDomain;
import shop.dto.AuthInfo;
import shop.dto.LoginUser;
import shop.dto.Product;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.exception.DuplicateMemberException;
import shop.exception.WrongIdPasswordException;
import shop.service.LoginService;
import shop.service.RegistService;


@Controller
public class UserController {
	@Autowired
	private RegistService registService;
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("loginUser")LoginUser loginUser) {
		return "Login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("loginUser")LoginUser loginUser, Errors errors, HttpSession session, HttpServletRequest request) {
		if(errors.hasErrors())
			return "Login";
		
		try {
			UserDomain user = loginService.login(loginUser.getEmail(), loginUser.getPassword());
			AuthInfo authInfo = new AuthInfo(user.getName(), user.getEmail(), user.getPassword());
			session.setAttribute("authInfo", authInfo);
			return "redirect:/main";
		} catch (WrongIdPasswordException e) {
			// TODO: handle exception
			return "Login";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Main";
	}
	@RequestMapping(value = "/base")
	public String base() {
		return "base";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerview(@ModelAttribute("registerRequest")RegisterRequest registerRequest) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registeruser(@ModelAttribute("registerRequest") RegisterRequest registerRequest, Errors errors) {
		if(errors.hasErrors()) {
			return "register";
		} else if(!registerRequest.getPassword().equals(registerRequest.getConfirm())) {
			return "register";
		}
		try {
			registService.registService(registerRequest);
			return "redirect:/login";
		} catch (DuplicateMemberException e) {
			// TODO: handle exception
			return "register";
		}
	}
}
