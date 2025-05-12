package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
}
