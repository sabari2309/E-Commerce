package com.avitam.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avitam.application.model.SubCategory;
import com.avitam.application.model.User;
import com.avitam.application.service.CategoryService;
import com.avitam.application.service.SubCategoryService;

@Controller
public class SubCategoryController {
    
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
    private CategoryService categoryService;
	@GetMapping("/categories/{category_id}/sub-categories")
    public String sub_category(@PathVariable int category_id,Model model,HttpSession session) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
      List<SubCategory> subCategories=subCategoryService.getSubCategoriesById(category_id);
      model.addAttribute("category", categoryService.getCategoryById(category_id));
      model.addAttribute("subCategories", subCategories);
      return "subcategories";
  }
	private boolean isLoggedIn(HttpSession session) {
	    return session.getAttribute("loggedUser") != null;
	}
}
