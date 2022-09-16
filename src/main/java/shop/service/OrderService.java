package shop.service;

import shop.dto.Cart;
import shop.entity.OrderDomain;
import shop.entity.ProductDomain;

import java.util.List;

public interface OrderService {
    void save(List<Cart> cartList);
}
