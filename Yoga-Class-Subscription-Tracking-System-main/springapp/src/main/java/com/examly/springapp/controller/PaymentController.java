package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping("/pay")
    public String payment() {
        return "payment";
    }
}