package shop.service;

import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;

public interface CartService {
    void save(Product product, User user);
}
