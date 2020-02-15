package com.moon.springBoot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moon.springBoot.bean.Greeting;

@Controller
public class NoJsonController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public String accessLoginPage (Model model) {
        return "/login";
    }
    
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Greeting login (
    		@RequestParam("username") String username, 
    		@RequestParam("password") String password, 
    		Model model) {
    	return new Greeting(counter.incrementAndGet(),
                String.format(template, username));
    }
    
    @PostMapping("/users/user")
    public @ResponseBody String addUser(
    		@RequestParam("img") MultipartFile file
    	) {
    	
    	String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String projectPath = "resources/";
        String filePath = "static/headImg/";
        File targetFile = new File(projectPath+filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(projectPath+filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    	return "0";
    }

}