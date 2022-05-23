package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;
import shop.dto.Product;

@Service
public class AddProductService {
	@Autowired
	private ProductDao productDao;
	
	public void insert(Product product) {
		productDao.insert(product);
		
	}
}
