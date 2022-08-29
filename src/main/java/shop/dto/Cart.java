package shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class Cart {
    private long id;
    private long userId;
    private String userEmail;
    private String userName;
    private long productId;
    private String productName;
    private int productQty;
    private int product_Price;
    private int totalPrice;
    private String productCategory;
    private String filePath;


    public Cart(Product product, User user){
        this.userEmail = user.getEmail();
        this.userId = user.getId();
        this.userName = user.getName();
        this.product_Price = product.getPrice();
        this.productCategory = product.getCategory();
        this.productId = product.getId();
        this.productName = product.getName();
        this.productQty = product.getQty();
        this.totalPrice = product.getQty() * product.getPrice();
        this.filePath = product.getFile_path();
    }

    public void size(){}
}
