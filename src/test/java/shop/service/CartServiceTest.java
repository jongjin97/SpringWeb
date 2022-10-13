package shop.service;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import shop.dto.Cart;
import shop.dto.Product;
import shop.dto.User;
import shop.entity.CartDomain;
import shop.jpa.CartRepository;
import shop.service.implement.CartServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CartServiceTest {

    @Autowired
    private CartServiceImpl cartService;
    @MockBean
    private CartRepository cartRepository;

    @Test
    void save() {
        Product product = getProduct();
        User user = getUser();
        Cart cart = new Cart(product, user);
        ModelMapper modelMapper = new ModelMapper();
        CartDomain cartDomain = modelMapper.map(cart, CartDomain.class);

        cartService.save(product, user);

        verify(cartRepository).save(cartDomain);
    }

    @Test
    void getList() {
        List<CartDomain> cartList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        Cart cart = new Cart(getProduct(), getUser());
        CartDomain cartDomain = modelMapper.map(cart, CartDomain.class);
        cartList.add(cartDomain);

        given(cartRepository.findByUserEmail(getUser().getEmail())).willReturn(cartList);

        List<Cart> list = cartService.getList(getUser().getEmail());

        assertEquals(list.size(), cartList.size());
    }

    @Test
    void delete() {

        cartService.delete(getUser().getId());

        verify(cartRepository).deleteById(getUser().getId());
    }

    Product getProduct(){
        Product product = Product.builder()
                .name("test")
                .qty(10)
                .price(10000)
                .file_name("fileName")
                .file_path("filePath")
                .content("content")
                .id(5)
                .build();
        return product;
    }

    User getUser(){
        User user = new User("test", "test@test.com" ,"test");
        user.setId(1);
        return user;
    }
}