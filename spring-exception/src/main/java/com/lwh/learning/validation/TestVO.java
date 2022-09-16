package com.lwh.learning.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Author: lwh
 * @Date: 2022年09月16日
 * @Describe: TODO
 */
@Data
public class TestVO {
    @Length(min = 4, max = 20, message = "id的长度必须在4-20之间")
    private String id;
    @NotBlank(message = "名称不能为空，空字符串也不允许")
    private String name;
    @Email(message = "请填写正确的邮箱地址")
    private String email;
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    private String sex;
}
