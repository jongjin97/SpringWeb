package shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.domain.OrderDomain;

import javax.persistence.GeneratedValue;

@Getter
@NoArgsConstructor
public class Order {
    private Long id;
    private String productName;
    private String productPrice;
    private String productCategory;
    private String productFile_name;
    private String productFile_path;
    private String userName;
    private String userEmail;
    private String state;


}
