package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shop.dto.User;
import shop.entity.ProductDomain;
import shop.entity.UserDomain;
import shop.dto.Product;
import shop.service.*;

@Controller
public class ManageController {

	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;


	@RequestMapping("manage/manageProduct")
	public String manageProductView(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		
		return "manageProduct"; 
	}
	
	@RequestMapping(value="manage/modifyProduct", method = RequestMethod.GET)
	public String modifyProductView(Model model, @RequestParam("name")String name) {
		Product product = productService.findByProductName(name);
		model.addAttribute("product", product);
		
		return "modifyProduct"; 
	}
	
	@RequestMapping(value="modifyProduct", method = RequestMethod.POST)
	public String modifyProduct(@ModelAttribute("product")Product product, @RequestParam("name")String name) {


		return "redirect:/manage/manageProduct";
	}
	
	@RequestMapping(value ="manage/deleteProduct")
	public String deleteProduct(@RequestParam("name")String name) {
		productService.remove(name);
		return "redirect:/manage/manageProduct";
	}
	
	@RequestMapping(value="manage/manageUser", method=RequestMethod.GET)
	public String manageUserView(Model model) {
		List<User> list = userService.findAll();
		model.addAttribute("list", list);
		return "manageUser";
	}
}
