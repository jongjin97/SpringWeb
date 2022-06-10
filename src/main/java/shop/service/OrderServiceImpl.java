package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.OrderDomain;
import shop.dto.Order;
import shop.jpa.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void save(List<OrderDomain> order) {
        orderRepository.saveAll(order);
    }
}
