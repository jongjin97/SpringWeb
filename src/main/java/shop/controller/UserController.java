package shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.exception.DuplicateMemberException;
import shop.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("LoginUser", new User());
		return "Login";
	}
	/*
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
	*/

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registerview(@ModelAttribute("registerRequest")RegisterRequest registerRequest) {
		return "register";
	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registeruser(@Validated @ModelAttribute("registerRequest") RegisterRequest registerRequest, Errors errors) {
		if(errors.hasErrors()) {
			return "register";
		} else if(!registerRequest.getPassword().equals(registerRequest.getConfirm())) {
			return "register";
		}
		try {
			userService.save(registerRequest);
			return "redirect:/user/login";
		} catch (DuplicateMemberException e) {
			// TODO: handle exception
			return "register";
		}
	}
}
