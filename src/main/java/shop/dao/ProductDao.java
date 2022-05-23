package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import shop.domain.ProductDomain;
import shop.dto.Product;
import shop.dto.Product;
import shop.jpa.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;

	public List<ProductDomain> selectByDevice(String category) {
		//List<Product> results = jdbc.query("select * from PRODUCT where device = ?", productMapper, device);
		List<ProductDomain> results = productRepository.findAllByCategory(category);
		return results.isEmpty() ? null : results;
	}
	public List<ProductDomain> selectAll() {
		//List<Product> results = jdbc.query("select * from PRODUCT order by idProduct desc", productMapper);
		List<ProductDomain> results = productRepository.findAll();
		return results.isEmpty() ? null : results;
	}
	public ProductDomain selectByName(String name) {
		//List<Product> results = jdbc.query("select * from PRODUCT where name = ?", productMapper, name);
		ProductDomain results = productRepository.findByName(name);
		return results == null ? null : results;
	}
	
	public void insert(Product product) {
		//jdbc.update("insert into PRODUCT(NAME, PRICE, DEVICE, CONTENT, FILE_NAME, FILE_PATH) values(?, ?, ?, ?, ?, ?)"
				//,product.getName(), product.getPrice(), product.getCategory(), product.getContent(), product.getFile_name(), product.getFile_path());
		ProductDomain productDomain = ProductDomain.builder()
				.name(product.getName())
				.price(product.getPrice())
				.file_name(product.getFile_name())
				.file_path(product.getFile_path())
				.category(product.getCategory())
				.content(product.getContent())
				.build();

		productRepository.save(productDomain);
	}
	public void updateProduct(Product product, String name) {
		//jdbc.update("update PRODUCT set name = ?, price = ?, device = ?, content = ? where name = ?",
				//product.getName(), product.getPrice(), product.getCategory(), product.getContent(), name);
	}
	public void deleteProduct(String name) {
		//jdbc.update("delete from PRODUCT where name = ?", name);
	}
	
}
