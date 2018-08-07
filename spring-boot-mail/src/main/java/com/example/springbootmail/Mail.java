package com.example.springbootmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zitao.li on 2018/8/2.
 */
@Component
public class Mail {
    @Autowired
    private JavaMailSender mailSender;
//    @Autowired
//    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 发送简单邮件
     * @throws Exception
     */
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(sender);
        message.setSubject("主题:简单邮件测试");
        message.setText("简单邮件内容测试");
        mailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     * @throws Exception
     */
    public void sendAttachmentsMail() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(sender);
        helper.setTo(sender);
        helper.setSubject("主题：带附件邮件测试");
        helper.setText("带附件邮件测试");

        FileSystemResource file = new FileSystemResource(new File("test.jpg"));
        helper.addAttachment("附件1", file);
        helper.addAttachment("附件2", file);

        mailSender.send(mimeMessage);
    }

    /**
     * 发送嵌入静态资源的邮件
     * @throws Exception
     */
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(sender);
        helper.setTo(sender);
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:test\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("test.jpg"));
        helper.addInline("test", file);

        mailSender.send(mimeMessage);
    }

    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(sender);
        helper.setFrom(sender);
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashMap<>();
        model.put("username", "test");

//        templateEngine.process("index", "测试");
    }
}
