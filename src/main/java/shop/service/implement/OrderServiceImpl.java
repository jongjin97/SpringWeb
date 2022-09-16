package shop.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.Cart;
import shop.entity.OrderDomain;
import shop.jpa.OrderRepository;
import shop.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(List<Cart> cartList) {
        List<OrderDomain> orderDomainList = new ArrayList<>();

        for(Cart cart : cartList){
            orderDomainList.add(new OrderDomain(cart));
        }

        orderRepository.saveAll(orderDomainList);
    }
}
