package shop.entity;

import lombok.Data;
import shop.dto.Product;
import shop.dto.User;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
public class CartDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
}
