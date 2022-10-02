package com.lwh.repository.primary;


import com.lwh.pojo.entity.primary.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> , JpaSpecificationExecutor<UserEntity> {
    List<UserEntity> findAllByUsername(String name);

    UserEntity findFirstByAgeBefore(int age);
}
