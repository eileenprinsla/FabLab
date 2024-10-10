package com.FabLab.FabLab.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send-user/email/accept/{toEmail}/{slot}")
    public String SendAcceptEmail(@PathVariable String toEmail, @PathVariable String slot) {
        mailService.sendEmail(toEmail, "Request accepted", "Your Request for" + slot + "was accepted by the Admin");
        return "Accept Email sent successfully!";
    }

    @PostMapping("/send-user/email/reject/{toEmail}/{slot}")
    public String SendRejectEmail(@PathVariable String toEmail, @PathVariable String slot) {
        mailService.sendEmail(toEmail, "Request rejected", "Your Request for" + slot + " was rejected by the Admin");
        return "Reject Email sent successfully!";
    }

    @PostMapping("/send-user/email/custom/{toEmail}/{slot}")
    public String SendCustomEmail(@PathVariable String toEmail, @RequestParam String subject, @RequestParam String text, @PathVariable String slot) {
        mailService.sendEmail(toEmail, subject, text);
        return "Custom Email sent successfully!";
    }

    @PostMapping("/send-admin/email/{slot}")
    public String RequestPopUpEmail(@RequestParam String slot) {
        mailService.sendEmail("admin@gmail.com", "User requesting for"+ slot,"Request from User");
        return "Admin notification email sent successfully!";
    }

}
