package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.dto.Product;
import shop.entity.ProductDomain;
import shop.service.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/main")
	public String main(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "Main";
	}
	
}
