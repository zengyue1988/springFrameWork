package com.moon.springSecurity.fast.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class LoginController {
	
    @GetMapping("/login.html")
    public String loginPage() {
        return "This is login page, you must login to proceed";
    }
    
    @GetMapping("/home")
    public String homePage() {
        return "This is home page";
    }
    
    @PreAuthorize("hasAuthority('forgetPassword')")
    @GetMapping("/pre/forgetPassword")
    public String forgetPassword() {
        return "This is forget password page";
    }
    
    @GetMapping("/pre/register")
    public String register() {
        return "This is registration page";
    }
    
    @GetMapping("/login-error")
    public String loginError() {
        return "This is login error page";
    }
    
    @GetMapping("/user/index")
    public String userIndex() {
        return "This is user index page";
    }
    
    @GetMapping("/whoami")
    public Object whoami() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
