package com.pos.comm.poscomm.controller;

import com.pos.comm.poscomm.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class commSummary {
    @Autowired
    EmailService emailService;

    @GetMapping("/user/sendPasswordForgetMail")
    ResponseEntity<String> sendForgetPasswordMail(@RequestParam(value="mail") String mail,
                                                  @RequestParam(value="password") String password){
    return new ResponseEntity<>(emailService.sendMail(mail,password), HttpStatus.OK);
    }

}
