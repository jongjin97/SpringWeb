package shop.service;

import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;

import java.util.List;

public interface CartService {
    void save(Product product, User user);
    List<Cart> getList(String email);
    void delete(long id);
}
