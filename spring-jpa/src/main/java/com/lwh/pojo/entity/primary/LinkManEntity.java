package com.lwh.pojo.entity.primary;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: lwh
 * @Date: 2022年10月02日
 * @Describe: TODO
 */
@Data
@Entity
@Table(name = "cst_linkman")
public class LinkManEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lkmId;
    private String lkmName;
    private String lkmGender;
    private String lkmPhone;
    private String lkmEmail;
    private String lkmPosition;
    private String lkmMemo;

    @ManyToOne(targetEntity = CustomerEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private CustomerEntity customerEntity;
}
