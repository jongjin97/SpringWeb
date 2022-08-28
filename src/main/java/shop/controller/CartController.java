package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;
import shop.service.CartService;
import shop.service.UserService;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "cart/list")
    public String cartView(){
        //UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "myCart";
    }

    @PostMapping(value = "cart/addCart")
    public void addCart(@ModelAttribute("product")Product product){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findByEmail(userDetails.getUsername());

        cartService.save(product, user);
    }
}
