package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;
import shop.dto.Product;

@Service
public class ModifyProduct {
	@Autowired
	private ProductDao productDao;
	
	public void modifyProduct(Product product, String name) {
		productDao.updateProduct(product, name);
	}
	
}
