package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SuggestPurchaseOrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestPurchaseOrderProductRepository extends JpaRepository<SuggestPurchaseOrderProductEntity, Long> {
}
