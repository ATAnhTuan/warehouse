package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SuggestPurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestPurchaseOrderRepository extends JpaRepository<SuggestPurchaseOrderEntity, Long> {
}
