package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Integer> {
}
