package com.avitam.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.avitam.application.model.Category;
import com.avitam.application.model.Product;
import com.avitam.application.model.SubCategory;
import com.avitam.application.service.CategoryService;
import com.avitam.application.service.ProductService;
import com.avitam.application.service.SubCategoryService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	
    @GetMapping("/categories/{cat_id}/subcategories/{categoryId}/products")
    public String productinfo(@PathVariable int categoryId,@PathVariable int cat_id,Model model,HttpSession session) {
    	if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
    	List<Product> products=productService.fetchProductByCategory(categoryId);
    	Category category=categoryService.getCategoryById(cat_id);
    	SubCategory subCategory=subCategoryService.getSubCategoryById(categoryId);
    	System.out.println(subCategory.getId()+"-"+subCategory.getCategory_id()+" "+subCategory.getName());
    	model.addAttribute("subcategory",subCategory);
    	model.addAttribute("products", products);
    	model.addAttribute("category", category);
    	return "products";
    }
    
    @GetMapping("/categories/{categoryId}/subcategories/{sub_categoryId}/products/{productId}/details")
    public String viewProductDetails(@PathVariable int productId,Model model,HttpSession session) {
    	if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
    	Product product=productService.findProductById(productId);
    	model.addAttribute("product",product);
    	return "view-details";
    }
    private boolean isLoggedIn(HttpSession session) {
	    return session.getAttribute("loggedUser") != null;
	}
}
