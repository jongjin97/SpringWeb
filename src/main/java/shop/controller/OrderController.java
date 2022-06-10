package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import shop.domain.OrderDomain;
import shop.domain.ProductDomain;
import shop.domain.UserDomain;
import shop.jpa.OrderRepository;
import shop.jpa.UserRepository;
import shop.service.OrderService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/product")
    public String OrderProduct(HttpSession session, Principal principal){

        List<ProductDomain> list = (List<ProductDomain>) session.getAttribute("cart");
        UserDomain userDomain = userRepository.findByEmail(principal.getName());

        List<OrderDomain> OrderList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            OrderList.add(OrderDomain.builder().userDomain(userDomain)
                    .productDomain(list.get(i))
                    .build());
        }

        orderService.save(OrderList);

        return "redirect:/main";
    }
}
