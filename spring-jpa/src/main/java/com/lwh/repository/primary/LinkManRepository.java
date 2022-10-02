package com.lwh.repository.primary;

import com.lwh.pojo.entity.primary.LinkManEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lwh
 * @Date 2022-10-02 17:15
 * @Describe TODO
 */
public interface LinkManRepository extends JpaRepository<LinkManEntity, Long>, JpaSpecificationExecutor<LinkManEntity> {
}
