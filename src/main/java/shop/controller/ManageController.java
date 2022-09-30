package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import shop.dto.User;
import shop.entity.OrderDomain;
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
	@Autowired
	private PagingAndSortingRepository<OrderDomain, Long> pagingAndSortingRepository;

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

	@PostMapping(value = "manage/deleteUser")
	public String DeleteUser(@RequestParam("email") String email){
		userService.deleteUser(email);

		return "redirect:/manage/manageUser";
	}

	@GetMapping("manage/manageOrder")
	public String OrderList(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") String page){
		Page<OrderDomain> orderPage = pagingAndSortingRepository.findAll(PageRequest.of(Integer.parseInt(page), 10));

		int totalPage = orderPage.getTotalPages();
		model.addAttribute("orders", orderPage.getContent());
		model.addAttribute("totalPage", totalPage);
		return "orderList";
	}
}
