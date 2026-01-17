package com.avitam.application.controller;

import com.avitam.application.model.User;
import com.avitam.application.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

	@GetMapping("/")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupProcess( User user,Model model,
            RedirectAttributes redirectAttributes) {
        if(!userService.registerUser(user)) {
        	System.out.println("Failed");
        	model.addAttribute("user", new User());
        	model.addAttribute("dbMessage","Email already exists. Please try another.");
        	return "signup";
        }
		redirectAttributes.addFlashAttribute("msg","Login successful");
        return "redirect:/login"; 
    }
 
    @GetMapping("/login")
    public String test() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginProcess(@RequestParam String email,@RequestParam String password,Model model,HttpSession session) {
    	User user=userService.loginUser(email,password);
    	if(user==null) {
    		model.addAttribute("dbMessage","Invalid email or password");
    		return "login";
    	}
    	model.addAttribute("user", user);
    	session.setAttribute("loggedUser", user);
    	return "redirect:/categories";
    } 
    
    @GetMapping("/logout")
	public String logout(HttpSession session,Model model) {
	    session.invalidate();
	    return "redirect:/login";
	}
}