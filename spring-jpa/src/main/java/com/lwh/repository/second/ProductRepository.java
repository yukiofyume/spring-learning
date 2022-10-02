package com.lwh.repository.second;

import com.lwh.pojo.entity.second.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: lwh
 * @Date: 2022年10月01日
 * @Describe: TODO
 */

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
