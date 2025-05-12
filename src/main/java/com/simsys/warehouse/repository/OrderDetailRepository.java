package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
    Optional<OrderDetailEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
    List<OrderDetailEntity> findAllByOrderGuid(UUID orderGuid);
}
