package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;
import shop.service.CartService;
import shop.service.UserService;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "cart/list")
    public String cartView(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Cart> list = cartService.getList(userDetails.getUsername());
        model.addAttribute("cart", list);
        return "myCart";
    }

    @PostMapping(value = "cart/addCart")
    public void addCart(@Validated @ModelAttribute("product")Product product){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findByEmail(userDetails.getUsername());

        cartService.save(product, user);
    }

    @PostMapping(value = "cart/{id}")
    public String deleteCart(@PathVariable(name = "id")String id){
        long cartId = Long.parseLong(id);
        cartService.delete(cartId);
        return "redirect:/cart/list";
    }
}
