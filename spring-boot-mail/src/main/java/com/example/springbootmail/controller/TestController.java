package com.example.springbootmail.controller;

import com.example.springbootmail.Mail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zitao.li on 2018/8/2.
 */
@RestController
@RequestMapping("/mail")
public class TestController {
    @Resource
    private Mail mail;

    @RequestMapping("/send/simple")
    public String simpleMail(){
        try {
            mail.sendSimpleMail();
            return "send success";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @RequestMapping("/send/attachment")
    public String attachmentMail(){
        try {
            mail.sendAttachmentsMail();
            return "send success";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @RequestMapping("/send/inline")
    public String inlineMail(){
        try {
            mail.sendInlineMail();
            return "send success";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
