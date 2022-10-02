package com.lwh.repository.primary;

import com.lwh.pojo.entity.primary.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lwh
 * @Date 2022-10-02 17:14
 * @Describe TODO
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {
}
