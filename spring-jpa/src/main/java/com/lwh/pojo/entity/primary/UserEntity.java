package com.lwh.pojo.entity.primary;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: lwh
 * @Date: 2022年10月01日
 * @Describe: TODO
 */
@Data
@Entity
@Table(name = "t_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Integer age;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer status;
}
