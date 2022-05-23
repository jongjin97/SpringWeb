package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;

@Service
public class DeleteProductService {
	@Autowired
	private ProductDao productDao;
	
	public void deleteProduct(String name) {
		productDao.deleteProduct(name);
	}
}
