package com.moon.mail.controller;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MailController {

	@Autowired
	JavaMailSender jms;

    /**
     * @param name
     * @return
     */
    @GetMapping("/api/v1/pre/sendMail")
    public String sendMail() {
		SimpleMailMessage mainMessage = new SimpleMailMessage();		
		mainMessage.setFrom("bet_sweet_zy@163.com");		
		mainMessage.setTo("404955453@qq.com");		
		mainMessage.setSubject("Moon Test Mail");		
		mainMessage.setText("Hello, I am Zeng Yue.");		
		jms.send(mainMessage);		
		return "true";
    }
    
    @GetMapping("/api/v1/pre/sendFile")
    public String sendFile() {
    	String [] fileArray={"F:\\temp1\\照片\\faceu_0_20190525162504.jpg","F:\\temp1\\照片\\faceu_0_20190525162516.jpg"};
    	MimeMessage message = jms.createMimeMessage();
    	try {
	    	MimeMessageHelper helper = new MimeMessageHelper(message,true);		
	    	helper.setFrom("bet_sweet_zy@163.com");		
	    	helper.setTo("404955453@qq.com");		
	    	helper.setSubject("Moon Test Mail");		
	    	helper.setText("Hello, I am Zeng Yue.");		
			
			if(null != fileArray){
	        	FileSystemResource file=null;
	        	for (int i = 0; i < fileArray.length; i++) {
	        		file=new FileSystemResource(fileArray[i]);
					helper.addAttachment(fileArray[i].substring(fileArray[i].lastIndexOf(File.separator)), file);
	        	}
	        }
    	} catch (MessagingException e) {
			e.printStackTrace();
		}
		jms.send(message);		
		return "true";
    }

    @GetMapping("/api/v1/pre/sendAttachment")
    public String sendAttachment(MailVo mailVo) {
    	try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(jms.createMimeMessage(), true);//true表示支持复杂类型
            mailVo.setFrom("bet_sweet_zy@163.com");//邮件发信人从配置项读取
            messageHelper.setFrom(mailVo.getFrom());//邮件发信人
            messageHelper.setTo(mailVo.getTo().split(","));//邮件收信人
            messageHelper.setSubject(mailVo.getSubject());//邮件主题
            messageHelper.setText(mailVo.getText());//邮件内容
            if (!StringUtils.isEmpty(mailVo.getCc())) {//抄送
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            if (!StringUtils.isEmpty(mailVo.getBcc())) {//密送
                messageHelper.setCc(mailVo.getBcc().split(","));
            }
            if (mailVo.getMultipartFiles() != null) {//添加邮件附件
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (StringUtils.isEmpty(mailVo.getSentDate())) {//发送时间
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(mailVo.getSentDate());
            }
            jms.send(messageHelper.getMimeMessage());		//正式发送邮件
            mailVo.setStatus("ok");
        } catch (Exception e) {
            throw new RuntimeException(e);//发送失败
        }
    	return "true";
    }
    
}