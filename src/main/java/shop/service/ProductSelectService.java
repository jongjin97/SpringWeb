package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;
import shop.domain.ProductDomain;
import shop.dto.Product;

@Service
public class ProductSelectService {
	@Autowired
	private ProductDao productDao;
	
	public ProductDomain selectProduct(String name) {
		ProductDomain product = productDao.selectByName(name);
		return product;
	}
}
