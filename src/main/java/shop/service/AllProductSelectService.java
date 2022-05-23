package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;
import shop.domain.ProductDomain;
import shop.dto.Product;

@Service
public class AllProductSelectService {
	@Autowired
	private ProductDao productDao;
	
	public List<ProductDomain> productList(){
		List<ProductDomain> list = productDao.selectAll();
		return list;
	}
}
