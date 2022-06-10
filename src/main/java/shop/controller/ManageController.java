package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shop.domain.ProductDomain;
import shop.domain.UserDomain;
import shop.dto.Product;
import shop.dto.User;
import shop.service.*;

@Controller
public class ManageController {
	@Autowired
	private AllProductSelectService allProductSelectService;
	@Autowired
	private ProductSelectService productSelectService;
	@Autowired
	private ModifyProduct modifyProduct;
	@Autowired
	private DeleteProductService deleteProductService;
	@Autowired
	private SelectAllUser selectAllUser;
	@Autowired
	private ProductService productService;


	@RequestMapping("manage/manageProduct")
	public String manageProductView(Model model) {
		List<ProductDomain> list = allProductSelectService.productList();
		model.addAttribute("list", list);
		
		return "manageProduct"; 
	}
	
	@RequestMapping(value="manage/modifyProduct", method = RequestMethod.GET)
	public String modifyProductView(Model model, @RequestParam("name")String name) {
		ProductDomain product = productSelectService.selectProduct(name);
		model.addAttribute("product", product);
		
		return "modifyProduct"; 
	}
	
	@RequestMapping(value="modifyProduct", method = RequestMethod.POST)
	public String modifyProduct(@ModelAttribute("product")Product product, @RequestParam("name")String name) {
		modifyProduct.modifyProduct(product, name);
		return "redirect:/manage/manageProduct";
	}
	
	@RequestMapping(value ="manage/deleteProduct")
	public String deleteProduct(@RequestParam("name")String name) {
		productService.remove(name);
		return "redirect:/manage/manageProduct";
	}
	
	@RequestMapping(value="manage/manageUser", method=RequestMethod.GET)
	public String manageUserView(Model model) {
		List<UserDomain> list = selectAllUser.SelectAll();
		model.addAttribute("list", list);
		return "manageUser";
	}
}
