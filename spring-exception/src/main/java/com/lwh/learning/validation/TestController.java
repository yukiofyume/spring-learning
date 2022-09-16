package com.lwh.learning.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

/**
 * @Author: lwh
 * @Date: 2022年09月16日
 * @Describe: TODO
 */
@RestController
@Slf4j
@Validated
@RequestMapping("/valid")
public class TestController {

    @PostMapping("/test1")
    public String test1(@Validated @RequestBody TestVO testVO) {
        log.info("testEntity is {}", testVO);
        return "test1 valid success";
    }

    @PostMapping("/test2")
    public String test2(@Validated TestVO testVO) {
        log.info("testEntity is {}", testVO);
        return "test2 valid success";
    }

    @PostMapping("/test3")
    public String test3(@Email String email) {
        log.info("email is {}", email);
        return "email valid success";
    }
}
