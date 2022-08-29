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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Product product, User user) {
        Cart cart = new Cart(product, user);
        ModelMapper modelMapper = new ModelMapper();
        CartDomain cartDomain = modelMapper.map(cart, CartDomain.class);
        cartRepository.save(cartDomain);
    }

    @Override
    public List<Cart> getList(String email) {
        List<CartDomain> cartDomains = cartRepository.findByUserEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        List<Cart> list = cartDomains.stream().map(
                cartDomain -> modelMapper.map(cartDomain, Cart.class)).collect(Collectors.toList());

        return list;
    }

    @Override
    public void delete(long id) {
        cartRepository.deleteById(id);
    }
}
