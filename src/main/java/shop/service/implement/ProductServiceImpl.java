package shop.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.Product;
import shop.entity.ProductDomain;
import shop.jpa.ProductRepository;
import shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void remove(String name) {
        productRepository.removeByName(name);
    }

    @Override
    public List<Product> findAll() {
        List<ProductDomain> lists = productRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Product> result = lists.stream().map(productDomain -> modelMapper.map(productDomain, Product.class)).collect(Collectors.toList());

        return result;
    }

    @Override
    public void save(Product product) {
        ProductDomain domain = new ProductDomain(product);
        productRepository.save(domain);
    }

    @Override
    public Product findByProductName(String name) {
        ProductDomain domain = productRepository.findByName(name);

        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(domain, Product.class);

        return product;
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<ProductDomain> list = productRepository.findAllByCategory(category);
        ModelMapper modelMapper = new ModelMapper();
        List<Product> result = list.stream().map(
                productDomain -> modelMapper.map(productDomain, Product.class)).collect(Collectors.toList());

        return result;
    }
}
