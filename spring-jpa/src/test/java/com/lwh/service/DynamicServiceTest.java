package com.lwh.service;

import com.lwh.pojo.entity.primary.UserEntity;
import com.lwh.repository.primary.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class DynamicServiceTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 单条件查询
     */
    @Test
    void conditionTest() {
        Specification<UserEntity> emailSpec = (root, query, criteriaBuilder) -> {
            // 1.获取比较的属性,实体类的属性
            Path<Object> email = root.get("email");
            // 2.构造查询条件
            return criteriaBuilder.equal(email, "853031414@qq.com0.8608023836486431");
        };
        List<UserEntity> all = userRepository.findAll(emailSpec);
        all.forEach(user -> log.info("当前查询出来的用户为=={}", user));
    }

    /**
     * 多条件查询
     */
    @Test
    void multiFindTest() {
        Specification<UserEntity> spec = (root, query, criteriaBuilder) -> {
            // 1.获取属性
            Path<Object> age = root.get("age");
            Path<Object> username = root.get("username");
            // 2.构造查询
            Predicate q1 = criteriaBuilder.equal(age, 25);
            Predicate q2 = criteriaBuilder.equal(username, "lwh");
            return criteriaBuilder.and(q1, q2);
        };
        List<UserEntity> all = userRepository.findAll(spec);
        all.forEach(user -> log.info("当前查询出来的用户为=={}", user));
    }

    /**
     * 模糊查询
     */
    @Test
    void fuzzyFindTest() {
        Specification<UserEntity> spec = (root, query, criteriaBuilder) -> {
            Path<Object> email = root.get("email");
            return criteriaBuilder.like(email.as(String.class), "%8530%");
        };
        List<UserEntity> all = userRepository.findAll(spec);
        all.forEach(user -> log.info("当前用户为=={}", user));
    }

    /**
     * 分页查询
     */
    @Test
    void pageFindTest() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        Page<UserEntity> all = userRepository.findAll(pageRequest);
        log.info("查询总页数为=={}", all.getTotalPages());
        log.info("查询总记录数为=={}", all.getTotalElements());
        log.info("数据集合列表=={}", all.getContent());
    }

}