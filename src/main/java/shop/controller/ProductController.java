package shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import shop.domain.ProductDomain;
import shop.dto.Product;
import shop.service.AddProductService;
import shop.service.ProductListService;
import shop.service.ProductSelectService;

@Controller
public class ProductController {

	@Autowired
	private AddProductService addProductService;
	@Autowired
	private ProductListService productListService;
	@Autowired
	private ProductSelectService productSelectService;
	
	
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProductView(@ModelAttribute("product") Product product) {

		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest req, HttpServletResponse response, MultipartFile file, @ModelAttribute("product")Product product)
			throws IOException {
		String originalName = file.getOriginalFilename();
		String uploadPath = req.getServletContext().getRealPath("/img");
		File target = new File(uploadPath, originalName);
		OutputStream out = null;
		if(!new File(uploadPath).exists()) {
			new File(uploadPath).mkdirs();
		}
		try {
			String fileName = UUID.randomUUID().toString();
			String fileUrl = req.getContextPath() + "/img/" + fileName;
			product.setFile_name(fileName);
			product.setFile_path(fileUrl);
			byte[] bytes = file.getBytes();
			uploadPath = uploadPath + "/" + fileName;
			//파일 만들기
			out = new FileOutputStream(new File(uploadPath));
			out.write(bytes);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		addProductService.insert(product);
		
		
		
		return "Main";
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest req, HttpServletResponse response,
			MultipartHttpServletRequest multiFile) throws Exception {
		System.out.println("fileUpload 실행");
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		if (file != null) {
			if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				try {
					String fileName = file.getName();
					byte[] bytes = file.getBytes();
					String uploadPath = req.getServletContext().getRealPath("/img");
					//폴더 만들기
					File uploadFile = new File(uploadPath);
					if (!uploadFile.exists()) {
						uploadFile.mkdirs();
					}
					//파일 uuid이름 변경
					fileName = UUID.randomUUID().toString();
					uploadPath = uploadPath + "/" + fileName;
					System.out.println(uploadPath);
					//파일 만들기
					out = new FileOutputStream(new File(uploadPath));
					out.write(bytes);

					printWriter = response.getWriter();
					response.setContentType("text/html");
					String fileUrl = req.getContextPath() + "/img/" + fileName;
					
					json.addProperty("uploaded", 1);
					json.addProperty("fileName", fileName);
					json.addProperty("url", fileUrl);

					printWriter.println(json);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (out != null) {
						out.close();
					}
					if (printWriter != null) {
						printWriter.close();
					}
				}
			}
		}
		return null;
	}

	@RequestMapping(value="/ProductView", method=RequestMethod.GET)
	public String ProductView(@RequestParam("device") String device, Model model) {
		List<ProductDomain> list = productListService.productList(device);

		model.addAttribute("list", list);
		return "ProductView";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String ProductDetail(@RequestParam("name") String name, Model model) {
		System.out.println(name);
		ProductDomain product= productSelectService.selectProduct(name);
		model.addAttribute("product", product);
		return "detail";
	}
}
