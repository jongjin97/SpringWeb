package shop.domain;

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
    private String productname;
    private int productprice;
    private String username;
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
