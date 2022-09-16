package shop.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class Product {
	private long id;
	private String name;
	private int price;
	private String category;
	@Min(value = 1)
	private int qty;
	private String file_name;
	private String file_path;
	private String content;

}
