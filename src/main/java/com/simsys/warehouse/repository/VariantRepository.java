package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.VariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VariantRepository extends JpaRepository<VariantEntity, Long> {
    Optional<VariantEntity> findByGuid(UUID guid);

}
