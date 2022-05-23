package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDao;
import shop.domain.ProductDomain;
import shop.dto.Product;

@Service
public class ProductListService {
	@Autowired
	private ProductDao productDao;
	
	public List<ProductDomain> productList(String device){
		List<ProductDomain> list = productDao.selectByDevice(device);
		return list;
	}
	
}
