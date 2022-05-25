package shop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.dto.Order;

import javax.persistence.*;

@Entity(name = "OrderList")
@Getter
@NoArgsConstructor
@DynamicInsert
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int productPrice;
    private String productCategory;
    private String productFile_name;
    private String productFile_path;
    private String userName;
    private String userEmail;
    @Column(columnDefinition = "varchar(255) default '배송 준비'")
    private String state;

    @Builder
    public OrderDomain(UserDomain userDomain, ProductDomain productDomain){
        this.productName = productDomain.getName();
        this.productPrice = productDomain.getPrice();
        this.productCategory = productDomain.getCategory();
        this.productFile_name = productDomain.getFile_name();
        this.productFile_path = productDomain.getFile_path();
        this.userName = userDomain.getName();
        this.userEmail = userDomain.getEmail();

    }
}
