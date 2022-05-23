package shop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String file_name;
    private String file_path;
    private String content;

    @Builder
    public ProductDomain(String name, int price, String category, String file_name, String file_path, String content){
        this.name = name;
        this.price = price;
        this.category = category;
        this.file_name = file_name;
        this.file_path = file_path;
        this.content = content;
    }
}
