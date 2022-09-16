package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import shop.dto.Cart;
import shop.service.CartService;
import shop.service.OrderService;
import shop.service.implement.OrderServiceImpl;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public String ProductPurchase(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Cart> cartList = cartService.getList(userDetails.getUsername());

        orderService.save(cartList);

        return "redirect:/main";
    }
}
