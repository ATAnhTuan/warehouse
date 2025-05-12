package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ConsignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ConsignmentRepository extends JpaRepository<ConsignmentEntity, Long> {
    Optional<ConsignmentEntity> findByGuid(UUID guid);
    void deleteByGuid(UUID guid);
}
