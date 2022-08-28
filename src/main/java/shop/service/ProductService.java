package shop.service;

import shop.dto.Product;
import shop.entity.ProductDomain;

import java.util.List;

public interface ProductService {
    public void remove(String name);
    List<Product> findAll();
    void save(Product product);
    Product findByProductName(String name);
    List<Product> findByCategory(String category);
}
