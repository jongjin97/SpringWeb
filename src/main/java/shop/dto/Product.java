package shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private String name;
	private int price;
	private String category;
	private String file_name;
	private String file_path;
	private String content;
	
	public Product() {}
	public Product(String name, int price, String catgory, String file_name, String file_path, String content) {
		this.name = name;
		this.price = price;
		this.category = catgory;
		this.file_name = file_name;
		this.file_path = file_path;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String catrgory) {
		this.category = catrgory;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
