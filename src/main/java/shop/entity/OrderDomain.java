package shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "orders")
@Getter
@NoArgsConstructor
@DynamicInsert
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productname;
    @Column(name = "product_price")
    private int productprice;
    @Column(name = "user_id")
    private Long userid;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_email")
    private String useremail;
    private String state;

    @Builder
    public OrderDomain(UserDomain userDomain, ProductDomain productDomain){
        this.productname = productDomain.getName();
        this.productprice = productDomain.getPrice();
        this.username = userDomain.getName();
        this.useremail = userDomain.getEmail();

    }
}
