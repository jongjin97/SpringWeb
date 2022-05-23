package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.domain.ProductDomain;
import shop.dto.Product;
import shop.service.AllProductSelectService;
import shop.service.ProductListService;

@Controller
public class MainController {
	@Autowired
	private AllProductSelectService allProductSelectService;
	
	@RequestMapping("/main")
	public String main(Model model) {
		List<ProductDomain> list = allProductSelectService.productList();
		
		model.addAttribute("list", list);
		return "Main";
	}
	
}
