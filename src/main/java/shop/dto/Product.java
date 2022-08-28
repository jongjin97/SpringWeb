package shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class Product {
	private long id;
	private String name;
	private int price;
	private String category;
	private int qty;
	private String file_name;
	private String file_path;
	private String content;

}
