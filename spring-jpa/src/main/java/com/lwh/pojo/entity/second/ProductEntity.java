package com.lwh.pojo.entity.second;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: lwh
 * @Date: 2022年10月01日
 * @Describe: TODO
 */
@Data
@Entity
@Table(name = "t_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double price;
}
