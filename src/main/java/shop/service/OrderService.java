package shop.service;

import shop.domain.OrderDomain;
import shop.dto.Order;

import java.util.List;

public interface OrderService {
    void save(List<OrderDomain> order);
}
