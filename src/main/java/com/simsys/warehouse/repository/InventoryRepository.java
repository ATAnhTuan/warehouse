package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
    List<InventoryEntity> findByUserGuid(UUID userGuid);
}
