package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Optional<SupplierEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
}
