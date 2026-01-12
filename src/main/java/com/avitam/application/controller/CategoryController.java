package com.avitam.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.avitam.application.model.Category;
import com.avitam.application.model.User;
import com.avitam.application.service.CategoryService;
import com.avitam.application.service.UserService;

@Controller
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;
	
	@GetMapping("/categories")
	public String categories(Model model,HttpSession session) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
		User user = (User) session.getAttribute("loggedUser");
        System.out.println(user.getFirstName());
        List<Category> categories=categoryService.getAllCategories();
        if(categories.size()==0) {
        	model.addAttribute("msg", "No Products Available at the Moment");
        }else {
        	model.addAttribute("user", user);
        	model.addAttribute("categories", categories);
        }
        return "categories";
	}
	private boolean isLoggedIn(HttpSession session) {
	    return session.getAttribute("loggedUser") != null;
	}

	
}
