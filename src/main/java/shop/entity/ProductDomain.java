package shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.dto.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "product")
@NoArgsConstructor
public class ProductDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private String category;
    private int qty;
    private String file_name;
    private String file_path;
    private String content;

    @Builder
    public ProductDomain(Product product){
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.qty = product.getQty();
        this.file_name = product.getFile_name();
        this.file_path = product.getFile_path();
        this.content = product.getContent();
    }
}
