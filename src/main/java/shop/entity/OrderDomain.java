package shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.dto.Cart;

import javax.persistence.*;

@Entity(name = "orders")
@Getter
@NoArgsConstructor
@DynamicInsert
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_qty")
    private int productQty;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_price")
    private int product_Price;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "state", columnDefinition = "배송 준비")
    private String state;

    public OrderDomain(Cart cart){
        this.userId = cart.getUserId();
        this.userEmail = cart.getUserEmail();
        this.userName = cart.getUserName();
        this.productId = cart.getProductId();
        this.productName = cart.getProductName();
        this.productQty = cart.getProductQty();
        this.productCategory =  cart.getProductCategory();
        this.product_Price = cart.getProduct_Price();
        this.totalPrice = cart.getTotalPrice();
        this.filePath = cart.getFilePath();
    }
}
