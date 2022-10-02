package com.lwh;

import com.lwh.pojo.entity.primary.UserEntity;
import com.lwh.pojo.entity.second.ProductEntity;
import com.lwh.repository.second.ProductRepository;
import com.lwh.repository.primary.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class JpaApplicationTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("transactionManagerPrimary")
    @Rollback(value = false)
    void  insertUser(){
        UserEntity user = new UserEntity();
        user.setUsername("lwh");
        user.setEmail("8530314414@qq.com");
        userRepository.save(user);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("iPhone");
        productEntity.setPrice(10999.0);
        productRepository.save(productEntity);
    }
}