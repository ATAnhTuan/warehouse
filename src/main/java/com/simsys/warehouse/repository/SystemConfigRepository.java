package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SystemConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfigEntity, Long> {
    boolean existsByName(String name);
}
