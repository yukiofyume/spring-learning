package com.lwh.pojo.entity.primary;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lwh
 * @Date: 2022年10月02日
 * @Describe: TODO
 */
@Data
@Table(name = "t_customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private String custAddress;
    private String custPhone;

    @OneToMany(targetEntity = LinkManEntity.class)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Set<LinkManEntity> linkManEntities = new HashSet<>();
}
