package shop.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;
import shop.entity.CartDomain;
import shop.jpa.CartRepository;
import shop.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Product product, User user) {
        Cart cart = new Cart(product, user);
        ModelMapper modelMapper = new ModelMapper();
        CartDomain cartDomain = modelMapper.map(cart, CartDomain.class);
        System.out.println(cartDomain.getProductCategory());
        cartRepository.save(cartDomain);
    }
}
