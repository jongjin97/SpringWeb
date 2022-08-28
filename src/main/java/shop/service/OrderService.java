package shop.service;

import shop.entity.OrderDomain;
import shop.entity.ProductDomain;

import java.util.List;

public interface OrderService {
    void save(List<OrderDomain> order);
}
