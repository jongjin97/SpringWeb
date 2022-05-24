package shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shop.domain.ProductDomain;
import shop.dto.AddCart;
import shop.dto.Product;
import shop.service.ProductSelectService;

@Controller
public class CartController {
	@Autowired
	private ProductSelectService productSelectService;
	
	@RequestMapping(value ="/myCart/addCart", method = RequestMethod.POST)
	public String addCart(HttpServletResponse response, HttpServletRequest request, @ModelAttribute AddCart addCart, HttpSession session, Model model) {
		boolean contain = false;
		ProductDomain product = productSelectService.selectProduct(addCart.getName());
		List<ProductDomain> list;
		if(session.getAttribute("cart") != null) {
			list = (List<ProductDomain>) session.getAttribute("cart");
		} else {
			list = new ArrayList<ProductDomain>();
		}
		System.out.println(list.size());
		for(ProductDomain listproduct: list) {
			if(listproduct.getName().equals(product.getName())) {
				contain = true;
				break;
			}
		}
		if(!contain) {
			list.add(product);
		}
		session.setAttribute("cart", list);
		System.out.println(session.getAttribute("cart"));
		return "ProductView";
	}
	
	@RequestMapping(value ="/myCart/list", method = RequestMethod.GET)
	public String addCart(Model model, HttpSession session) {
		List<ProductDomain> cartList;
		if(session.getAttribute("cart") != null) {
			cartList = (List<ProductDomain>) session.getAttribute("cart");
		} else {
			cartList = new ArrayList<ProductDomain>();
		}
		int sum = 0;
		for(int i=0; i<cartList.size(); i++){
			sum += cartList.get(i).getPrice();
		}
		model.addAttribute("cart", cartList);
		model.addAttribute("sum", sum);
		return "myCart";
	}
	
	@RequestMapping(value ="/myCart/delete", method = RequestMethod.POST)
	public void deleteProduct(@RequestParam("name")String name ,Model model, HttpSession session) {
		List<ProductDomain> list = (List<ProductDomain>) session.getAttribute("cart");
		int sum =0;
		for(ProductDomain product : list) {
			if(product.getName().equals(name)) {
				list.remove(product);
				continue;
			}
			sum += product.getPrice();
		}
		model.addAttribute("sum", sum);
		session.setAttribute("cart", list);

	}
}
