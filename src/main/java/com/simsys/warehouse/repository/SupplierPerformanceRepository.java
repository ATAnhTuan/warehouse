package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SupplierPerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SupplierPerformanceRepository extends JpaRepository<SupplierPerformanceEntity, Long> {
    Optional<SupplierPerformanceEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
}
