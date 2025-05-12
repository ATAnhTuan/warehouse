package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Long> {
    Optional<PurchaseOrderEntity> findByGuid(UUID guid);
}
