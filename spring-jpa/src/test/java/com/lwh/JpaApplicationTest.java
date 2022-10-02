package com.lwh;

import com.lwh.pojo.entity.primary.UserEntity;
import com.lwh.pojo.entity.second.ProductEntity;
import com.lwh.repository.second.ProductRepository;
import com.lwh.repository.primary.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
class JpaApplicationTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("transactionManagerPrimary")
    @Rollback(value = false)
    void insertUser() {
        Random random = new Random(1);
        for (int i = 0; i < 100; i++) {
            UserEntity user = new UserEntity();
            user.setUsername("lwh");
            user.setEmail("853031414@qq.com" + Math.random());
            user.setAge(25);
            user.setStatus(1);
            userRepository.save(user);
        }
    }

    @Test
    void selectTest() {
        List<UserEntity> lwh = userRepository.findAllByUsername("lwh");
        lwh.forEach(System.out::println);
    }

    @Test
    void findAge() {
        UserEntity firstByAgeBefore = userRepository.findFirstByAgeBefore(56);
       log.info("返回的用户数据为:{}",firstByAgeBefore);
    }
}