package com.example.practiceauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

  @RequestMapping("/home")
  public String home() {
    return "home";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
